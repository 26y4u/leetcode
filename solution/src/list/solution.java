package list;

public class solution {

    /**
     * 141.环形链表
     * linked-list-cycle
     * 快慢指针解法
     *
     * @author: 1004♥
     * @CreateDate 2020-08-24
     * @UpdateDate 2020-08-24
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
         ListNode slow = head;
         ListNode fast = head.next;

         while (slow != fast){
             if (fast == null || fast.next == null){ // 快指针先到达最后
                 return false;
             }
             else {
                 slow = slow.next;
                 fast = fast.next.next;
             }
         }
         return true;
    }

    /**
     * 160.相交链表
     * intersection-of-two-linked-lists
     *
     * @author: 1004♥
     * @CreateDate 2020-08-25
     * @UpdateDate 2020-08-25
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null||headB == null){
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa!=pb){
            if (pa.next == null && pb.next == null){
                return null;
            }
            if (pa.next==null){
                pa = headB;
                pb = pb.next;
            }
            else if (pb.next == null){
                pa = pa.next;
                pb = headA;
            }
            else {
                pa = pa.next;
                pb = pb.next;
            }
        }
        return pa;
    }
    /**
     * 19. 删除链表的倒数第N个节点
     * remove-nth-node-from-end-of-list
     *
     * @author: 1004♥
     * @CreateDate 2020-08-25
     * @UpdateDate 2020-08-25
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode ps = head;
        ListNode pe = head;
        for (int i = 0 ;i<n;i++){
            ps = ps.next;
        }
        if (ps == null){
            return head.next;
        }
        while (ps.next!= null){
            ps = ps.next;
            pe = pe.next;
        }
        pe.next = pe.next.next;
        return head;
    }
}
