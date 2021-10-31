package com.github.kyrenesjtv.multithread.geektime;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Netty NIO
 *
 * @author huojianxiong
 * 2021/10/31 21:44
 */
public class NettySocket {



    public static void main(String[] args) {

        EchoServerHandler echoServerHandler = new EchoServerHandler();
//        EchoServerHandler02 echoServerHandler02 = new EchoServerHandler02();

        EchoServerHandler01 echoServerHandler01 = new EchoServerHandler01();
//        EchoServerHandler03 echoServerHandler03 = new EchoServerHandler03();


        //boss线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);

        //worker线程组
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel socketChannel) {
                    socketChannel.pipeline().addLast(echoServerHandler)
//                            .addLast(echoServerHandler02)
                    .addLast(echoServerHandler01);
//                    .addLast(echoServerHandler03);
                }
            });
            //绑定端口
            ChannelFuture sync = serverBootstrap.bind(9090).sync();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }



     static class EchoServerHandler01 extends ChannelInboundHandlerAdapter {
        //处理读事件
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("我是请求02");
            ctx.read();

//            System.out.println("我是请求02");
//            super.channelRead(ctx,msg);

        }

        //处理读完成事件
        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) {
            ctx.flush();
        }

        //处理异常事件
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            cause.printStackTrace();
            ctx.close();
        }
    }

    static class EchoServerHandler extends ChannelInboundHandlerAdapter {
        //处理读事件
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

            System.out.println("我是请求01");
            //会从当前handler往前找到outHandler。这边实现的是InboundHandler
            ctx.write(msg);

            //如果我们是调用ctx.write()方法的话，会从当前的hander往前找第一个outbound来执行。记住一定要将OutBoundHandler先添加进ChannelPipeline。否则会跟期望的结果不一致
            //如果我们是使用channel().write()方法。可以不用考虑outbound和inbound的添加顺序。每次都会从tail往前找第一个是outbound的handler来执行。
//            ctx.write(Unpooled.wrappedBuffer(ByteBufUtil.decodeHexDump("aa")));
            //ctx.channel().write(Unpooled.wrappedBuffer(ByteBufUtil.decodeHexDump("aa")));

//            System.out.println("我是请求01");
//            ctx.read();

            //能够使下一个InHandler也接收到消息
//            System.out.println("我是请求01");
//            super.channelRead(ctx,msg);

//            ByteBuf in = (ByteBuf) msg;
//            String readStr = in.toString(CharsetUtil.UTF_8);
//            System.out.println("readStr:"+readStr);

        }

        //处理读完成事件
        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) {
            ctx.flush();
        }

        //处理异常事件
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            cause.printStackTrace();
            ctx.close();
        }
    }

}
