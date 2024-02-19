package heap

import org.junit.Assert.assertEquals
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
 * Problem
 * Kth largest element in an array
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 * Example 1:
 *      Input: nums = [3,2,1,5,6,4], k = 2
 *      Output: 5
 *
 * Example 2:
 *      Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 *      Output: 4
 *
 * Constraints:
 *      1 <= k <= nums.length <= 10^5
 *      -10^4 <= nums[i] <= 10^4
 */
class MaxHeap {

    /**
     * Solution:
     * Build an max heap and return the kth largest element
     */
    private fun findKthLargest(nums: IntArray, k: Int): Int {
        // 1. Init the values
        val maxComparator: Comparator<Int> = Comparator { o1, o2 -> o2 - o1 }
        val maxHeap = PriorityQueue(maxComparator)
        var result = 0
        var iteration = k

        // 2. Loop
        for (num in nums) {
            maxHeap.add(num)
        }

        // 3. Update the result
        while (iteration > 0) {
            result = maxHeap.poll()
            iteration--
        }

        return result
    }

    @Test
    fun test1() {
        // Given
        val nums = intArrayOf(3,2,1,5,6,4)
        val k = 2

        // When
        val result = findKthLargest(nums, k)

        // Then
        assertEquals(5, result)
    }

    @Test
    fun test2() {
        // Given
        val nums = intArrayOf(3,2,3,1,2,4,5,5,6)
        val k = 4

        // When
        val result = findKthLargest(nums, k)

        // Then
        assertEquals(4, result)
    }
}