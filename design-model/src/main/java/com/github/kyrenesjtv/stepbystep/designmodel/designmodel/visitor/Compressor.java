package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.visitor;

/**
 * @author huojianxiong
 * @Description Compressor
 * @Date 2022/4/5 21:47
 */
public class Compressor implements Visitor {
    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("Compressor-pdfFile");
    }

    @Override
    public void visit(PPTFile pptFile) {
        System.out.println("Compressor-pptFile");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.println("Compressor-wordFile");
    }
}
