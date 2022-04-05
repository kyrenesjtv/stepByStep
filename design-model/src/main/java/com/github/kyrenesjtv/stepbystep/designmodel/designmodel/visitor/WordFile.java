package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.visitor;

/**
 * @author huojianxiong
 * @Description WordFile
 * @Date 2022/4/5 21:19
 */
public class WordFile extends ResourceFile {

    public WordFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
