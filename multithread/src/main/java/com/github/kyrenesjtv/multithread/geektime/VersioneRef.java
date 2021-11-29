package com.github.kyrenesjtv.multithread.geektime;

/**
 * 带版本号的引用对象
 * @param <T>
 */
public final class VersioneRef<T> {
    final T value;
    final long version;
    //构造方法
    public VersioneRef(T value , long version){
        this.value = value;
        this.version =version;
    }
}
