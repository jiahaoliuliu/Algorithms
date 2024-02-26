package math

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Binary converter
 *
 * Given a String and a base, convert the string to the number in that case
 * Note the most significant number is on the left
 *
 * Example:
 * - "101", base 2 = 5
 * - "0", base 2 = 0
 * - "100", base 10 = 400
 * - "101", base 8 = 1 * 8 ^ 2 + 0 * 8 ^ 1 + 1 * 8 ^ 0 = 64 + 0 + 1 = 65
 * - "723", base 8 = 7 * 8 ^ 2 + 2 * 8 ^ 1 + 3 * 8 ^ 0 = 448 + 16 + 3 = 467
 *
 * For base bigger than 10, the String will be represented with English upper characters, where
 * "A" = 10, "B" = 11, and so on
 * Example:
 * - "ABC", base 16 = 2748
 */
abstract class BaseConverter {

    abstract fun convertBaseToInteger(num: String, base: Int): Int

    @Test
    fun test1() {
        // Given
        val string = "101"

        // When
        val result = convertBaseToInteger(string, 2)

        // Then
        assertEquals(5, result)
    }

    @Test
    fun test2() {
        // Given
        val string = "0"

        // When
        val result = convertBaseToInteger(string, 2)

        // Then
        assertEquals(0, result)
    }

    @Test
    fun test3() {
        // Given
        val string = "100"

        // When
        val result = convertBaseToInteger(string, 10)

        // Then
        assertEquals(100, result)
    }

    @Test
    fun test4() {
        // Given
        val string = "101"

        // When
        val result = convertBaseToInteger(string, 8)

        // Then
        assertEquals(65, result)
    }

    @Test
    fun test5() {
        // Given
        val string = "723"

        // When
        val result = convertBaseToInteger(string, 8)

        // Then
        assertEquals(467, result)
    }

    @Test
    fun test6() {
        // Given
        val string = "ABC"

        // When
        val result = convertBaseToInteger(string, 16)

        // Then
        assertEquals(2748, result)
    }

}

class BinaryConverterImpl: BaseConverter() {

    /**
     * The key to convert a number of any base to Integer is
     *
     * Result = 0
     * Result(n) = result(n - 1) * base + num[n]
     */
    override fun convertBaseToInteger(num: String, base: Int): Int {
        // 1. Init
        var result = 0

        // 2. Loop
        for (c in num) {
            val digit = if (c.isDigit()) c.digitToInt() else c - 'A' + 10
            result = result * base + digit
        }


        // 3. Show result
        return result
    }


}