package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.easy;

/**
 * TODO 一句话描述
 *
 * @author huojianxiong
 * 2021/11/5 17:51
 */
public class Test {

    static class A{
        int a1;
    }

    public static void main(String[] args) {
        A a = new A();
        update1(a);
        System.out.println(a.a1);
        update2(a);
        System.out.println(a.a1);
    }

    static void update1(A a){
        a.a1 =5;
    }
    static void update2(A a){
        a = new A();
        a.a1 =10;
    }

}
