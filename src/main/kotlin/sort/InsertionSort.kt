package sort

import swap

class InsertionSort: SortAlgorithms() {

    /**
     * Algorithm
     * - The insertion sort consider the left-side of the list as already sorted
     * then per each element, try to find its place in the sorted list and INSERT it
     * in the list
     *
     * Complexity
     * - Time: O(N^2) because there are 2 loops, where n is the number of elements in the list
     * - Space: O(1) because the operation is done in-place
     */
    override fun <T: Comparable<T>> sortAlgorithm(mutableList: MutableList<T>) {
        // i is the border of the sorted list
        // from 0 to i, all the elements should be sorted
        for (i in 1 until mutableList.size) {
            var j = i
            // Although the algorithm say the data is inserted, in reality
            // by going from the back swapping the elements is the same
            while (j >= 1 && mutableList[j] < mutableList[j - 1]) {
                mutableList.swap(j, j - 1)
                j--
            }
        }
    }
}