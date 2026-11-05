class Solution {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow.next);
        ListNode firstHalf = head;
        ListNode temp = secondHalf;

        boolean isPalindrome = true;

        while (temp != null) {

            if (firstHalf.val != temp.val) {
                isPalindrome = false;
                break;
            }

            firstHalf = firstHalf.next;
            temp = temp.next;
        }
        slow.next = reverse(secondHalf);

        return isPalindrome;
    }
    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
}
