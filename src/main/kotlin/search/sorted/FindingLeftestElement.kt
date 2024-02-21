package search.sorted

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Given an array of integers and a target, find the position
 * of the target in the array. If there is more than 1 target, then
 * return the position of the leftest one
 *
 */

abstract class FindLeftestElement {

    abstract fun findLeftest(arr: IntArray, target: Int): Int

    @Test
    fun test1() {
        // Given
        val arr = intArrayOf(1,2,2,6,6,6,6,7,10)
        val target = 6

        // When
        val result = findLeftest(arr, target)

        // Then
        assertEquals(3, result)
    }

    @Test
    fun test2() {
        // Given
        val arr = intArrayOf(1,2,2,6,6,6,6,7,10)
        val target = 2

        // When
        val result = findLeftest(arr, target)

        // Then
        assertEquals(1, result)
    }

    @Test
    fun test3() {
        // Given
        val arr = intArrayOf(1)
        val target = 6

        // When
        val result = findLeftest(arr, target)

        // Then
        assertEquals(-1, result)
    }

}

class FindingLeftestElementImpl: FindLeftestElement() {

    /**
     * Based on the normal binary search
     * If the element is found, the leftest one is either the first position
     * either the one which the element on the left is smaller than the target
     *
     * Complexity:
     * - Time: O(log n)
     * - Space: O(1)
     */
    override fun findLeftest(arr: IntArray, target: Int): Int {
        var left = 0
        var right = arr.size - 1
        while (left <= right) {
            val middle = left + (right - left) / 2
            if (arr[middle] == target) {
                if (middle == 0 || arr[middle - 1] < target) {
                    return middle
                } else {
                    right = middle - 1
                }
            } else if (arr[middle] < target) {
                left = middle + 1
            } else {
                right = middle - 1
            }
        }

        return -1
    }
}