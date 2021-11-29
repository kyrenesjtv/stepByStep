package com.github.kyrenesjtv.multithread.geektime;

/**
 * STM的引用对象
 */
public class AccountSTM01 {

    //余额
    public TxnRef<Integer> balacne;

    //构造方法
    public AccountSTM01(int balacne){
        this.balacne = new TxnRef<Integer>(balacne);
    }

    //转账操作
    public void transfer(AccountSTM01 target , int amt){
        STM.atomic(txn -> {
            Integer from = balacne.getValue(txn);
            balacne.setValue(from-amt,txn);
            Integer to = target.balacne.getValue(txn);
            target.balacne.setValue(to+amt,txn);
        });
    }

}
