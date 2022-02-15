package com.github.kyrenesjtv.stepbystep.designmodel.oo.combination;

/**
 * @author huojianxiong
 * @Description 麻雀
 * @Date 2022/2/15 17:18
 */
public class Sparrow implements EggLayable, Flyable, Tweetable {
    @Override
    public void layEgg() {
        System.out.println("下蛋");
    }

    @Override
    public void fly() {
        System.out.println("飞行");
    }

    @Override
    public void tweet() {
        System.out.println("尖叫");
    }
}
