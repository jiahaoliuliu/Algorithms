package search.sorted

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Given an array of integers and a target, find the position
 * of the target in the array. If there is more than 1 target, then
 * return the position of the rightest one
 */
abstract class FindRightestElement {

    abstract fun findRightest(arr: IntArray, target: Int): Int

    @Test
    fun test1() {
        // Given
        val arr = intArrayOf(1,2,2,6,6,6,6,7,10)
        val target = 6

        // When
        val result = findRightest(arr, target)

        // Then
        assertEquals(6, result)
    }

    @Test
    fun test2() {
        // Given
        val arr = intArrayOf(1,2,2,6,6,6,6,7,10)
        val target = 2

        // When
        val result = findRightest(arr, target)

        // Then
        assertEquals(2, result)
    }

    @Test
    fun test3() {
        // Given
        val arr = intArrayOf(1)
        val target = 6

        // When
        val result = findRightest(arr, target)

        // Then
        assertEquals(-1, result)
    }

}

class FindingRightestElementImpl: FindRightestElement() {

    /**
     * Based on the normal binary search
     * If the element is found, the rightest one is either the last position
     * either the one which the element on the right is bigger than the target
     *
     * Complexity:
     * - Time: O(log n)
     * - Space: O(1)
     */
    override fun findRightest(arr: IntArray, target: Int): Int {
        var left = 0
        var right = arr.size - 1
        while (left <= right) {
            val middle = left + (right - left) / 2
            if (arr[middle] == target) {
                if (middle == arr.size - 1|| arr[middle + 1] > target) {
                    return middle
                } else {
                    left = middle + 1
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