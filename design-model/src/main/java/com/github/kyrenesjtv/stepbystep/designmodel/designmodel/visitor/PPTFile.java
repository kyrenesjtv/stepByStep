package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.visitor;

/**
 * @author huojianxiong
 * @Description PPTFile
 * @Date 2022/4/5 21:19
 */
public class PPTFile extends ResourceFile {

    public PPTFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
