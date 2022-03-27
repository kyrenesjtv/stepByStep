package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.strategy.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huojianxiong
 * @Description SortAlgFactory
 * @Date 2022/3/27 15:17
 */
public class SortAlgFactory {
    private static final Map<String, ISortAlg> algs = new HashMap<>();

    static {
        algs.put("QuickSort", new QuickSort());
        algs.put("ExternalSort", new ExternalSort());
        algs.put("ConcurrentExternalSort", new ConcurrentExternalSort());
        algs.put("MapReduceSort", new MapReduceSort());
    }

    public static ISortAlg getSortAlg(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return algs.get(type);
    }
}
