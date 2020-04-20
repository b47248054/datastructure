package linear;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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


}
