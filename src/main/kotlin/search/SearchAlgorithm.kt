package search

import org.junit.Assert.assertEquals
import org.junit.Test

abstract class SearchAlgorithm<T> {

    /**
     * Finding the position of the target in the arr
     * If the target cannot be found, return -1
     *
     */
    abstract fun <T> search(arr: Array<T>, target: T): Int

    @Test
    fun test1() {
        // Given
        val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val target = 5

        // When
        val result = search(arr, target)

        // Then
        assertEquals(4, result)
    }

    @Test
    fun test2() {
        // Given
        val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val target = 11

        // When
        val result = search(arr, target)

        // Then
        assertEquals(-1, result)
    }

    @Test
    fun test3() {
        // Given
        val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val target = 3

        // When
        val result = search(arr, target)

        // Then
        assertEquals(2, result)
    }

    @Test
    fun test4() {
        // Given
        val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val target = 8

        // When
        val result = search(arr, target)

        // Then
        assertEquals(7, result)
    }

}