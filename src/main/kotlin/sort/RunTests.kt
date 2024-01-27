package sort

import junit.framework.Assert
import org.junit.Test

abstract class RunTests {

    abstract fun sortAlgorithm(mutableList: MutableList<Int>)

    @Test
    fun test1() {
        // Given
        val myList = mutableListOf(4, 1, 3, 2)

        // When
        sortAlgorithm(myList)

        // Then
        Assert.assertTrue(listOf(1, 2, 3, 4) == myList)
    }
}