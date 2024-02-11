package sort

import swap

class QuickSort2: RunTests() {

    override fun <T : Comparable<T>> sortAlgorithm(mutableList: MutableList<T>) {
        // 1. Init the data
        if (mutableList.isEmpty() || mutableList.size == 1) {
            return
        }

        // Choose the pivot
        val pivotPosition = mutableList.size - 1
        val pivot = mutableList[pivotPosition]
        var l = 0
        var r = pivotPosition - 1

        // 2. Loop through
        while (l < r) {
            // Find the element on the left which is bigger than pivot
            while (l < r && mutableList[l]< pivot ) l++

            // Find the element on the right which is smaller than pivot
            while (l < r && mutableList[r] > pivot) r--

            // If we found an item to be switched
            if (l < r) {
                mutableList.swap(l, r)
            }
        }

        // Check if the pivot needs to be swapped
        if (mutableList[l] > pivot) {
            mutableList.swap(l, mutableList.size - 1)
        }

        // Sublist [0, l]
        sortAlgorithm(mutableList.subList(0, l + 1))
        // sublist [l + 1, n)
        sortAlgorithm(mutableList.subList(l + 1, mutableList.size))
    }
}