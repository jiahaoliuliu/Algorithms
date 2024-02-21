package sort

import org.junit.Assert.assertTrue
import org.junit.Test

abstract class SortAlgorithm {

    abstract fun <T: Comparable<T>> sortAlgorithm(mutableList: MutableList<T>)

    // Basic cases
    @Test
    fun testBasic_1() {
        // Given
        val myList = mutableListOf(4, 1, 3, 2)

        // When
        sortAlgorithm(myList)

        // Then
        assertTrue(listOf(1, 2, 3, 4) == myList)
    }

    @Test
    fun testBasic_2() {
        // Given
        val myList = mutableListOf(4, 1, 3, 2, 6, 0)

        // When
        sortAlgorithm(myList)

        // Then
        assertTrue(listOf(0, 1, 2, 3, 4, 6) == myList)
    }

    private var list = List(10) { it * 4 }
    private var listShuffled = list.shuffled().toMutableList()

    @Test
    fun testBasic_3() {
        // When
        sortAlgorithm(listShuffled)

        // Then
        assertTrue(listShuffled == list)
    }

    // Special cases
    private var longList = List(100) { it * 4 }
    private var longListShuffled = longList.shuffled().toMutableList()

    @Test
    fun testSpecial_LongList() {
        // When
        sortAlgorithm(longListShuffled)

        // Then
        assertTrue(longListShuffled == longList)
    }

    private var veryLongList = List(1000) { it * 4 }
    private var veryLongListShuffled = veryLongList.shuffled().toMutableList()

    @Test
    fun testSpecial_VeryLongList() {
        // When
        sortAlgorithm(veryLongListShuffled)

        // Then
        assertTrue(veryLongListShuffled == veryLongList)
    }

    private var veryVeryLongList = List(10_000) { it * 4 }
    private var veryVeryLongListShuffled = veryVeryLongList.shuffled().toMutableList()

    @Test
    fun testSpecial_VeryVeryLongList() {
        // When
        sortAlgorithm(veryVeryLongListShuffled)

        // Then
        assertTrue(veryVeryLongListShuffled == veryVeryLongList)
    }

    // Corner cases
    @Test
    fun testCornerCase_SortedList() {
        // Given
        val myList = mutableListOf(1, 2, 3, 4)

        // When
        sortAlgorithm(myList)

        // Then
        assertTrue(listOf(1, 2, 3, 4) == myList)
    }

    @Test
    fun testCornerCase_EmptyList() {
        // Given
        val myList = mutableListOf<Int>()

        // When
        sortAlgorithm(myList)

        // Then
        assertTrue(listOf<Int>() == myList)
    }

    @Test
    fun testCornerCase_ListWith1Element() {
        // Given
        val myList = mutableListOf(1)

        // When
        sortAlgorithm(myList)

        // Then
        assertTrue(listOf(1) == myList)
    }

    @Test
    fun testCornerCase_ListWith2ElementSorted() {
        // Given
        val myList = mutableListOf(1, 3)

        // When
        sortAlgorithm(myList)

        // Then
        assertTrue(listOf(1,3) == myList)
    }

    @Test
    fun testCornerCase_ListWith2ElementNonSorted() {
        // Given
        val myList = mutableListOf(3, 1)

        // When
        sortAlgorithm(myList)

        // Then
        assertTrue(listOf(1,3) == myList)
    }
}