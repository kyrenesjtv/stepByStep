package com.github.kyrenesjtv.stepbystep.designmodel.oo.combination;

/**
 * @author huojianxiong
 * @Description 鸵鸟
 * @Date 2022/2/15 17:17
 */
public class Ostrich implements Tweetable, EggLayable {

    @Override
    public void layEgg() {
        System.out.println("下蛋");
    }

    @Override
    public void tweet() {
        System.out.println("尖叫");
    }
}
