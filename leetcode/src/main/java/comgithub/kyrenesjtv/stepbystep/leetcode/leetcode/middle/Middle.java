package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.middle;

import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean.ListNode;
import comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.bean.ListNodeCircle;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2019/8/5 15:29
 */
public interface Middle {


    /**
     *  24:两两交换链表中的节点
     *
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * @param head
     * @return
     */
    ListNode swapPairs(ListNode head);



    /**
     * 142: 环形链表2
     *
     *给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     * 说明：不允许修改给定的链表。
     *
     *
     * @param head
     * @return
     */
    ListNodeCircle detectCycle(ListNodeCircle head);




}
