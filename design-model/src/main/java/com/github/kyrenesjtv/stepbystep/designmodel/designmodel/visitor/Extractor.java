package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.visitor;

/**
 * @author huojianxiong
 * @Description Extractor
 * @Date 2022/4/5 21:20
 */
public class Extractor implements Visitor {


    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("Extractor-PdfFile");
    }

    @Override
    public void visit(PPTFile pptFile) {
        System.out.println("Extractor-pptFile");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("Extractor-wordFile");
    }
}
