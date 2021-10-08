package com.github.kyrenesjtv.multithread.geektime;

import java.util.Set;
import java.util.concurrent.*;

/**
 * 路由表01，自动保存的
 *
 * @author huojianxiong
 * 2021/10/3 22:49
 */
public class RouterTable01 {

    //Key:接口名
    // Value:路由集合
    ConcurrentHashMap<String, CopyOnWriteArraySet<Router>> rt = new ConcurrentHashMap<>();
    //路由表是否发生变化
    volatile boolean changed;
    //将路由表写入本地文件的线程池
    ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

    //启动定时任务，将变更后的路由表写入本地
    public void startLocalSaver(){
        ses.scheduleWithFixedDelay(()->{
            autoSave();
        },5,5, TimeUnit.SECONDS);
    }

    //将路由表保存到本地
    void autoSave(){
        if(!changed){
            return;
        }
        changed = false;
        this.save2Local();
    }

    //删除路由
    public void remove(Router router){
        Set<Router> set = rt.get(router.getIface());
        if( set != null){
            set.remove(router);
            changed = true;
        }

    }

    //增加路由
    public void add(Router router){
        Set<Router> set = rt.computeIfAbsent(router.getIface(), r -> new CopyOnWriteArraySet<>());
        set.add(router);
        changed = true;
    }


    private void save2Local() {
    }


}
