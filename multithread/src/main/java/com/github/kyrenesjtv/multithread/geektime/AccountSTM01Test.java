package com.github.kyrenesjtv.multithread.geektime;

public class AccountSTM01Test {

    public static void main(String[] args) throws InterruptedException {

        AccountSTM01 accountSTM01 = new AccountSTM01(500);

        AccountSTM01 accountSTM02 = new AccountSTM01(500);

        AccountSTM01 accountSTM03 = new AccountSTM01(500);

        new Thread(()->{
            accountSTM01.transfer(accountSTM02,200);
        }).start();

//        new Thread(()->{
//            accountSTM02.transfer(accountSTM03,300);
//        }).start();

        Thread.sleep(1000);

        System.out.println("accountSTM01 value:"+accountSTM01.balacne.curRef.value);
        System.out.println("accountSTM01 balance:"+accountSTM01.balacne);
        System.out.println("accountSTM02 value:"+accountSTM02.balacne.curRef.value);
        System.out.println("accountSTM02 balance:"+accountSTM02.balacne);
        System.out.println("accountSTM03 value:"+accountSTM03.balacne.curRef.value);
        System.out.println("accountSTM03 balance:"+accountSTM03.balacne);
        System.out.println("");

    }
}
