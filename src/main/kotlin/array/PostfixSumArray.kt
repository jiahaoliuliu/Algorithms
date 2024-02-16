package array

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Given an array arr[] of size N, find the postfix sum of the array. A postfix sum array is another array
 * postfixSum[] of the same size, such that the value of postfixSum[i] is arr[i+1] + arr[i+2] + arr[i+3] . . . arr[array.length - 1].
 *
 * Examples:
 *      Input: arr[] =         {10, 20, 10, 5,  15}
 *      Output: postfixSum[] = {60, 50, 30, 20, 15}
 *      Explanation: While traversing the array, update the element by adding it with its next element.
 *          postfixSum[array.length-1] = 15
 *          postfixSum[array.length-2] =  postfixSum[array.length-1] +  arr[array.length-2]
 *          postfixSum[array.length-3] =  postfixSum[array.length-2] +  arr[array.length-3]
 *          and so on
 *
 * Properties
 *  - Prefix sum represents the sum of all the numbers before it
 *  - If the numbers are all positive, the prefix sum will be sorted from big to small
 *  - The difference between the position i and j is the sum of all the elements between
 */
class PostfixSumArray {

    private fun postFixSum(input: IntArray): IntArray {
        val result = IntArray(input.size)

        for (i in input.lastIndex downTo 0) {
            if (i == input.lastIndex) {
                result[i] = input[i]
            } else {
                result[i] = (input[i] + result[i + 1])
            }
        }

        return result
    }

    @Test
    fun test1() {
        // Given
        val input = intArrayOf(10, 20, 10, 5, 15)

        // When
        val result = postFixSum(input)

        // Then
        assertTrue(intArrayOf(60, 50, 30, 20, 15) contentEquals result)
    }
}