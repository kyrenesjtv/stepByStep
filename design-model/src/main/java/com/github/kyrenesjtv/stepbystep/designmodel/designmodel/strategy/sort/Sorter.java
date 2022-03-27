package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.strategy.sort;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huojianxiong
 * @Description Sorter
 * @Date 2022/3/27 15:19
 */
public class Sorter {
    private static final long GB = 1000 * 1000 * 1000;

    private static final List<AlgRange> algs = new ArrayList<>();

    //责任链，其实这部分可以初始化到数据库里去，然后把xxxSort这些用工厂去获取（取出来封装成AlgRange）
    static {
        algs.add(new AlgRange(0, 6 * GB, SortAlgFactory.getSortAlg("QuickSort")));
        algs.add(new AlgRange(6 * GB, 10 * GB, SortAlgFactory.getSortAlg("ExternalSort")));
        algs.add(new AlgRange(10 * GB, 100 * GB, SortAlgFactory.getSortAlg("ConcurrentExternalSort")));
        algs.add(new AlgRange(100 * GB, Long.MAX_VALUE, SortAlgFactory.getSortAlg("MapReduceSort")));
    }

    public void sortFile(String filePath) {
        File file = new File(filePath);
        long fileSize = file.length();
        ISortAlg sortAlg = null;
        for (AlgRange alg : algs) {
            if (alg.inRange(fileSize)) {
                sortAlg = alg.getSortAlg();
            }
        }
        sortAlg.sort(filePath);
    }


    @Data
    @AllArgsConstructor
    private static class AlgRange {
        private long start;
        private long end;
        private ISortAlg sortAlg;

        public boolean inRange(long size) {
            return size >= start && size < end;
        }
    }
}
