package com.github.kyrenesjtv.stepbystep.designmodel.designmodel.composite;

/**
 * @author huojianxiong
 * @Description FileSystemNode
 * @Date 2022/3/20 22:58
 */
public abstract class FileSystemNode {

    protected String path;

    public FileSystemNode(String path) {
        this.path = path;
    }

    public abstract int countNumOfFiles();

    public abstract long countSizeOfFiles();

    public String getPath() {
        return path;
    }


}
