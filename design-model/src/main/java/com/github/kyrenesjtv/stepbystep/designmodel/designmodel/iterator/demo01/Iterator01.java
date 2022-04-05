package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.iterator.demo01;

/**
 * @author huojianxiong
 * @Description Iterator01
 * @Date 2022/4/5 17:43
 */
public interface Iterator01<E> {
    boolean hasNext();

    void next();

    E currentItem();
}
