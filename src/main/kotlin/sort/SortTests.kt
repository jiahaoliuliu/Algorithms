package sort

import junit.framework.Assert.assertTrue
import org.junit.Test

fun runAllTests(algorithm: (MutableList<Int>) -> Unit) {
    test1(algorithm)
}

@Test
private fun test1(algorithm: (MutableList<Int>) -> Unit) {
    // Given
    val myList = mutableListOf(4, 1, 3, 2)

    // When
    algorithm(myList)

    // Then
    assertTrue(listOf(1, 2, 3, 4) == myList)
}
