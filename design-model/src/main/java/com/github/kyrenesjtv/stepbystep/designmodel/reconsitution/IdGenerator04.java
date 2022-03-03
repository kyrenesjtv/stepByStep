package com.github.kyrenesjtv.stepbystep.designmodel.reconsitution;

import com.github.kyrenesjtv.stepbystep.designmodel.exception.IdGeneratorException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @author huojianxiong
 * @Description IdGenerator04 - id生成器，异常的处理
 * @Date 2022/3/3 16:49
 */
@Slf4j
public class IdGenerator04 {


    public static String generate() throws IdGeneratorException {
        String substrOfHostName = null;
        try {
            substrOfHostName = getLastfieldOfHostName();
        } catch (UnknownHostException e) {
            throw new IdGeneratorException("IdGenerator04.getLastfieldOfHostName error", e);
        }
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s", substrOfHostName, currentTimeMillis, randomString);
        return id;
    }

    private static String generateRandomAlphameric(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("length must be > 0");
        }
        char[] randomChars = new char[8];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) randomAscii;
                count++;
            }
        }
        return new String(randomChars);
    }


    private static String getLastfieldOfHostName() throws UnknownHostException {
        //获取机器地址
        String substrOfHostName = null;
        String hostName = InetAddress.getLocalHost().getHostName();
        if (StringUtils.isBlank(hostName)) {
            throw new IllegalArgumentException("hostName is null");
        }
        substrOfHostName = getLastSubstrSplittedByDot(hostName);
        return substrOfHostName;
    }

    private static String getLastSubstrSplittedByDot(String hostName) {
        if (StringUtils.isBlank(hostName)) {
            throw new IllegalArgumentException("hostName is null");
        }
        String[] split = hostName.split("\\.");
        return split[split.length - 1];
    }


    public static void main(String[] args) {
    }

}
