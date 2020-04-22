package linear;

import org.junit.Test;

import java.util.*;

/**
 * @author liuzhongxu
 * @date 2020/4/17
 */
public class TestLinkedList {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    private void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
        System.out.println();

    }

    /**
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null, next; // 模型 反转后链表的头节点，当前节点指针，当前子链表
        while (null != head) {// 当前节点指针不为空
            next = head.next;// 找子链表
            head.next = newHead;// 改尾指针，指向新头节点
            newHead = head;// 替换反转后链表头节点，为当前节点
            head = next;// 向后移动，处理子链表
        }
        return newHead;// 返回反转后链表头节点
    }

    @Test
    public void testReverse(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printList(node1);
        ListNode r_node = reverseList(node1);
        printList(r_node);

    }

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     *  
     *
     * 示例:
     *
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode swapPairs(ListNode head) {
//        ListNode A = null, B = null, newHead = null, cur = head, next;// 模型 A,B两个节点为一个处理单元，新头节点，当前节点指针，子链表
//        if (null != cur && cur.next != null) {
//            A = cur;
//            B = cur.next;
//            next = cur.next.next;
//
//            A.next = next;
//            B.next = A;
//
//            newHead = B;
//
//            A.next = swapPairs(next);
//        }else{
//            return cur;
//        }
//        return newHead;
        if(head == null || head.next == null){ // 模型，前->head->next->后
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    @Test
    public void testSwapPairs() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        printList(node1);
        ListNode r_node = swapPairs(node1);
        printList(r_node);
    }

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     *
     * 说明：不允许修改给定的链表。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode pos = null;
        Set<ListNode> nodes = new HashSet<>();
        while (null != head) {
            if (nodes.contains(head)) {
                pos = head;
                break;
            }
            nodes.add(head);
            head = head.next;
        }
        return pos;
    }

    /**
     * 2. 两数相加
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int off = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                off += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                off += l2.val;
                l2 = l2.next;
            }
            result.next = new ListNode(off % 10);
            result = result.next;
            off = off / 10;
        }
        if (off != 0) {
            result.next = new ListNode(off);
        }
        return head.next;
    }

    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 思路
     * 标签：链表、递归
     * 这道题可以使用递归实现，新链表也不需要构造新节点，我们下面列举递归三个要素
     * 终止条件：两条链表分别名为 l1 和 l2，当 l1 为空或 l2 为空时结束
     * 返回值：每一层调用都返回排序好的链表头
     * 本级递归内容：如果 l1 的 val 值更小，则将 l1.next 与排序好的链表头相接，l2 同理
     * O(m+n)O(m+n)，mm 为 l1的长度，nn 为 l2 的长度
     *
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/hua-jie-suan-fa-21-he-bing-liang-ge-you-xu-lian-bi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        System.out.print("l1:");printList(l1);
        System.out.print("l2:");printList(l2);
        System.out.println("-----------");
        if (null == l1) {
            return l2;
        }

        if (null == l2) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    @Test
    public void testMergeTwoLists() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(2);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(2);

        ListNode l3 = mergeTwoLists(l1, l2);
        printList(l3);

    }

    /**
     * 23. 合并K个排序链表
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     *
     * 示例:
     *
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode result = new ListNode(0);
        ListNode head = result;

        int len = lists.length;
        Queue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val<o2.val)return -1;
                else if(o1.val==o2.val)return 0;
                else return 1;
            }
        });
        for (ListNode node : lists) {
            while (null != node) {
                queue.add(node);
                node = node.next;
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            node.next = null;
            result.next = node;
            result = result.next;
        }

        return head.next;
    }

    @Test
    public void testMergeKLists() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);

        ListNode l3 = new ListNode(7);
        l3.next = new ListNode(8);
//        l3.next.next = new ListNode(9);

        ListNode[] listNodes = {l1, l2, l3};

        ListNode l4 = mergeKLists(listNodes);

        printList(l4);
    }

    /**
     * 148. 排序链表
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     *
     * 示例 1:
     *
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * 示例 2:
     *
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 通过递归实现链表归并排序，有以下两个环节：
     *
     * 分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
     * 我们使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
     * 找到中点 slow 后，执行 slow.next = None 将链表切断。
     * 递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
     * cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。
     * 合并 merge 环节： 将两个排序链表合并，转化为一个排序链表。
     * 双指针法合并，建立辅助ListNode h 作为头部。
     * 设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，由小到大加入合并链表头部，指针交替前进，直至添加完两个链表。
     * 返回辅助ListNode h 作为头部的下个节点 h.next。
     * 时间复杂度 O(l + r)，l, r 分别代表两个链表长度。
     * 当题目输入的 head == None 时，直接返回None。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (null == head || head.next == null) { // 当题目输入的 head == None 时，直接返回None。
            return head;
        }
        // fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = null;// 找到中点 slow 后，执行 slow.next = None 将链表切断。

        // 递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        System.out.print("left:");printList(left);
        System.out.print("right:");printList(right);

        ListNode result = new ListNode(0);// 双指针法合并，建立辅助ListNode h 作为头部。
        ListNode h = result;

        while (left != null && right != null) {// 设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，由小到大加入合并链表头部，指针交替前进，直至添加完两个链表。
            if (left.val < right.val) {
                result.next = left;
                left = left.next;
            }else {
                result.next = right;
                right = right.next;
            }
            result = result.next;
        }

        result.next = left != null ? left : right; // 返回辅助ListNode h 作为头部的下个节点 h.next。

        return h.next;
    }

    @Test
    public void testSortList() {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = sortList(l1);

        printList(l2);
    }


}
