//package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean;
//
//import java.util.*;
//
///**
// * TODO 一句话描述
// *
// * @author huojianxiong
// * 2021/9/17 18:56
// */
//public class PreDepart {
//    /**
//     * 结构
//     * <p>
//     * ┝开发部
//     * <p>
//     * ┝开发一部
//     * <p>
//     * ┝开发一组
//     * <p>
//     * ┝开发二组
//     * <p>
//     * ┝开发二部
//     * <p>
//     * ┝开发三组
//     * <p>
//     * ┝开发四组
//     * <p>
//     * ┝销售部
//     * <p>
//     * ┝销售一部
//     * <p>
//     * ┝销售二部
//     */
//
//    public static List findDepartTopList() {
//        //顶级
//
//        Depart depart1 = new Depart();
//
//        depart1.setName("开发部");
//
//        //二级
//
//        Depart depart1_1 = new Depart();
//
//        depart1_1.setName("开发一部");
//
//        //三级
//
//        Depart depart1_1_1 = new Depart();
//
//        depart1_1_1.setName("开发一组");
//
//        Depart depart1_1_2 = new Depart();
//
//        depart1_1_2.setName("开发二组");
//
//        Set departs1_1 = new HashSet();
//
//        departs1_1.add(depart1_1_1);
//
//        departs1_1.add(depart1_1_2);
//
//        depart1_1.setDeparts(departs1_1);
//
//        Depart depart1_2 = new Depart();
//
//        depart1_2.setName("开发二部");
//
//        Depart depart1_2_1 = new Depart();
//
//        depart1_2_1.setName("开发一组");
//
//        Depart depart1_2_2 = new Depart();
//
//        depart1_2_2.setName("开发二组");
//
//        Set departs1_2 = new HashSet();
//
//        departs1_2.add(depart1_1_1);
//
//        departs1_2.add(depart1_1_2);
//
//        depart1_2.setDeparts(departs1_1);
//
//        Set departs1 = new HashSet();
//
//        departs1.add(depart1_1);
//
//        departs1.add(depart1_2);
//
//        depart1.setDeparts(departs1);
//
//        //顶级
//
//        Depart depart2 = new Depart();
//
//        depart2.setName("销售部");
//
//        //二级
//
//        Depart depart2_1 = new Depart();
//
//        depart2_1.setName("销售一部");
//
//        Depart depart2_2 = new Depart();
//
//        depart2_2.setName("销售二部");
//
//        Set departs = new HashSet();
//
//        departs.add(depart2_1);
//
//        departs.add(depart2_2);
//
//        depart2.setDeparts(departs);
//
//        List list = new ArrayList();
//
//        list.add(depart1);
//
//        list.add(depart2);
//
//        return list;
//
//    }
//
//    public static void main(String[] args) {
//        List list = findDepartTopList();
//
//        //         for (Depart depart : list) {
//        //         getAllDepartName(depart);
//        //
//        //         }
//
//        getAllDepartName_2(list, "=");
//
//    }
//
//    /**
//     * 将所有的部门打印出来
//     */
//
//    public static void getAllDepartName(Depart depart) {
//        System.out.println(depart.getName());
//
//        for (Depart chirden : depart.getDeparts()) {
//            getAllDepartName(chirden);
//
//        }
//
//    }
//
//    /**
//     * 将所有的部门打印出来
//     */
//
//    public static void getAllDepartName_2(Collection list, String pre) {
//        for (Depart depart2 : list) {
//            System.out.println(pre + depart2.getName());
//
//            getAllDepartName_2(depart2.getDeparts(), " " + pre);
//
//        }
//
//    }
//}
