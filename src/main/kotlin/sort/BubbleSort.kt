package sort

/**
 * Bubble sort gets one element per time, going through the list and swap its position with others when
 * needed.
 *
 */
class BubbleSort: RunTests() {
    override fun sortAlgorithm(mutableList: MutableList<Int>) {
        for (i in 0 until mutableList.size - 1) {
            for (j in mutableList.size - 1 downTo i + 1) {
                if (mutableList[j] < mutableList[j - 1]) {
                    swap(mutableList, j, j-1)
                }
            }
            println()
        }
    }

    private fun swap(list: MutableList<Int>, i: Int, j: Int) {
        val tmp = list[i]
        list[i] = list[j]
        list[j] = tmp
    }
}