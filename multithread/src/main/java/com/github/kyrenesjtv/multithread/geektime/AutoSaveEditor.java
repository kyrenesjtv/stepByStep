package com.github.kyrenesjtv.multithread.geektime;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/10/3 22:33
 */
public class AutoSaveEditor {

    //文件是否被修改过
    boolean changed = false;
    //定时任务线程池
    ScheduledExecutorService ses =Executors.newSingleThreadScheduledExecutor();
    //定时执行自动保存
    void startAutoSave(){
        ses.scheduleWithFixedDelay(()->{
            autoSave();
        },5,5, TimeUnit.SECONDS);
    }

    void autoSave() {
        synchronized (this){
            if(!changed){
                return;
            }
            changed =false;
        }

        //执行存盘操作

        this.execSave();
    }

    private void execSave() {
    }

    //编辑操作
    void edit(){
        //省略操作代码

        change();
    }

    //balking经典实现，将并发处理逻辑和业务逻辑进行分开
    void change(){
        synchronized (this){
            changed = true;
        }
    }



}
