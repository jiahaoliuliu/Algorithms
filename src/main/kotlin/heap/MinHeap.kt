package heap

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.PriorityQueue

/**
 * Max Heap:
 * Operations
 *  - Insertion
 *      add(T): Bool
 *      Complexity: O(log n)
 *  - Look up for the max element
 *      Peak(): T
 *      Complexity: O(1)
 *  - Deletion for the max element
 *      Poll(): T
 *      Complexity: O(log n)
 *  - Search for arbitrary key
 *      Complexity: O(n)
 *
 * Given an array of Strings, return the K longest strings
 *
 * Example 1
 *      Input: strings = ["this","is","a","very","longest","String"], k = 2
 *      Output: ["longest", "String"]
 *
 * Example 2:
 *      Input: strings = ["this", "is", "a", "veryy"], k = 4
 *      Output: ["this", "is", "a", "veryy"]
 *
 * Constraints:
 *      1 <= k <= strings.length <= 10^5
 *
 **/
class MinHeap {

    /**
     *
     */
    private fun topKLongestStrings(strings: Array<String>, k: Int): Array<String> {
        // 1. Init the elements
        val comparator: Comparator<String> = compareBy { it.length }
        val minHeap = PriorityQueue(comparator)

        // 2. Loop through the contents
        for (string in strings) {
            minHeap.add(string)
            // If adding a new string, the size of the heap is bigger than required, then
            // remove the one with smallest length
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }

        return minHeap.toTypedArray()
    }

    @Test
    fun test1() {
        // Given
        val strings = arrayOf("this","is","a","very","longest","String")
        val k = 2

        // When
        val result = topKLongestStrings(strings, k)

        // Then
        assertEquals(2, result.size)
        assertTrue(result.contains("longest"))
        assertTrue(result.contains("String"))
    }

    @Test
    fun test2() {
        // Given
        val strings = arrayOf("this", "is", "a", "veryy")
        val k = 4

        // When
        val result = topKLongestStrings(strings, k)

        // Then
        assertEquals(4, result.size)
        assertTrue(result.contains("this"))
        assertTrue(result.contains("is"))
        assertTrue(result.contains("a"))
        assertTrue(result.contains("veryy"))
    }

}