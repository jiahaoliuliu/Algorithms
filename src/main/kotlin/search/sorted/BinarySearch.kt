package search.sorted


/**
 * Binary search is based on sorting list
 *
 */
class BinarySearch<T:Comparable<T>>: SearchAlgorithmSorted<T>() {
    override fun <T: Comparable<T>> search(arr: Array<T>, target: T): Int {
        var left = 0
        var right = arr.size

        while (left < right) {
            val middle = left + (right - left) / 2
            if (arr[middle] > target) {
                right = middle
            } else {
                left = middle
            }
        }

        return left
    }
}