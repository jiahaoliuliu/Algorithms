package linkedlist

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 *      Input: head = [1,2,3,4,5]
 *      Output: [3,4,5]
 *      Explanation: The middle node of the list is node 3.
 *
 * Example 2:
 *      Input: head = [1,2,3,4,5,6]
 *      Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * Constraints:
 *      The number of nodes in the list is in the range [1, 100].
 *      1 <= Node.val <= 100
 */
abstract class MiddleOfALinkedList {

    abstract fun middleNode(head: ListNode?): ListNode?

    @Test
    fun testCornerCase1() {
        // Given
        val node1 = null

        // When
        val result = middleNode(node1)

        // Then
        assertEquals(null, result)
    }

    @Test
    fun test1() {
        // Given
        val list = listOf(1, 2, 3, 4, 5)
        val head = list.toLinkedList()

        // When
        val result = middleNode(head)

        // Then
        assertEquals(head?.next?.next, result)
    }

    @Test
    fun test2() {
        // Given
        val list = listOf(1, 2, 3, 4, 5, 6)
        val head = list.toLinkedList()

        // When
        val result = middleNode(head)

        // Then
        assertEquals(head?.next?.next?.next, result)
    }
}

class MiddleOfALinkedListImpl: MiddleOfALinkedList() {

    /**
     * Initial thoughts
     *
     * The middle of the string could be achieved using fast and slow pointers
     *
     */
    override fun middleNode(head: ListNode?): ListNode? {
        // 1. Init the value
        var fastPointer = head
        var slowPointer = head

        // 2. Loop
        while (fastPointer?.next != null) {
            fastPointer = fastPointer.next?.next
            slowPointer = slowPointer?.next
        }

        // 3. Return result
        return slowPointer
    }

}