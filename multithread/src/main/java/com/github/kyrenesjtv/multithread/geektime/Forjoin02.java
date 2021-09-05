package com.github.kyrenesjtv.multithread.geektime;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 将任务分解，然后结果合并
 *
 * @author huojianxiong
 * 2021/9/5 15:19
 */
public class Forjoin02 {

    public static void main(String[] args) {
        String[] fc = {"hello world", "hello me", "hello fork", "hello join", "fork join in world"};
        ForkJoinPool fjp = new ForkJoinPool(3);
        MR mr = new MR(fc, 0, fc.length);
        Map result = fjp.invoke(mr);
        result.forEach((k, v) -> System.out.println(k + ":" + v));
    }


    static class MR extends RecursiveTask<Map<String, Long>> {

        private static final long serialVersionUID = 6186579077512161799L;
        private String[] fc;
        private int start, end;

        public MR(String[] fc, int start, int end) {
            this.fc = fc;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Map<String, Long> compute() {
            if (end - start == 1) {
                return calc(fc[start]);
            } else {
                int mid = (start + end) / 2;
                MR left = new MR(fc, start, mid);
                left.fork();
                MR right = new MR(fc, mid, end);
                right.fork();

                Map<String, Long> leftJoin = left.join();
                Map<String, Long> rightJoin = right.join();
                return merge(leftJoin, rightJoin);
            }
        }

        //合并结果
        private Map<String, Long> merge(Map<String, Long> r1, Map<String, Long> r2) {
            Map<String, Long> result = new HashMap<>();
            result.putAll(r1);
            //合并结果
            r2.forEach((k, v) -> {
                Long c = result.get(k);
                if (c != null) {
                    result.put(k, c + v);
                } else {
                    result.put(k, v);
                }
            });
            return result;
        }

        //统计单词数量
        private Map<String, Long> calc(String line) {
            HashMap<String, Long> result = new HashMap<>();
            //分割单词
            String[] words = line.split("\\s+");
            //统计单词数量
            for (String word : words) {
                Long v = result.get(word);
                if (v != null) {
                    result.put(word, v + 1);
                } else {
                    result.put(word, 1L);
                }
            }
            return result;
        }

    }
}




