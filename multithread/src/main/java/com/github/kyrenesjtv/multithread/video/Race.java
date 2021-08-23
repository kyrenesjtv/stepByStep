package com.github.kyrenesjtv.multithread.video;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2021/8/22 22:54
 */
public class Race implements Runnable {

    private static volatile Boolean flag = false;
    private String winner;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            String name = Thread.currentThread().getName();
            gameStep(name, i);
            if (flag) {
                break;
            }
            System.out.println(name + "跑了" + i + "步");
        }
    }

    private void gameStep(String name, int i) {
        if (name.equals("兔子")) {
            i = i * 2;
        }
        if (name.equals("乌龟")) {
            i = i + 1;
        }
        if (i == 100) {
            System.out.println("游戏结束，胜利者是：" + name);
            flag = true;
        }
    }

    public static void main(String[] args) {
        Race race1 = new Race();
        Race race2 = new Race();

        new Thread(race1, "兔子").start();
        new Thread(race2, "乌龟").start();

    }

}
