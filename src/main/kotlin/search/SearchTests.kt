package search

import org.junit.Assert.assertEquals
import org.junit.Test

abstract class SearchTests {

    /**
     * Finding the position of the target in the arr
     * If the target cannot be found, return -1
     *
     */
    abstract fun search(arr: IntArray, target: Int): Int

    @Test
    fun test1() {
        // Given
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val target = 5

        // When
        val result = search(arr, target)

        // Then
        assertEquals(4, result)
    }

}