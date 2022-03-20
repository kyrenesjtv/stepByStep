package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.facede;

/**
 * @author huojianxiong
 * @Description IStatisticsService - 门面模式，接口整合
 * @Date 2022/3/20 21:37
 */
public interface IStatisticsService {

    /**
     * @param
     * @return java.lang.Integer
     * @author huojianxiong
     * @description 获取到最小值
     * @data 21:37 2022/3/20
     **/
    Integer getMin();

    /**
     * @param
     * @return java.lang.Integer
     * @author huojianxiong
     * @description 获取到最大值
     * @data 21:38 2022/3/20
     **/
    Integer getMax();

    /**
     * @param
     * @return java.lang.Integer
     * @author huojianxiong
     * @description 获取到平均值
     * @data 21:38 2022/3/20
     **/
    Integer getAvg();

    /**
     * @param
     * @return java.lang.Integer
     * @author huojianxiong
     * @description 聚合接口，获取到 最大值，最小值，平均值
     * @data 21:38 2022/3/20
     **/
    Integer getStatistics();


}
