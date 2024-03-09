package linkedlist.easy

import linkedlist.ListNode
import linkedlist.checkValues
import linkedlist.toLinkedList
import org.junit.Assert.*
import org.junit.Test

/**
 * Remove linked list elements
 *
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has
 * Node.val == val, and return the new head.
 *
 *
 * Example 1:
 *      Input: head = [1,2,6,3,4,5,6], val = 6
 *      Output: [1,2,3,4,5]
 *
 * Example 2:
 *      Input: head = [], val = 1
 *      Output: []
 *
 * Example 3:
 *      Input: head = [7,7,7,7], val = 7
 *      Output: []
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 10^4].
 *      1 <= Node.val <= 50
 *      0 <= val <= 50
 */
abstract class RemoveLinkedListElements {

    abstract fun removeElements(head: ListNode?, `val`: Int): ListNode?

    @Test
    fun testCornerCase1() {
        // Given
        val list = emptyList<Int>()
        val head = list.toLinkedList()
        val value = 3

        // When
        val result = removeElements(head, value)

        // Then
        assertNull(result)
    }

    @Test
    fun testCornerCase2() {
        // Given
        val list = listOf(7, 7, 7, 7)
        val head = list.toLinkedList()

        val value = 7

        // When
        val result = removeElements(head, value)

        // Then
        assertNull(result)
    }

    @Test
    fun testCornerCase3() {
        // Given
        val list = listOf(7, 8, 9, 10)
        val head = list.toLinkedList()

        val value = 7

        // When
        val result = removeElements(head, 7)

        // Then
        result.checkValues(listOf(8, 9, 10))
    }

    @Test
    fun test1() {
        // Given
        val list = listOf(1, 2, 6, 3, 4, 5, 6)
        val head = list.toLinkedList()
        val value = 6

        // When
        val result = removeElements(head, value)

        // Then
        result.checkValues(listOf(1, 2, 3, 4, 5, 6))
    }
}

class RemoveLinkedListElementsOptimalSol: RemoveLinkedListElements() {

    /**
     * Algorithm
     *
     * Create a sentinel node that is before than the head
     * Have the previous node point to the sentinel node
     * loop through the linked list
     * return sentinel next as the head
     *
     * Sentinel
     *  |
     * [1] -> [2] -> [3] -> [4] -> [5]
     *   prev  ^
     *          curr  ^
     *
     */
    override fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        // 1. Init
        val sentinel = ListNode(0)
        sentinel.next = head
        var current:ListNode? = head
        var previous: ListNode = sentinel

        // 2. Loop
        while(current != null) {
            // If the current node value matches, skip the current node
            if (current.`val` == `val`) {
                previous.next = current.next
                current = current.next
                // No update on previous node
            } else {
                previous = current
                current = current.next
            }
        }

        // 3. Return result
        return sentinel.next
    }

}
