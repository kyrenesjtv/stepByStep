package com.github.kyrenesjtv.stepbystep.designmodel.oo.inter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huojianxiong
 * @Description psvm
 * @Date 2022/2/14 19:20
 */
public class psvm {

    public static void main(String[] args) {
        List<Filter> filters = new ArrayList<>();

        filters.add(new AuthencationFilter());
        filters.add(new RateLimitFilter());
        handleRpcRequest(new RpcRequest(), filters);

    }

    public static void handleRpcRequest(RpcRequest req, List<Filter> filters) {
        try {
            for (Filter filter : filters) {
                filter.doFilter(req);
            }
        } catch (RpcException e) {
            // ...处理过滤结果...
        }
        // ...省略其他处理逻辑...
    }

}
