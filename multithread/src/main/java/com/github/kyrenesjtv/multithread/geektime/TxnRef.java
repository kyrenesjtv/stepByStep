package com.github.kyrenesjtv.multithread.geektime;

/**
 * 支持事务的引用
 * @param <T>
 */
public class TxnRef<T> {

    //当前数据，带版本号
    volatile VersioneRef curRef;

    //构造方法
    public TxnRef(T value){
        this.curRef = new VersioneRef(value,0L);
    }

    //获取当前事务中的数据
    public T getValue(Txn txn){
        return txn.get(this);
    }

    //再当前事务中设置数据
    public void setValue(T value , Txn txn){
        txn.set(this,value);
    }

}
