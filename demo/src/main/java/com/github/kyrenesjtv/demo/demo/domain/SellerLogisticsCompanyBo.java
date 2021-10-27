package com.github.kyrenesjtv.demo.demo.domain;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SellerLogisticsCompanyBo {

    private Long sellerId;

    private String sellerNick;

    private List<LogisticsCompanyStat> list;

    private Date startTime;

    private Date endTime;



    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerNick() {
        return sellerNick;
    }

    public void setSellerNick(String sellerNick) {
        this.sellerNick = sellerNick;
    }

    public List<LogisticsCompanyStat> getList() {
        return list;
    }

    public void setList(List<LogisticsCompanyStat> list) {
        this.list = list;
    }

    public static class LogisticsCompanyStat {
        public String logisticsName;

        public Map<String, Integer> orderCountMap = new ConcurrentHashMap<>();

        public String getLogisticsName() {
            return logisticsName;
        }

        public void setLogisticsName(String logisticsName) {
            this.logisticsName = logisticsName;
        }

        public Map<String, Integer> getOrderCountMap() {
            return orderCountMap;
        }

        public void setOrderCountMap(Map<String, Integer> orderCountMap) {
            this.orderCountMap = orderCountMap;
        }
    }
}
