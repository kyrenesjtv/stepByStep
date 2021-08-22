package com.github.kyrenesjtv.multithread.geektime;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/8/16 11:29
 */
public class Account01 {

    // 锁：保护转账
    private Object transLock = new Object();

    // 锁：保护账户余额
    private final Object balLock = new Object();
    // 账户余额
    private Integer balance;
    // 锁：保护账户密码
    private final Object pwLock = new Object();
    // 账户密码
    private String password;

    // 取款
    void withdraw(Integer amt) {
        synchronized (balLock) {
            if (this.balance > amt) {
                this.balance -= amt;
            }
        }
    }

    // 查看余额
    Integer getBalance() {
        synchronized (balLock) {
            return balance;
        }
    }

    // 更改密码
    void updatePassword(String pw) {
        synchronized (pwLock) {
            this.password = pw;
        }
    }

    // 查看密码
    String getPassword() {
        synchronized (pwLock) {
            return password;
        }
    }

    // 转账  默认是this锁。 synchronized(this) 保护了this.balance却没有保护target.balance

    /**
     * synchronized void transfer(Account01 target, int amt) {
     * if (this.balance > amt) {
     * this.balance -= amt;
     * target.balance += amt;
     * }
     * }
     */

    /**
     * // 创建Account时传入同一个lock对象
     * public Account01(Object lock) {
     * this.transLock = lock;
     * }
     * //缺点，需要传入lock对象。 A B  C D 4个线程。AB和CD并行。AB串行 CD串行
     * void transfer(Account01 target, int amt) {
     * synchronized (transLock) {
     * if (this.balance > amt) {
     * this.balance -= amt;
     * target.balance += amt;
     * }
     * }
     * }
     */

    /**
     * //使用类锁Account01.class。但是这样子Account01里面的所有操作都变成了串行化
     * void transfer(Account01 target, int amt) {
     * synchronized (Account01.class) {
     * if (this.balance > amt) {
     * this.balance -= amt;
     * target.balance += amt;
     * }
     * }
     * }
     */

    /**
     * //直接锁两个对象 A B  C D 4个线程。AB和CD并行。AB串行 CD串行。但是会产生死锁问题
     * void transfer(Account01 target, int amt) {
     * synchronized (this) {
     * synchronized (target) {
     * if (this.balance > amt) {
     * this.balance -= amt;
     * target.balance += amt;
     * }
     * }
     * <p>
     * }
     * }
     */


    /**
     * // actr应该为单例
     * private Allocator01 actr;
     * //防止死锁: 破坏占用且等待条件。直接一次性拿到所有资源
     * void transfer(Account01 target, int amt) {
     * // 一次性申请转出账户和转入账户，直到成功
     * while (!actr.apply(this, target)) {
     * <p>
     * }
     * try {
     * synchronized (this) {
     * synchronized (target) {
     * if (this.balance > amt) {
     * this.balance -= amt;
     * target.balance += amt;
     * }
     * }
     * }
     * } catch (Exception e) {
     * <p>
     * } finally {
     * actr.free(this, target);
     * }
     * }
     */

    /**
     * private int id;
     * //防止死锁: 破坏循环等待条件。按照序号大小来进行排序
     * void transfer(Account01 target, int amt) {
     * Account01 left = this;
     * Account01 right = target;
     * if (this.id > target.id) {
     * right = this;
     * left = target;
     * }
     * synchronized (left) {
     * synchronized (right) {
     * if (this.balance > amt) {
     * this.balance -= amt;
     * target.balance += amt;
     * }
     * }
     * }
     * }
     */


    // actr应该为单例
    private Allocator02 actr;

    //防止死锁: 破坏占用且等待条件。直接一次性拿到所有资源
    void transfer(Account01 target, int amt) {
        // 一次性申请转出账户和转入账户，直到成功
        actr.apply(this, target);
        try {
            synchronized (this) {
                synchronized (target) {
                    if (this.balance > amt) {
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            actr.free(this, target);
        }
    }


}
