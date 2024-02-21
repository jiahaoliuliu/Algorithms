package sort

import swap


class SelectionSort: SortAlgorithm() {
    /**
     * Algorithm
     * - Insertion sort is a two-step algorithm
     * 1. Find the smallest number in the sublist
     * 2. Replace the smallest number on the beginning of the sublist.
     * The sublist starts as the whole list and then, as elements are
     * swapped to the beginning of the sublist, the sublist shrinks
     * until there is only one element
     * Complexity:
     * - Time: O(N^2) because there are two loops in the algorithm
     * - Space: O(1) because the operation is done in-place
     */
    override fun <T: Comparable<T>> sortAlgorithm(mutableList: MutableList<T>) {
        for (index in 0 until mutableList.size - 1) {
            var minPos = index
            // Find the smallest item and its position
            for (i in index + 1 until mutableList.size) {
                 if (mutableList[i] < mutableList[minPos]) {
                     minPos = i
                 }
            }
            mutableList.swap(index, minPos)
        }
    }
}