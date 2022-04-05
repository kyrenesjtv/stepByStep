package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.memento;

/**
 * @author huojianxiong
 * @Description InputText
 * @Date 2022/4/5 22:04
 */
public class InputText {
    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void append(String input) {
        text.append(input);
    }

    public Snapshot createSnapshot() {
        return new Snapshot(text.toString());
    }

    public void restoreSnapshot(Snapshot snapshot) {
        this.text.replace(0, this.text.length(), snapshot.getText());
    }
}
