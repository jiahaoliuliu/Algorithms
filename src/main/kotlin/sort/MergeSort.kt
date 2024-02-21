package sort

class MergeSort: SortAlgorithms() {

    /**
     * Algorithm
     * - Merge sort create partitions of the list until there are lists with one single element
     * then merge them back. The sort happens on the way on merging back.
     * Every time the list is merged, it is done merging two lists at time.
     * This algorithm uses recursive
     */
    override fun <T: Comparable<T>> sortAlgorithm(mutableList: MutableList<T>) {
        // Check for corner cases
        if (mutableList.isEmpty() || mutableList.size == 1) {
            return
        }

        // Create partition
        val middle = mutableList.size / 2

        // Sublist does not include the last element
        val left = mutableList.slice(0 until middle).toMutableList()
        sortAlgorithm(left)

        // Sublist does not include the last element
        val right = mutableList.slice(middle until mutableList.size).toMutableList()
        sortAlgorithm(right)

        merge(mutableList, left, right)
    }

    /**
     * Merging the left list and the right list and put the result on the original list
     * Precondition: originalList.size = left.size + right.size
     * Algorithm:
     * - If the left list is empty -> replace all the elements on the original list by the right list
     * - If the right list is empty -> replace all the elements on the original list by the left list
     *
     * - leftIndex = 0
     * - rightIndex = 0
     * - Loop (each pos in the original list)
     * -     if the left is smaller or equal than the right
     * -        replace original[pos] by left[leftIndex]
     * -        increase left index
     * -     if the left is bigger than the right
     * -        replace original[pos] by right[rightIndex]
     * -        increase right index
     *
     * - Question: What would happen if leftIndex reaches to the end of left list or rightIndex reaches
     * to the end of right list?
     *
     * Algorithm 2.0 (This actually cover the case when any of the list comes empty)
     * - leftIndex = 0
     * - rightIndex = 0
     * - Loop (each pos in the original list)
     * -     if (leftIndex has not reached to the end and the rightIndex has not reached to the end) {
     *          if (left item is smaller or equal to the right item) {
     *              original list[index] = left [leftIndex]
     *              leftIndex++
     *          } else {
     *              original list[index] = right [rightIndex]
     *              rightIndex++
     *          }
     *       } else if (leftIndex has reached to the end) {
     *          original list [index] = right[rightIndex]
     *          rightIndex++
     *       } else if (rightIndex has reached to the end) {
     *          orignal list [index] = left[leftIndex]
     *          leftIndex++
     *       }
     *       // Both leftIndex and rightIndex has reached to the end
     *       Nothing to do here
     */
    private fun <T: Comparable<T>> merge(originalList: MutableList<T>, left: MutableList<T>, right: MutableList<T>) {
        var leftIndex = 0
        var rightIndex = 0
        for (i in 0 until originalList.size) {
            if (leftIndex <= left.size - 1 && rightIndex <= right.size - 1) {
                if (left[leftIndex] <= right[rightIndex]) {
                    originalList[i] = left[leftIndex]
                    leftIndex++
                } else {
                    originalList[i] = right[rightIndex]
                    rightIndex++
                }
            } else if (leftIndex > left.size - 1) {
                originalList[i] = right[rightIndex]
                rightIndex++
            } else if (rightIndex > right.size - 1) {
                originalList[i] = left[leftIndex]
                leftIndex++
            }
        }
    }
}