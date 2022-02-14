package com.github.kyrenesjtv.stepbystep.designmodel.oo.inter;

/**
 * @author huojianxiong
 * @Description RateLimitFilter
 * @Date 2022/2/14 19:19
 */
public class RateLimitFilter implements Filter {

    @Override
    public void doFilter(RpcRequest req) throws RpcException {
        //...限流逻辑...
    }

}
