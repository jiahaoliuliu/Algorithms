package array

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Given an array arr[] of size N, find the prefix sum of the array. A prefix sum array is another array
 * prefixSum[] of the same size, such that the value of prefixSum[i] is arr[0] + arr[1] + arr[2] . . . arr[i].
 *
 * Examples:
 *      Input: arr[] = {10, 20, 10, 5, 15}
 *      Output: prefixSum[] = {10, 30, 40, 45, 60}
 *      Explanation: While traversing the array, update the element by adding it with its previous element.
 *          prefixSum[0] = 10,
 *          prefixSum[1] = prefixSum[0] + arr[1] = 30,
 *          prefixSum[2] = prefixSum[1] + arr[2] = 40 and so on.
 *
 * Properties
 *  - Prefix sum represents the sum of all the numbers before it
 *  - If the numbers are all positive, the prefix sum will be sorted
 *  - The difference between the position i and j is the sum of all the elements between
 */
class PrefixSumArray {

    private fun prefixSum(input: IntArray): IntArray {
        val result = mutableListOf<Int>()

        for (i in input.indices) {
            if (i == 0) {
                result.add(input[i])
            } else {
                result.add(input[i] + result[i - 1])
            }
        }

        return result.toIntArray()
    }

    @Test
    fun test1() {
        // Given
        val input = intArrayOf(10, 20, 10, 5, 15)

        // When
        val result = prefixSum(input)

        // Then
        assertTrue(intArrayOf(10, 30, 40, 45, 60) contentEquals result)
    }
}