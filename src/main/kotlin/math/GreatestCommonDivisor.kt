package math

import org.junit.Assert.assertEquals
import org.junit.Test

class GreatestCommonDivisor {
    private fun greatestCommonDivisor(x: Int, y:Int): Int {
        return if (y == 0) {
            x
        } else {
            greatestCommonDivisor(y, x % y)
        }
    }

    @Test
    fun test1() {
        // Given
        val num1 = 42
        val num2 = 12

        // When
        val result = greatestCommonDivisor(num1, num2)

        // Then
        assertEquals(6, result)
    }

    @Test
    fun test2() {
        // Given
        val num1 = 42
        val num2 = 5

        // When
        val result = greatestCommonDivisor(num1, num2)

        // Then
        assertEquals(1, result)
    }
}