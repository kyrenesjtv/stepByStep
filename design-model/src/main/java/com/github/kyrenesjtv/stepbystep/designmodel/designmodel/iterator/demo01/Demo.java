package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.iterator.demo01;

import java.util.ArrayList;

/**
 * @author huojianxiong
 * @Description Demo
 * @Date 2022/4/5 17:51
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        Iterator01<String> eArrayIterator01 = new ArrayIterator01<String>(strings);
        while (eArrayIterator01.hasNext()) {
            System.out.println(eArrayIterator01.currentItem());
            eArrayIterator01.next();
        }
    }
}
