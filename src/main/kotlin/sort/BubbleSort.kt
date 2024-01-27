package sort

/**
 * Bubble sort gets one element per time, going through the list and swap its position with others when
 * needed.
 *
 */
class BubbleSort: RunTests() {
    /**
     * Algorithm:
     * This algorithm do the following
     * 1. It goes from the position to the last position -1
     * 2. For each one of the positions, it tries to move the smallest number and put that
     *    number on the position of step 1
     *    Since the swap happens from current position to the position right proceed it,
     *    it goes from the last position until the 1 right before the first position to be replaced
     */
    override fun sortAlgorithm(mutableList: MutableList<Int>) {
        for (i in 0 until mutableList.size - 1) {
            for (j in mutableList.size - 1 downTo i + 1) {
                if (mutableList[j] < mutableList[j - 1]) {
                    swap(mutableList, j, j-1)
                }
            }
        }
    }

    private fun swap(list: MutableList<Int>, i: Int, j: Int) {
        val tmp = list[i]
        list[i] = list[j]
        list[j] = tmp
    }
}