package com.github.kyrenesjtv.demo.demo.poi;

import com.github.kyrenesjtv.demo.demo.domain.SellerLogisticsCompanyBo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/10/25 16:11
 */
public class MulRowExport {

    public static void main(String[] args) {
        try {
            boolean createExcelFile = createExcelFile();
            if (createExcelFile) {
                System.out.println("SXSSF_excel导出成功");
            } else {
                System.out.println("SXSSFexcel导出失败");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static boolean createExcelFile() throws Exception {

        boolean state = false;
        OutputStream os = null;
        FileOutputStream fos = null;
        String resultFileName = null;
        String fileName = "";
        try {
            fileName = System.currentTimeMillis()+".xlsx";
            Workbook wb = createWorkBook01();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            resultFileName = "D:\\" + File.separator + "excel" + File.separator + sdf.format(new Date())
                    + File.separator + fileName;
            resultFileName = resultFileName.replaceAll("\\\\", "/");
            File file = new File(resultFileName);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            fos = new FileOutputStream(file);
            os = new BufferedOutputStream(fos, 1024);
            wb.write(os);
            os.flush();
            state = true;
        } finally {
            if (os != null)
                os.close();
        }
        return state;
    }




    //参数说明:  fileName：文件名   projects：对象集合  columnNames： 列名   keys： map中的key
    public static void start_download(HttpServletResponse response, String fileName, List<?> projects,
                                      String[] columnNames, String[] keys) throws IOException {

        //将集合中对象的属性  对应到  List<Map<String,Object>>
//        List<Map<String,Object>> list=createExcelRecord(projects, keys);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            //将转换成的Workbook对象通过流形式下载
//            createWorkBook(list,keys,columnNames).write(os);
            Workbook workBook01 = createWorkBook01();
            workBook01.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
    }

    private static List<Map<String, Object>> createExcelRecord(List<?> projects, String[] keys) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet");
        listmap.add(map);
        Object project=null;
        for (int j = 0; j < projects.size(); j++) {
            project=projects.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            for(int i=0; i<keys.length; i++){
                mapValue.put(keys[i], getFieldValueByName(keys[i], project));
            }

            listmap.add(mapValue);
        }
        return listmap;
    }
    /**
     * 利用反射  根据属性名获取属性值
     * */
    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 创建excel文档对象
     * @param keys list中map的key数组集合
     * @param columnNames excel的列名
     * */
    private static Workbook createWorkBook(List<Map<String, Object>> list, String []keys, String columnNames[]) {
        // 创建excel工作簿
        Workbook wb = new HSSFWorkbook();
        // 创建第一个sheet（页），并命名
        Sheet sheet = wb.createSheet(list.get(0).get("sheetName").toString());
        // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
        for(int i=0;i<keys.length;i++){
            sheet.setColumnWidth((short) i, (short) (35.7 * 150));
        }

        // 创建第一行
        Row row = sheet.createRow((short) 0);

        // 创建两种单元格格式
        CellStyle cs = wb.createCellStyle();
        CellStyle cs2 = wb.createCellStyle();

        // 创建两种字体
        Font f = wb.createFont();
        Font f2 = wb.createFont();

        // 创建第一种字体样式（用于列名）
        f.setFontHeightInPoints((short) 10);
        f.setColor(IndexedColors.BLACK.getIndex());
        f.setBoldweight(Font.BOLDWEIGHT_BOLD);

        // 创建第二种字体样式（用于值）
        f2.setFontHeightInPoints((short) 10);
        f2.setColor(IndexedColors.BLACK.getIndex());

        // 设置第一种单元格的样式（用于列名）
        cs.setFont(f);
        cs.setBorderLeft(CellStyle.BORDER_THIN);
        cs.setBorderRight(CellStyle.BORDER_THIN);
        cs.setBorderTop(CellStyle.BORDER_THIN);
        cs.setBorderBottom(CellStyle.BORDER_THIN);
        cs.setAlignment(CellStyle.ALIGN_CENTER);

        // 设置第二种单元格的样式（用于值）
        cs2.setFont(f2);
        cs2.setBorderLeft(CellStyle.BORDER_THIN);
        cs2.setBorderRight(CellStyle.BORDER_THIN);
        cs2.setBorderTop(CellStyle.BORDER_THIN);
        cs2.setBorderBottom(CellStyle.BORDER_THIN);
        cs2.setAlignment(CellStyle.ALIGN_CENTER);
        //设置列名
        for(int i=0;i<columnNames.length;i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(cs);
        }
        //设置每行每列的值
        for (short i = 1; i < list.size(); i++) {
            // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
            // 创建一行，在页sheet上
            Row row1 = sheet.createRow((short) i);
            // 在row行上创建一个方格
            for(short j=0;j<keys.length;j++){
                Cell cell = row1.createCell(j);
                cell.setCellValue(list.get(i).get(keys[j]) == null?" ": list.get(i).get(keys[j]).toString());
                cell.setCellStyle(cs2);
            }
        }
        return wb;
    }




    private static Workbook createWorkBook01() {
        // 创建excel工作簿
        Workbook wb = new HSSFWorkbook();
        // 创建第一个sheet（页），并命名
        Sheet sheet = wb.createSheet("sheet01");
        // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
//        for(int i=0;i<keys.length;i++){
//            sheet.setColumnWidth((short) i, (short) (35.7 * 150));
//        }

        // 创建第一行
        Row row = sheet.createRow((short) 0);

        // 创建两种单元格格式
        CellStyle cs = wb.createCellStyle();
        CellStyle cs2 = wb.createCellStyle();

        // 创建两种字体
        Font f = wb.createFont();
        Font f2 = wb.createFont();

        // 创建第一种字体样式（用于列名）
        f.setFontHeightInPoints((short) 10);
        f.setColor(IndexedColors.BLACK.getIndex());
        f.setBoldweight(Font.BOLDWEIGHT_BOLD);

        // 创建第二种字体样式（用于值）
        f2.setFontHeightInPoints((short) 10);
        f2.setColor(IndexedColors.BLACK.getIndex());

        // 设置第一种单元格的样式（用于列名）
        cs.setFont(f);
        cs.setBorderLeft(CellStyle.BORDER_THIN);
        cs.setBorderRight(CellStyle.BORDER_THIN);
        cs.setBorderTop(CellStyle.BORDER_THIN);
        cs.setBorderBottom(CellStyle.BORDER_THIN);
        cs.setAlignment(CellStyle.ALIGN_CENTER);

        // 设置第二种单元格的样式（用于值）
        cs2.setFont(f2);
        cs2.setBorderLeft(CellStyle.BORDER_THIN);
        cs2.setBorderRight(CellStyle.BORDER_THIN);
        cs2.setBorderTop(CellStyle.BORDER_THIN);
        cs2.setBorderBottom(CellStyle.BORDER_THIN);
        cs2.setAlignment(CellStyle.ALIGN_CENTER);
        //设置列名
        String[] columnNames = {"SELLER_ID", "SELLE_NAME", "物流", "2021/10/20", "2021/10/21"};
        for(int i=0;i<columnNames.length;i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(cs);
        }

        List<SellerLogisticsCompanyBo> data = createData();

        //设置每行每列的值
        int z = 1;
        for (short i = 1; i < data.size(); i++) {
            // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
            // 创建一行，在页sheet上

            // 在row行上创建一个方格
            SellerLogisticsCompanyBo sellerLogisticsCompanyBo = data.get(i);
            List<SellerLogisticsCompanyBo.LogisticsCompanyStat> list = sellerLogisticsCompanyBo.getList();
            if(!list.isEmpty()){
                for (SellerLogisticsCompanyBo.LogisticsCompanyStat logisticsCompanyStat : list) {
                    Row row1 = sheet.createRow((short) z);

                    Cell cell0 = row1.createCell(0);
                    cell0.setCellValue(sellerLogisticsCompanyBo.getSellerId());
                    Cell cell1 = row1.createCell(1);
                    cell1.setCellValue(sellerLogisticsCompanyBo.getSellerNick());


                    Map<String, Integer> orderCountMap = logisticsCompanyStat.getOrderCountMap();
                    Cell cell2 = row1.createCell(2);
                    cell2.setCellValue(logisticsCompanyStat.getLogisticsName());
                    Cell cell3 = row1.createCell(3);
                    cell3.setCellValue(orderCountMap.get("2021/10/20"));
                    Cell cell4 = row1.createCell(4);
                    cell4.setCellValue(orderCountMap.get("2021/10/21"));
                    z++;
                }
            }

        }
        return wb;
    }

    private static List<SellerLogisticsCompanyBo> createData() {
        ArrayList<SellerLogisticsCompanyBo> sellerLogisticsCompanyBos = new ArrayList<>();
        for (int z = 0; z < 3; z++) {
            SellerLogisticsCompanyBo bo = new SellerLogisticsCompanyBo();
            bo.setSellerId(123L+z);
            bo.setSellerNick("123L"+z);

            List<SellerLogisticsCompanyBo.LogisticsCompanyStat> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                SellerLogisticsCompanyBo.LogisticsCompanyStat logisticsCompanyStat = new SellerLogisticsCompanyBo.LogisticsCompanyStat();
                logisticsCompanyStat.setLogisticsName("顺丰"+i);
                Map<String, Integer> orderCountMap = new ConcurrentHashMap<>();
                orderCountMap.put("2021/10/20", (int)(1+Math.random()*100));
                orderCountMap.put("2021/10/21", (int)(1+Math.random()*100));
                logisticsCompanyStat.setOrderCountMap(orderCountMap);
                list.add(logisticsCompanyStat);
            }
            bo.setList(list);
            sellerLogisticsCompanyBos.add(bo);
        }

        return sellerLogisticsCompanyBos;
    }


}
