package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.prototype;

import java.util.HashMap;
import java.util.List;

/**
 * @author huojianxiong
 * @Description DeepSimpleClone - 原型模式，利用对已有对象（原型）进行复制（或者叫拷贝）的方式，来创建新对象，以达到节省创建时间的目的
 * @Date 2022/3/12 13:29
 */
public class DeepShallowClone {

    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh(long lastMaxUpdateTime) {
        //shallow clone
        HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) currentKeywords.clone();
        //从数据库去除更新时间>lastUpdateTime的数据，放入到newKeywords
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastMaxUpdateTime);
        long maxNewUpdateTime = lastMaxUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdateTime) {
                maxNewUpdateTime = searchWord.getLastUpdateTime();
            }
            if (newKeywords.containsKey(searchWord.getKeyWord())) {
                newKeywords.remove(searchWord.getKeyWord());
            }
            newKeywords.put(searchWord.getKeyWord(), searchWord);
        }
        lastUpdateTime = maxNewUpdateTime;
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        return null;
    }
}
