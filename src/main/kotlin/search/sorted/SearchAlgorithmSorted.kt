package search.sorted

import org.junit.Assert
import org.junit.Test

abstract class SearchAlgorithmSorted<T: Comparable<T>> {

    /**
     * Finding the position of the target in the arr
     * If the target cannot be found, return -1
     */
    abstract fun <T:Comparable<T>> search(arr: Array<T>, target: T): Int

    @Test
    fun test1() {
        // Given
        val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val target = 5

        // When
        val result = search(arr, target)

        // Then
        Assert.assertEquals(4, result)
    }

    @Test
    fun test2() {
        // Given
        val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val target = 11

        // When
        val result = search(arr, target)

        // Then
        Assert.assertEquals(-1, result)
    }

    @Test
    fun test3() {
        // Given
        val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val target = 3

        // When
        val result = search(arr, target)

        // Then
        Assert.assertEquals(2, result)
    }

    @Test
    fun test4() {
        // Given
        val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val target = 8

        // When
        val result = search(arr, target)

        // Then
        Assert.assertEquals(7, result)
    }

}