package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.easy;

import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean.ListNode;
import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean.Point;
import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.middle.TreeNode;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/7/22 17:46
 */
public class EasyImplTest {


    @Test
    public void test05() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        String s = stringStringHashMap.get("111");
        boolean empty = StringUtils.isBlank(s);
        System.out.println("1111");

    }


    @Test
    public void test04() {
        String ss = "_ut_zm=53b83d9b-e726-408c-a7d9-60f4c5b66d18; Max-Age=43200; Expires=Wed, 25-Aug-2021 20:13:30 GMT; Path=/";
        String s = ss.split(";")[0].split("=")[1];
        System.out.println(s);


    }


    @Test
    public void test03() {
        String aaa = "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,19,0,0,0,0,0,0";
        String[] split = aaa.split(",");
        Integer aa = Integer.parseInt("08");
        ArrayList<Object> objects = new ArrayList<>();
        System.out.println(1111);
    }


    @Test
    public void test02() {
        int dataZ = 54321;
        // 每500条数据开启一条线程
        int threadSize = dataZ / 7;
        // 总数据条数
        int dataSize = dataZ;
        // 线程数
        int threadNum = dataSize / threadSize + 1;
        System.out.println();

    }


    @Test
    public void getRebatePlanAmount() {
        long startTime = System.currentTimeMillis();
        List<String> list = new ArrayList<String>();

        for (int i = 1; i <= 300000; i++) {
            list.add(i + "");
        }
        // 每500条数据开启一条线程
        int threadSize = 500;
        // 总数据条数
        int dataSize = list.size();
        // 线程数
        int threadNum = dataSize / threadSize + 1;
        // 定义标记,过滤threadNum为整数
        boolean special = dataSize % threadSize == 0;

        // 创建一个线程池
        ExecutorService exec = Executors.newFixedThreadPool(threadNum);
        // 定义一个任务集合
        List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();
        Callable<Boolean> task = null;
        List<String> cutList = null;

        // 确定每条线程的数据
        for (int i = 0; i < threadNum; i++) {
            if (i == threadNum - 1) {
                if (special) {
                    break;
                }
                cutList = list.subList(threadSize * i, dataSize);
            } else {
                cutList = list.subList(threadSize * i, threadSize * (i + 1));
            }
            final List<String> listStr = cutList;
            task = new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    if (null != listStr && listStr.size() > 0) {
                        for (String str : listStr) {
                            // 调用业务方法
                            downloadFile(str);
                        }
                    }
                    return true;
                }
            };
            tasks.add(task);
        }

        try {
            exec.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 关闭线程池
        exec.shutdown();
        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        System.out.println("执行时间：" + diff);
    }

    private static void downloadFile(String str) {
        //执行多线程文件下载业务逻辑
        System.out.println(str);
    }

    @Test
    public void getRebatePlanAmount1() {
        long startTime = System.currentTimeMillis();
        List<String> list = new ArrayList<String>();

        for (int i = 1; i <= 300000; i++) {
            list.add(i + "");
        }
        for (String s : list) {
            System.out.println(s);
        }
        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        System.out.println("执行时间：" + diff);

    }

    @Test
    public void test01() {
        LinkedList<Integer> adj[] = new LinkedList[5];
        for (int i = 0; i < 5; ++i) {
            adj[i] = new LinkedList<>();
        }
        adj[3].add(3);
        adj[3].add(4);
        System.out.println(11);
    }

    private static Point[] getMinPoint(List<Point> listPoint) {
        if (listPoint.size() == 1 | listPoint.size() == 0) {
            return null;
        }
        //对listPoint 按照x坐标由小变大,在由y从小变大
        //do something

        int left = 0, right = listPoint.size();
        Point[] minIndex = getMinPointByMerge(listPoint, left, right);
        return minIndex;
    }

    private static Point[] getMinPointByMerge(List<Point> listPoint, int left, int right) {
        Double minDistance = getMinDistance(listPoint.get(0), listPoint.get(1));
        Point[] result = new Point[2];
        result[0] = listPoint.get(0);
        result[1] = listPoint.get(1);
        if (right - left <= 4) {
            List<Point> newList = new ArrayList<Point>();
            newList.addAll(listPoint.subList(left, right));
            result = getNexts(listPoint);
        } else {
            Point[] leftPoint = getMinPointByMerge(listPoint, left, (left + right) / 2);
            Point[] rightPoint = getMinPointByMerge(listPoint, (left + right) / 2 + 1, right);
            Double leftMin = getMinDistance(leftPoint[0], leftPoint[1]);
            Double rightMin = getMinDistance(rightPoint[0], rightPoint[1]);
            if (leftMin <= rightMin) {
                result = leftPoint;
                minDistance = leftMin;
            } else {
                result = rightPoint;
                minDistance = rightMin;
            }
            //根据鹊巢原理，中间点位只会出现在中间6个（可以加上x y都是int ，然后自己模拟一下）
            if (listPoint.size() > 6) {
                List<Point> newList = new ArrayList<Point>();
                newList.addAll(listPoint.subList((left + right) / 2 - 3, (left + right) / 2 + 3));
                result = getNexts(newList);
            } else {
                result = getNexts(listPoint);
            }
        }
        return result;
    }


    private static Point[] getNexts(List<Point> listPoint) {
        Point[] result = new Point[2];
        Double minDistance = getMinDistance(listPoint.get(0), listPoint.get(1));
        result[0] = listPoint.get(0);
        result[1] = listPoint.get(1);
        for (int i = 1; i < listPoint.size() - 1; i++) {
            for (int j = i + 1; j < listPoint.size(); j++) {
                Double minDistance1 = getMinDistance(listPoint.get(i), listPoint.get(j));
                if (minDistance1 < minDistance) {
                    result[0] = listPoint.get(i);
                    result[1] = listPoint.get(j);
                }
            }
        }
        return result;
    }

    private static Double getMinDistance(Point x, Point y) {
        double dis = Math.sqrt(Math.pow(x.getX() - y.getX(), 2) + Math.pow(x.getY() - y.getY(), 2));
        return dis;
    }


    // b表示模式串，m表示模式串的长度
    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }


    /**
     * 查找最后一个值小于等于给定值的元素
     *
     * @param a      数组
     * @param length 数组长度
     * @param i      定值
     * @return
     */
    private int binarySearch5(int[] a, int length, int i) {
        int s = 0;
        int e = length - 1;
        while (s <= e) {
            int m = s + ((e - s) >> 1);
            if (a[m] > i) {
                e = m - 1;
            } else {
                if (m == length - 1 || a[m + 1] > i) {
                    return m;
                } else {
                    s = m + 1;
                }
            }
        }
        return -1;
    }


    /**
     * 查找第一个值大于等于给定值的元素
     *
     * @param a      数组
     * @param length 数组长度
     * @param i      定值
     * @return
     */
    private int binarySearch4(int[] a, int length, int i) {
        int s = 0;
        int e = length - 1;
        while (s <= e) {
            int m = s + ((e - s) >> 1);
            if (a[m] >= i) {
                if (m == 0 || a[m - 1] < i) {
                    return m;
                } else {
                    e = m - 1;
                }
            } else if (a[m] < i) {
                s = m + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     * @param a      数组
     * @param length 数组长度
     * @param i      定值
     * @return
     */
    private int binarySearch3(int[] a, int length, int i) {
        int s = 0;
        int e = length - 1;
        while (s <= e) {
            int m = s + ((e - s) >> 1);
            if (a[m] > i) {
                e = m - 1;
            } else if (a[m] < i) {
                s = m + 1;
            } else {
                //如果m的后一个值不是i，就证明m是数组中的第一个定值
                if (m == length - 1 || a[m + 1] != i) {
                    return m;
                } else {
                    s = m + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个值等于给定值的元素
     *
     * @param a      数组
     * @param length 数组长度
     * @param i      定值
     * @return
     */
    private int binarySearch2(int[] a, int length, int i) {
        int s = 0;
        int e = length - 1;
        while (s <= e) {
            int m = s + ((e - s) >> 1);
            if (a[m] > i) {
                e = m - 1;
            } else if (a[m] < i) {
                s = m + 1;
            } else {
                //如果m的前一个值不是i，就证明m是数组中的第一个定值
                if (m == 0 || a[m - 1] != i) {
                    return m;
                } else {
                    e = m - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 数组中有目标值的话，返回数组下标，没有的话返回-1
     *
     * @param a 数组
     * @param s 开始
     * @param e 结尾
     * @param i 目标值
     * @return
     */
    private int binarySearch1(int[] a, int s, int e, int i) {
        if (s > e) {
            return -1;
        }
        int m = (s + e) / 2;
        if (a[m] == i) {
            return m;
        } else if (a[m] < i) {
            return binarySearch1(a, m + 1, e, i);
        } else {
            return binarySearch1(a, s, m - 1, i);
        }
    }

    /**
     * 数组中有目标值的话，返回数组下标，没有的话返回-1
     *
     * @param a      数组
     * @param length 数据长度
     * @param i      目标值
     * @return
     */
    private int binarySearch(int[] a, int length, int i) {
        int s = 0;
        int e = length - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (a[m] == i) {
                return m;
            } else if (a[m] < i) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }

    /**
     * @param a
     * @param max 数据最大的是几位数
     */
    private void radixSort(int[] a, int max) {
        int length = a.length;
        int[] temp = new int[length];
        int[] bucket = new int[length];

        //判断位数
        for (int i = 1; i <= max; i++) {
            //清空
            for (int j = 0; j < length; j++) {
                temp[j] = 0;
            }
            //判断位数上之前别分有几个
            for (int j = 0; j < length; j++) {
                temp[getFigure(a[j], i)]++;
            }
            for (int j = 1; j < length; j++) {
                temp[j] = temp[j] + temp[j - 1];
            }
            //类似计数排序的精髓
            for (int j = length - 1; j >= 0; j--) {
                bucket[temp[getFigure(a[j], i)] - 1] = a[j];
                temp[getFigure(a[j], i)]--;
            }
            //赋值
            for (int j = 0; j < length; j++) {
                a[j] = bucket[j];
            }
        }

    }

    private int getFigure(int i, int k) {
        return (i / new Double(Math.pow(10, k - 1)).intValue()) % 10;
    }


    private void countingSort(int[] a, int length) {
        if (length < 1) {
            return;
        }
        //判断最大的数据
        int max = a[0];
        for (int i = 1; i < length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        //申请一个数组
        int[] b = new int[max + 1];
        //计算个数
        for (int i = 0; i < length; i++) {
            b[a[i]]++;
        }
        //计算每个位置前面有多少个数据
        for (int i = 1; i <= max; i++) {
            b[i] = b[i] + b[i - 1];
        }
        int[] c = new int[length];
        //这样子倒着来的话，就是稳定的排序，相同数字前后位置没有发生变化
        for (int i = length - 1; i >= 0; i--) {
            //减1是下标从0开始，而个数是从1开始
            c[b[a[i]] - 1] = a[i];
            b[a[i]]--;
        }
        //赋值
        for (int i = 0; i < length; i++) {
            a[i] = c[i];
        }

    }

    private void bucketSort(int[] a) {
        ArrayList<LinkedList<Integer>> linkedLists = new ArrayList<>();
        //创建10个桶
        for (int i = 0; i < 10; i++) {
            linkedLists.add(new LinkedList<Integer>());
        }
        for (int i = 0; i < a.length; i++) {
            //判断放入位置
            int result = getIndex(a[i]);
            //插入排序
            insertSort(linkedLists.get(result), a[i]);
        }
        int index = 0;
        for (LinkedList<Integer> ll : linkedLists) {
            for (Integer va : ll) {
                a[index++] = va;
            }
        }
    }

    private void insertSort(LinkedList<Integer> integers, int num) {
        integers.add(num);
        if (integers.size() > 1) {
            for (int i = 1; i < integers.size(); i++) {
                int value = integers.get(i);
                int j = i - 1;
                for (; j > 0; j--) {
                    if (integers.get(i) < integers.get(j)) {
                        integers.set(j + 1, integers.get(j));
                    } else {
                        break;
                    }
                }
                integers.set(j, value);
            }
        }
    }

    private int getIndex(int i) {
        return i % 10;
    }

    private void quick_sort_c(int[] a, int s, int e) {
        if (s > e) {
            return;
        }
        int i = s, j = e;

        int temp = a[s];
        while (i < j) {
            while (a[j] >= temp && i < j) {
                j--;
            }
            while (a[i] <= temp && i < j) {
                i++;
            }

            //交换位置
            if (i < j) {
                int i1 = a[i];
                a[i] = a[j];
                a[j] = i1;
            }
        }
        a[s] = a[i];
        a[i] = temp;


        quick_sort_c(a, s, j - 1);
        quick_sort_c(a, j + 1, e);
    }

    private int[] merge_sort_c(int[] a, int s, int e) {
        if (e <= s) {
            return new int[0];
        }

        int m = (s + e) / 2;
        int[] lefts = Arrays.copyOfRange(a, s, m - 1);
        int[] rights = Arrays.copyOfRange(a, m, e);
        int[] left = merge_sort_c(lefts, s, m - 1);
        int[] right = merge_sort_c(rights, m, e);
        return merge_sort(left, right);
    }

    private int[] merge_sort(int[] left, int[] right) {
        if (left == null || left.length == 0) {
            return new int[0];
        }
        if (right == null || right.length == 0) {
            return new int[0];
        }
        int leftL = left.length;
        int rightL = right.length;
        int[] ints = new int[leftL + rightL];
        int a = 0, b = 0, c = 0;
        while (a < leftL && b < rightL) {
            if (left[a] > right[b]) {
                ints[c] = right[b];
                b++;
            } else {
                ints[c] = right[a];
                a++;
            }
            c++;
        }
        if (a < leftL) {
            while (a < leftL) {
                ints[c] = right[a];
                a++;
                c++;
            }
        } else {
            while (b < rightL) {
                ints[c] = right[b];
                b++;
                c++;
            }
        }
        return ints;
    }

    @Test
    public void twoSum() {
    }

    @Test
    public void reverse() {
    }

    @Test
    public void isPalindrome() {
    }

    @Test
    public void romanToInt() {
    }

    @Test
    public void longestCommonPrefix() {
        EasyImpl easy = new EasyImpl();
        String s = easy.longestCommonPrefix(new String[]{"qwertyu", "qwe", "qwer"});
        System.out.println(s);
    }

    @Test
    public void isValid() {
        String sss = "((()(())))";
        EasyImpl easy = new EasyImpl();
        boolean valid = easy.isValid(sss);
        System.out.println(valid);
    }

    @Test
    public void mergeTwoLists() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);

        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode4;

        listNode5.next = listNode6;
        listNode6.next = listNode7;

        EasyImpl easy = new EasyImpl();
        ListNode listNode = easy.mergeTwoLists(listNode1, listNode5);
        System.out.println("1111");

    }

    @Test
    public void removeDuplicates() {
        int[] mums = new int[]{1, 1, 1, 2};
        EasyImpl easy = new EasyImpl();
        int i = easy.removeDuplicates(mums);
        System.out.println("111");
    }

    @Test
    public void removeElement() {
        int[] mums = new int[]{1, 1, 1, 2};
        EasyImpl easy = new EasyImpl();
        int i = easy.removeElement(mums, 1);
        System.out.println("111");
    }

    @Test
    public void strStr() {
        EasyImpl easy = new EasyImpl();
        int i = easy.strStr("qwertyuiop", "we");
        System.out.println("111");
    }

    @Test
    public void reverseList() {
        EasyImpl easy = new EasyImpl();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        //        ListNode listNode4 = new ListNode(4);
        //        ListNode listNode5 = new ListNode(5);
        //        ListNode listNode6 = new ListNode(6);
        //        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        //        listNode3.next=listNode4;
        //        listNode4.next=listNode5;
        //        listNode5.next=listNode6;
        //        listNode6.next=listNode7;
        ListNode node = easy.reverseList(listNode1);
        System.out.println("1111");
    }

    @Test
    public void KthLargest() {
        int[] ints = new int[]{1, 3, 5, 7, 9};
        KthLargest_List kthLargest_priorityQueue = new KthLargest_List(3, ints);
        kthLargest_priorityQueue.add(8);

        //        List<Integer> list = new ArrayList<>();
        //        list.add(2);
        //        list.add(4);
        //        list.add(3);
        //        list.add(6);
        //        list.add(5);

        System.out.println("1111");

    }


    @Test
    public void maxSlidingWindow() {
        int[] ints = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        EasyImpl easy = new EasyImpl();
        int[] ints1 = easy.maxSlidingWindow(ints, 3);
        System.out.println("1111");

    }

    @Test
    public void isAnagram() {
        EasyImpl easy = new EasyImpl();
        Boolean result = easy.isAnagram("abcde", "edcba");
        System.out.println("1111");

    }

    @Test
    public void threeSum() {
        int[] ints = new int[]{1, 3, -1, -3, 5, 3, -6, 7, 7};
        EasyImpl easy = new EasyImpl();
        List<List<Integer>> result = easy.threeSum(ints);
        System.out.println("1111");

    }

    @Test
    public void majorityElement() {
        EasyImpl easy = new EasyImpl();
        Integer result = easy.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(result);
    }

    @Test
    public void maxProfit() {
        EasyImpl easy = new EasyImpl();
        Integer result = easy.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        //        Integer result = easy.maxProfit(new int[]{1,2,3,4,5});
        System.out.println(result);
    }

    @Test
    public void maxDepth() {
        TreeNode treeNode = new TreeNode(3);

        TreeNode treeNode1 = new TreeNode(9);

        TreeNode treeNode2 = new TreeNode(20);

        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);

        //        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        EasyImpl easy = new EasyImpl();
        //        int i = easy.maxDepth(treeNode);
        int i = easy.minDepth(treeNode);
        System.out.println(i);
    }


    private static void insertionSort(List<Integer> a, int n) {
        if (n <= 0) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = a.get(i);
            int j = i - 1;
            for (; j >= 0; j--) {
                //进行数据交换
                if (a.get(j) < value) {
                    a.set(j + 1, a.get(j));
                } else {
                    break;
                }
            }
            //插入数据
            a.set(j + 1, value);
        }
    }


    private static void insertionSort(int[] a, int n) {
        if (n <= 0) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                //进行数据交换
                if (a[j] < value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            //插入数据
            a[j + 1] = value;
        }
    }

}