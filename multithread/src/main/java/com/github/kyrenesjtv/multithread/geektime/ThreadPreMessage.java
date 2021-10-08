package com.github.kyrenesjtv.multithread.geektime;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/10/4 19:03
 */
public class ThreadPreMessage {

    final ServerSocketChannel ssc = ServerSocketChannel.open().bind( new InetSocketAddress(8080));


    public ThreadPreMessage() throws IOException {
    }

    public void echo(){
        try{
            while(true){
                //接收请求
                SocketChannel sc = ssc.accept();
                //每个请求都创建一个线程
                new Thread(()->{
                   try{
                        //读socket
                       ByteBuffer rb = ByteBuffer.allocateDirect(1024);
                       sc.read(rb);
                       //模拟处理请求
                       Thread.sleep(2000);
                       //写socket
                       ByteBuffer wb = (ByteBuffer) rb.flip();
                       sc.write(wb);
                       //关闭socket
                       sc.close();
                   } catch (Exception e){

                   }
                }).start();
            }

        }catch (Exception e){

        }finally {
            try {
                ssc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
