package cn.edu.aqtc.leetcode;

/**
 * 92. Reverse Linked List II
 * <p>
 * 给你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *  
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 *
 * @Description:
 * @ClassName: ReverseLinkedListII
 * @Author: zhangjj
 * @Date: 2021-03-18
 */
public class ReverseLinkedListII {

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;
        int step = 1;
        while (step < left) {
            g = g.next;
            p = p.next;
            step++;
        }

        for (int i = left; i < right; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }
        return dummyHead.next;

    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode = new ListNode(1);
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode.next = listNode2;
        System.out.println(reverseBetween(listNode, 2, 4));
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("ListNode{");
            sb.append("val=").append(val);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }
}


