package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.iterator.demo01;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @author huojianxiong
 * @Description ArrayIterator01
 * @Date 2022/4/5 17:44
 */
public class ArrayIterator01<E> implements Iterator01<E> {

    private int cursor;
    private ArrayList<E> arrayList;

    public ArrayIterator01(ArrayList<E> arrayList) {
        this.cursor = 0;
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        return cursor != arrayList.size();
    }

    @Override
    public void next() {
        cursor++;
    }

    @Override
    public E currentItem() {
        if (cursor > arrayList.size()) {
            throw new NoSuchElementException();
        }
        return arrayList.get(cursor);
    }
}
