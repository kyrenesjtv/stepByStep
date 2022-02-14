package com.github.kyrenesjtv.stepbystep.designmodel.oo.inter;

/**
 * @author huojianxiong
 * @Description Filter
 * @Date 2022/2/14 18:51
 */
public interface Filter {
    void doFilter(RpcRequest req) throws RpcException;
}
