package com.github.kyrenesjtv.stepbystep.designmodel.reconsitution;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.util.Random;

/**
 * @author huojianxiong
 * @Description IdGenerator01 - id生成器
 * @Date 2022/3/3 16:28
 */
@Slf4j
public class IdGenerator01 {

    public static String generate() {
        String id = "";
        try {
            //获取机器地址
            String hostName = InetAddress.getLocalHost().getHostName();
            String[] split = hostName.split("\\.");
            if (split.length > 0) {
                hostName = split[split.length - 1];
            }
            char[] randomChars = new char[8];
            int count = 0;
            Random random = new Random();
            while (count < 8) {
                int randomAscii = random.nextInt(122);
                if (randomAscii >= 48 && randomAscii <= 57) {
                    randomChars[count] = (char) ('0' + (randomAscii - 48));
                    count++;
                } else if (randomAscii >= 65 && randomAscii <= 90) {
                    randomChars[count] = (char) ('A' + (randomAscii - 65));
                    count++;
                } else if (randomAscii >= 97 && randomAscii <= 122) {
                    randomChars[count] = (char) ('a' + (randomAscii - 97));
                    count++;
                }
            }
            id = String.format("%s-%d-%s", hostName, System.currentTimeMillis(), new String(randomChars));
        } catch (Exception e) {
            log.error("faild to get the host name ", e);
        }
        return id;
    }

    public static void main(String[] args) {
        String generate1 = IdGenerator01.generate();
        String generate2 = IdGenerator01.generate();
        String generate3 = IdGenerator01.generate();
        System.out.println(generate1);
        System.out.println(generate2);
        System.out.println(generate3);
    }

}
