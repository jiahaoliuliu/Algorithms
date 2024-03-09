package linkedlist.easy

import linkedlist.ListNode
import linkedlist.toLinkedList
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Length of a linked list
 *
 */
abstract class LinkedListLength {

    abstract fun length(head: ListNode?): Int

    @Test
    fun testCornerCase() {
        // Given
        val head = null

        // When
        val result = length(head)

        // Then
        assertEquals(0, result)
    }

    @Test
    fun testSimple1() {
        // Given
        val list = listOf(1)
        val head = list.toLinkedList()

        // When
        val result = length(head)

        // Then
        assertEquals(1, result)
    }

    @Test
    fun testSimple2() {
        // Given
        val list = listOf(1, 2, 3, 4, 5, 6)
        val head = list.toLinkedList()

        // When
        val result = length(head)

        // Then
        assertEquals(6, result)
    }
}

class LinkedListLengthImpl: LinkedListLength() {

    /**
     * Iterate through the linked list until the pointer is null
     */
    override fun length(head: ListNode?): Int {
        // 1. Init the value
        var result = 0
        var iterator = head

        // 2. Loop
        while(iterator != null) {
            result++
            iterator = iterator.next
        }

        // 3. Return result
        return result
    }

}