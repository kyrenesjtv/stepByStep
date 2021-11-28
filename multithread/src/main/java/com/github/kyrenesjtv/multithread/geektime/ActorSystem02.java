package com.github.kyrenesjtv.multithread.geektime;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * actor计数。
 */
public class ActorSystem02 {

    //累加器
    static class CounterActor extends UntypedActor{
        private int counter = 0;
        @Override
        public void onReceive(Object message) throws Throwable {
            //如果接收到的是数值型，就进行累加，否则进行打印
            if(message instanceof Number){
                counter += ((Number) message).intValue();
            } else {
                System.out.println(counter);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //创建actor系统
        ActorSystem system = ActorSystem.create("hellosystem");
        //4个线程生产消息
        ExecutorService es = Executors.newFixedThreadPool(4);
        //创建countActor
        ActorRef counterActor = system.actorOf(Props.create(CounterActor.class));
        //生产4*100000个消息
        for(int i = 0 ; i<4 ;i++){
            es.execute(()->{
                for(int j = 0 ; j<100000 ;j++){
                    counterActor.tell(1,ActorRef.noSender());
                }
            });
        }
        //关闭线程池
        es.shutdown();
        //等待counterActor处理完消息
        Thread.sleep(1000);
        //打印结果
        counterActor.tell("",ActorRef.noSender());
        //关闭actor
        system.shutdown();
    }

}
