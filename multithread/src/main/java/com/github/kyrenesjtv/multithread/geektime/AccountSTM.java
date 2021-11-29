package com.github.kyrenesjtv.multithread.geektime;


import org.multiverse.api.StmUtils;


/**
 * 使用软事务(STM)锁  -- 包找不带
 */
public class AccountSTM {

//        //余额
//        private TxnLong balance;
//        //构造函数
//        public AccountSTM(long balance){
//            this.balance = StmUtils.newTxnLong(balance);
//        }
//        //转账
//        public void transfer(AccountSTM to, int amt){
//            //原子化操作
//            atomic(()->{
//                if (this.balance.get() > amt) {
//                    this.balance.decrement(amt);
//                    to.balance.increment(amt);
//                }
//            });
//        }



}
