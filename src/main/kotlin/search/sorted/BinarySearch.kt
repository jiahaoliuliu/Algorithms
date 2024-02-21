package search.sorted


/**
 * Binary search is based on sorting list
 *
 * The search uses two pointers:
 * - Left: pointer to the leftest element of the partition
 * - Right: Pointer to the rightest element of the partition
 *
 * Since the list is sorted, the algo search for the element in the middle
 * - If arr[middle] == target -> Return middle
 * - else if arr[middle] > target -> The target is in the left partition. Set right pointer to middle - 1
 * - else if arr[middle] < target -> The target is in the right partition. Set left pointer to middle + 1
 *
 * Complexity:
 * - Time: O(log N). Log N because every time we are reducing the searching size by 2.
 *      - if 2^X = N, X = log N
 * - Space: O(1) since no extra data structure is used
 */
class BinarySearch<T:Comparable<T>>: SearchAlgorithmSorted<T>() {
    override fun <T: Comparable<T>> search(arr: Array<T>, target: T): Int {
        var left = 0
        var right = arr.size - 1

        while (left <= right) {
            val middle = left + (right - left) / 2
            if (arr[middle] == target) {
                return middle
            }

            if (arr[middle] > target) {
                right = middle - 1
            } else {
                left = middle + 1
            }
        }

        return -1
    }
}