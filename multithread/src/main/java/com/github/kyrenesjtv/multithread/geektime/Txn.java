package com.github.kyrenesjtv.multithread.geektime;

/**
 * 事务接口
 */
public interface Txn {

    <T> T get(TxnRef ref);
    <T> void set(TxnRef ref, T value);
}
