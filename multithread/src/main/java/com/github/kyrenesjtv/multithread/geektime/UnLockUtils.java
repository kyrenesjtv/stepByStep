package com.github.kyrenesjtv.multithread.geektime;

import java.util.concurrent.atomic.*;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/8/29 20:21
 */
public class UnLockUtils {

    public static void main(String[] args) {

        //引用类型
        AtomicReference<Integer> integerAtomicReference = new AtomicReference<>();
        integerAtomicReference.set(123);

        //        AtomicStampedReference<Integer> integerAtomicStampedReference = new AtomicStampedReference<Integer>();
        //        integerAtomicStampedReference.set(123, 456);

        //        AtomicMarkableReference<Integer> integerAtomicMarkableReference = new AtomicMarkableReference<Integer>();
        //        integerAtomicMarkableReference.set(123, false);

        //基本数据类型
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        atomicBoolean.set(false);

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(123);

        AtomicLong atomicLong = new AtomicLong();
        atomicLong.set(123);


        //数组
        //        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray();
        //        atomicIntegerArray.set(1, 123);

        //        AtomicLongArray atomicLongArray = new AtomicLongArray();
        //        atomicLongArray.set(1, 123);

        AtomicReferenceArray<Integer> integerAtomicReferenceArray = new AtomicReferenceArray<Integer>(12);
        integerAtomicReferenceArray.set(1, 123);


        //对象属性更新器
        //        new AtomicIntegerFieldUpdater<>();
        //        new AtomicLongFieldUpdater<>()
        //        new AtomicReferenceFieldUpdater<>()


        //累加器
        //        DoubleAccumulator doubleAccumulator = new DoubleAccumulator();
        DoubleAdder doubleAdder = new DoubleAdder();
        //        LongAccumulator longAccumulator = new LongAccumulator();
        LongAdder longAdder = new LongAdder();

    }


}
