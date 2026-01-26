from typing import Optional

from Problem_19 import ListNode


class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        prev = dummy
        while head and head.next:
            first = head
            second = head.next
            prev.next = second
            first.next = second.next
            second.next = first
            prev = first
            head = first.next
        return dummy.next
