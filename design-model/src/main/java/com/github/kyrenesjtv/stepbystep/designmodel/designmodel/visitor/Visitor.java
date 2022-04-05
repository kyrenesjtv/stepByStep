package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.visitor;

/**
 * @author huojianxiong
 * @Description Visitor
 * @Date 2022/4/5 21:44
 */

public interface Visitor {
    void visit(PdfFile pdfFile);

    void visit(PPTFile pptFile);

    void visit(WordFile wordFile);
}
