class Problem_2 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode ptr = result;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            ptr.next = new ListNode(sum % 10);
            ptr = ptr.next;
        }

        if (carry == 1) {
            ptr.next = new ListNode(1);
        }

        return result.next;
    }
    public static void main(String[] args) {
        Problem_2 obj = new Problem_2();

        // l1 = 2 -> 4 -> 3
        ListNode l1 = new ListNode(2,
                        new ListNode(4,
                        new ListNode(3)));

        // l2 = 5 -> 6 -> 4
        ListNode l2 = new ListNode(5,
                        new ListNode(6,
                        new ListNode(4)));

        ListNode res = obj.addTwoNumbers(l1, l2);

        while (res != null) {
            System.out.print(res.val);
            if (res.next != null) System.out.print(" -> ");
            res = res.next;
        }
    }
}
