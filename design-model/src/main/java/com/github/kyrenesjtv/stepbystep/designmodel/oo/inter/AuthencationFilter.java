package com.github.kyrenesjtv.stepbystep.designmodel.oo.inter;

/**
 * @author huojianxiong
 * @Description AuthencationFilter
 * @Date 2022/2/14 19:19
 */
public class AuthencationFilter implements Filter {

    @Override
    public void doFilter(RpcRequest req) throws RpcException {
        //...鉴权逻辑..
    }
}
