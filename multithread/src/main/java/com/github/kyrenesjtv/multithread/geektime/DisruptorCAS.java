package com.github.kyrenesjtv.multithread.geektime;

/**
 * Disruptor 中的无锁实现
 *
 * @author huojianxiong
 * 2021/11/11 15:03
 */
public class DisruptorCAS {

    public static void main(String[] args) {
        /*
        //生产者获取n个写入位置
        do {
            //cursor类似于入队索引，指的是上次生产到这里
            current = cursor.get();
            //目标是在生产n个
            next = current + n;
            //减掉一个循环
            long wrapPoint = next - bufferSize;
            //获取上一次的最小消费位置
            long cachedGatingSequence = gatingSequenceCache.get();
            //没有足够的空余位置
            if (wrapPoint>cachedGatingSequence || cachedGatingSequence>current){
                //重新计算所有消费者里面的最小值位置
                long gatingSequence = Util.getMinimumSequence(
                        gatingSequences, current);
                //仍然没有足够的空余位置，出让CPU使用权，重新执行下一循环
                if (wrapPoint > gatingSequence){
                    LockSupport.parkNanos(1);
                    continue;
                }
                //从新设置上一次的最小消费位置
                gatingSequenceCache.set(gatingSequence);
            } else if (cursor.compareAndSet(current, next)){
                //获取写入位置成功，跳出循环
                break;
            }
        } while (true);

         */
    }


}
