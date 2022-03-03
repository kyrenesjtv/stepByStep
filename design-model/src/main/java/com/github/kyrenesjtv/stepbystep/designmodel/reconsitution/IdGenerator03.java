package com.github.kyrenesjtv.stepbystep.designmodel.reconsitution;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @author huojianxiong
 * @Description IdGenerator03 - id生成器
 * @Date 2022/3/3 16:49
 */
@Slf4j
public class IdGenerator03 {


    public static String generate() {
        String substrOfHostName = getLastfieldOfHostName();
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s", substrOfHostName, currentTimeMillis, randomString);
        return id;
    }

    private static String generateRandomAlphameric(int length) {
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


    private static String getLastfieldOfHostName() {
        //获取机器地址
        String substrOfHostName = null;
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            substrOfHostName = getLastSubstrSplittedByDot(hostName);
        } catch (UnknownHostException e) {
            log.error("faild to get the host name ", e);
        }
        return substrOfHostName;
    }

    private static String getLastSubstrSplittedByDot(String hostName) {
        String[] split = hostName.split("\\.");
        return split[split.length - 1];
    }


    public static void main(String[] args) {
        String generate1 = IdGenerator03.generate();
        String generate2 = IdGenerator03.generate();
        String generate3 = IdGenerator03.generate();
        System.out.println(generate1);
        System.out.println(generate2);
        System.out.println(generate3);
    }

}
