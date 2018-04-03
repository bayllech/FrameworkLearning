package cn.bayllech.project.socketServer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author bei.qi
 * @Description
 * @Date 2018-04-03 21:54
 */
public class TcpServerHandler extends SimpleChannelInboundHandler<Object> {
    
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        System.out.println("msg--->>>" + o);
    }
}