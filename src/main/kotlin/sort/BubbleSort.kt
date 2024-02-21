package sort

import swap

/**
 * Bubble sort gets one element per time, going through the list and swap its position with others when
 * needed.
 *
 */
class BubbleSort: SortAlgorithm() {
    /**
     * Algorithm:
     * This algorithm do the following
     * 1. It goes from the position to the last position -1
     * 2. For each one of the positions, it tries to move the smallest number and put that
     *    number on the position of step 1
     *    Since the swap happens from current position to the position right proceed it,
     *    it goes from the last position until the 1 right before the first position to be replaced
     * Complexity:
     * - Time
     * -    Worse case: O(n^2), where n is the number of elements to be sorted
     * - Space
     * -    O(1) since the operation swap is in-place
     *
     */
    override fun <T: Comparable<T>> sortAlgorithm(mutableList: MutableList<T>) {
        for (i in 0 until mutableList.size - 1) {
            for (j in mutableList.size - 1 downTo i + 1) {
                if (mutableList[j] < mutableList[j - 1]) {
                    mutableList.swap(j, j-1)
                }
            }
        }
    }
}