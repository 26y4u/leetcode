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

    /**
     * 206. 反转链表
     * reverse-linked-list
     *
     * @author: 1004♥
     * @CreateDate 2020-08-25
     * @UpdateDate 2020-08-25
     */
    public ListNode reverseList(ListNode head) {
        return reverse(null,head);
    }
    public static ListNode reverse(ListNode pre,ListNode cur){
        if (cur == null){
            return pre;
        }
        ListNode pos = cur.next;
        cur.next = pre;
        return reverse(cur,pos);
    }

    /**
     * 203. 移除链表元素
     * remove-linked-list-elements
     *
     * @author: 1004♥
     * @CreateDate 2020-08-25
     * @UpdateDate 2020-08-25
     */

    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = pre;
        while (cur!=null && cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }
            else cur = cur.next;
        }
        return pre.next;
    }

    /**
     * 328. 奇偶链表
     * odd-even-linked-list
     *
     * @author: 1004♥
     * @CreateDate 2020-08-26
     * @UpdateDate 2020-08-26
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode even = head;
        ListNode odd = null;
        ListNode oddHead = head.next;
        ListNode cur = head.next;
        int n = 1;
        while (cur != null){
            n++;
            if (n == 2){
                odd = cur;
            }
            else if (n%2==0){
                odd.next = cur;
                odd = odd.next;
            }
            else {
                even.next = cur;
                even = even.next;
            }
            cur = cur.next;
        }
        if (even.next != null) even.next=null;
        if ( odd!=null &&  odd.next != null) odd.next=null;
        even.next = oddHead;
        return head;
    }
    public ListNode oddEvenList1(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode evenst = head;
        ListNode evened = head;
        ListNode oddst = head.next;
        ListNode odded = head.next;
        while (odded!=null && odded.next!=null && evenst.next!=null){
            evened.next = odded.next;
            evened = evened.next;
            odded.next = evened.next;
            odded = odded.next;
        }
        evened.next = oddst;
        return head;
    }

    /**
     * 234. 回文链表
     * palindrome-linked-list
     *
     * @author: 1004♥
     * @CreateDate 2020-08-27
     * @UpdateDate 2020-08-27
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next ==null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow 为链表中间值
        //将slow之后链表反转
        ListNode pre = null;
        while(slow!=null){
            ListNode next=slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        while (pre != null){
            if (head.val != pre.val){
                return false;
            }
            else {
                head = head.next;
                pre = pre.next;
            }
        }
        return true;
    }

    /**
     * 21. 合并两个有序链表
     * merge-two-sorted-lists
     *
     * @author: 1004♥
     * @CreateDate 2020-08-27
     * @UpdateDate 2020-08-27
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode st = head;
        while (l1!=null && l2 != null){
            if (l1.val <= l2.val){
                st.next = l1;
                l1 = l1.next;
                st = st.next;
            }
            else {
                st.next = l2;
                l2 = l2.next;
                st = st.next;
            }
        }
        if (l1!=null){
            st.next = l1;
        }
        if (l2!=null){
            st.next = l2;
        }
        return head.next;
    }

    /**
     * 2. 两数相加
     * add-two-numbers
     *
     * @author: 1004♥
     * @CreateDate 2020-08-27
     * @UpdateDate 2020-08-27
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        ListNode res = new ListNode(0);
        ListNode head = res;
        int c = 0;
        while (l1 != null || l2 != null || c!=0){
            ListNode temp = new ListNode(0);
            if (l1 == null && l2 !=null){
                temp.val = (l2.val + c)%10;
                temp.next = null;
                head.next = temp;
                c = (l2.val+c)/10;
                l2 = l2.next;
            }
            else if (l2 == null && l1 !=null){
                temp.val = (l1.val + c)%10;
                temp.next = null;
                head.next = temp;
                c = (l1.val+c)/10;
                l1 = l1.next;
            }
            else if (l2 == null && l1 ==null){
                temp.val = c%10;
                temp.next = null;
                head.next = temp;
                c = c/10;
            }
            else {
                temp.val = (l1.val+l2.val + c)%10;
                temp.next = null;
                head.next = temp;
                c = (l1.val+l2.val+c)/10;
                l1 = l1.next;
                l2 = l2.next;
            }
            head = head.next;
        }
        return res.next;
    }

    /**
     * 430. 扁平化多级双向链表
     * flatten-a-multilevel-doubly-linked-list
     *
     * @author: 1004♥
     * @CreateDate 2020-08-28
     * @UpdateDate 2020-08-28
     */
    public Node flatten(Node head) {
        if (head == null){
            return null;
        }
        Node cur = head;
        while (cur != null){
            while (cur.child != null){
                Node next = cur.next;
                Node child = flatten(cur.child);
                cur.next = child;
                child.prev = cur;
                cur.child = null;
                if (next != null){
                    while (cur.next != null){
                        cur = cur.next;
                    }
                    cur.next = next;
                    next.prev = cur;
                }
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 61. 旋转链表
     * rotate-list
     *
     * @author: 1004♥
     * @CreateDate 2020-08-28
     * @UpdateDate 2020-08-28
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }
        ListNode st = head;
        int len = 1;
        while (head.next != null){
            len++;
            head = head.next;
        }
        head.next = st;
        int n = 0,m=0;
        n = len-(k%len);
        for (int i = 0;i<n-1;i++){
            st = st.next;
        }
        ListNode temp = st.next;
        st.next = null;
        return temp;
    }
}
