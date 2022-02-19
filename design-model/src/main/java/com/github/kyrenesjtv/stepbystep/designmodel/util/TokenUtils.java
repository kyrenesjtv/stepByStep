package com.github.kyrenesjtv.stepbystep.designmodel.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.*;

/**
 * @author huojianxiong
 * @Description TokenUtils
 * @Date 2022/2/19 23:48
 */
public class TokenUtils {

    private static void getSign(List list, StringBuffer stringBuffer) {
        for (int i = 0; i < list.size(); i++) {
            getSign(i + "", list.get(i), stringBuffer);
        }
    }


    public static String getSign(JSONObject jsonObject) {
        StringBuffer stringBuffer = new StringBuffer();
        getSign(jsonObject, stringBuffer);
        String sign;
        if (stringBuffer.length() <= 0) {
            sign = "";
        } else {
            sign = stringBuffer.substring(0, stringBuffer.length() - 1);
        }
        return sign;
    }

    private static void getSign(JSONObject jsonObject, StringBuffer stringBuffer) {
        List<String> keyList = new ArrayList<>(jsonObject.keySet());
        Collections.sort(keyList);
        for (String key : keyList) {
            getSign(key, jsonObject.get(key), stringBuffer);
        }
    }

    private static void getSign(String key, Object obj, StringBuffer stringBuffer) {
        if (obj instanceof JSONObject) {
            getSign((JSONObject) obj, stringBuffer);
        } else if (obj instanceof Map) {
            getSign((JSONObject) JSONObject.toJSON(obj), stringBuffer);
        } else if (obj instanceof List) {
            List valueList = (List) obj;
            getSign(valueList, stringBuffer);
        } else if (obj instanceof Date) {
            Date date = (Date) obj;
            stringBuffer.append(key);
            stringBuffer.append("=");
            stringBuffer.append(DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss"));
            stringBuffer.append("&");
        } else if (obj != null) {
            stringBuffer.append(key);
            stringBuffer.append("=");
            stringBuffer.append(obj);
            stringBuffer.append("&");
        }
    }

    /**
     * 转换签名
     *
     * @param sign 入参
     * @return 最终签名
     */
    public static String getToken(String sign) {
        //对象转换成aa=aa&bb=bb&cc=cc形式
        //拼接appid后md5
        String ex = DigestUtils.md5Hex(sign);
        //md5后base64
        String result = Base64.getEncoder().encodeToString(ex.getBytes());
        return result;
    }

}
