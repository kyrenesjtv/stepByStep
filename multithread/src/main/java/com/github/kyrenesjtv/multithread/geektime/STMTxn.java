package com.github.kyrenesjtv.multithread.geektime;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 事务实现类
 */
public final class STMTxn implements Txn{

    //事务id生成器
    private static AtomicLong txnSeq = new AtomicLong(0);
    //当前事务所有的相关数据
    private Map<TxnRef,VersioneRef> inTxnMap = new HashMap<>();
    //当前事务所有需要修改的数据
    private Map<TxnRef,Object> writeMap = new HashMap<>();
    //当前事务id
    private long txnId;
    //构造函数，自动生成当前事务ID
    STMTxn(){
        txnId = txnSeq.incrementAndGet();
    }

    /**
     * 获取当前事务中的数据
     * @param ref
     * @param <T>
     * @return
     */
    @Override
    public <T> T get(TxnRef ref) {
        //将需要修改的数据，加入到inTxnMap
        if(!inTxnMap.containsKey(ref)){
            inTxnMap.put(ref,ref.curRef);
        }
        return (T)inTxnMap.get(ref).value;
    }

    /**
     * 在当前事务中修改数据
     * @param ref
     * @param value
     * @param <T>
     */
    @Override
    public <T> void set(TxnRef ref, T value) {
        //将需要修改的数据，加入到inTxnMap
        if(!inTxnMap.containsKey(ref)){
            inTxnMap.put(ref,ref.curRef);
        }
        writeMap.put(ref,value);
    }

    //提交事务
    boolean commit(){
        synchronized (STM.commitLock){
            //是否校验通过
            boolean isValid = true;
            //校验所有读过的数据是否发生过变化
            for(Map.Entry<TxnRef, VersioneRef> entry : inTxnMap.entrySet()){
                VersioneRef curRef = entry.getKey().curRef;
                VersioneRef readRef = entry.getValue();
                //通过版本号来验证数据是否发生过变化
                if(curRef.version != readRef.version){
                    isValid = false;
                    break;
                }
            }
            //如果校验通过，则所有更改生效
            if(isValid){
                writeMap.forEach((k,v)->{
                    k.curRef = new VersioneRef(v,txnId);
                });
            }
            return isValid;
        }
    }

}
