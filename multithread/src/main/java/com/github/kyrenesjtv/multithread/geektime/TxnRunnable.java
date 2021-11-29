package com.github.kyrenesjtv.multithread.geektime;

@FunctionalInterface
public interface TxnRunnable {
    void run(Txn txn);
}
