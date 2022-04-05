package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.visitor;

/**
 * @author huojianxiong
 * @Description PdfFile
 * @Date 2022/4/5 21:17
 */
public class PdfFile extends ResourceFile {

    public PdfFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
