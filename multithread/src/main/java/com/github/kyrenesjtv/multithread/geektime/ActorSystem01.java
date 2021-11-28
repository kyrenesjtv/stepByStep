package com.github.kyrenesjtv.multithread.geektime;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * actor，异步发送消息。但是处理端是同步的。能把消息进行缓存处理。
 */
public class ActorSystem01 {

    //该Actor当收到消息message后，
    // 会打印Hello message
    static class HelloAcotr extends UntypedActor {

        @Override
        public void onReceive(Object message) throws Throwable {
            System.out.println("Hello " + message);
        }
    }

    public static void main(String[] args) {
        //创建actor系统
        ActorSystem system = ActorSystem.create("hellosystem");
        //创建hello actor
        ActorRef helloActor = system.actorOf(Props.create(HelloAcotr.class));
        //发送消息给hello actor
        helloActor.tell("actor",ActorRef.noSender());
    }
}
