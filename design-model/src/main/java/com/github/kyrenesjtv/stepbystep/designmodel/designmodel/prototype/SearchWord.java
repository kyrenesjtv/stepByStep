package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author huojianxiong
 * @Description SearchWord
 * @Date 2022/3/12 13:28
 */
@Data
@AllArgsConstructor
public class SearchWord {
    private String keyWord;
    private long count;
    private long lastUpdateTime;
}
