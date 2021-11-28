//package com.github.kyrenesjtv.multithread.geektime;
//
//import com.lmax.disruptor.RingBuffer;
//import com.lmax.disruptor.dsl.Disruptor;
//import com.lmax.disruptor.util.DaemonThreadFactory;
//
//import java.nio.ByteBuffer;
//
///**
// * 高性能队列Disruptor
// *
// * @author huojianxiong
// * 2021/11/11 14:09
// */
//public class Disruptor01 {
//
//    class LongEvent {
//        private long value;
//
//        public void set(long value) {
//            this.value = value;
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        //指定ringbuffer的大小，必须是2的N次方
//        int bufferSize = 1024;
//
//        //构建Disruptor
//        Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new, bufferSize, DaemonThreadFactory.INSTANCE);
//
//        //注册时间处理器
//        disruptor.handleEventsWith((event,sequence,endOfBatch)-> System.out.println("E:"+event));
//
//        //启动Disruptor
//        disruptor.start();
//
//        //获取RingBuffer
//        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
//        //生产event
//        ByteBuffer bb = ByteBuffer.allocate(8);
//        for(long i = 0; true;i++){
//            bb.putLong(0,i);
//            //生产者生产消息
//            ringBuffer.publishEvent((event, sequence, buffer) -> event.set(buffer.getLong(0)), bb);
//            Thread.sleep(1000);
//
//        }
//
//
//    }
//
//
//}
