package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.memento;

/**
 * @author huojianxiong
 * @Description Snapshot
 * @Date 2022/4/5 22:07
 */
public class Snapshot {

    private String text;

    public Snapshot(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
