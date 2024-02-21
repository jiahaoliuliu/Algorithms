package search

/**
 * Simple linear search
 *
 */
class LinearSearch<T>: SearchAlgorithms<T>() {

    /**
     * Simple linear search
     *
     * Complexity:
     * - Time: O(n)
     * - Space: O(1)
     */
    override fun<T> search(arr: Array<T>, target: T): Int {
        arr.forEachIndexed { index, i ->
            if (i == target) return index
        }

        return -1
    }
}