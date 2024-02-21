package search

/**
 * Simple linear search
 *
 */
class LinearSearch: SearchAlgorithms() {

    /**
     * Simple linear search
     *
     * Complexity:
     * - Time: O(n)
     * - Space: O(1)
     */
    override fun search(arr: IntArray, target: Int): Int {
        arr.forEachIndexed { index, i ->
            if (i == target) return index
        }

        return -1
    }
}