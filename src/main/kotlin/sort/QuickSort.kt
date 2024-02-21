package sort

import org.junit.Assert
import org.junit.Test
import swap

class QuickSort: SortAlgorithm() {

    /**
     * Algorithm:
     * 1. Take the last element as pivot (list.size - 1)
     * 2. initialize two indexes
     * 2.1 left(l) on the first element
     * 2.2 right(r) on the element immediately left of pivot
     *
     * 3. Loop (while l < r)
     * 3.1 Find the element on the left which is bigger than the pivot
     *   - while (list[l] < r) l++
     *
     * 3.2 Find the element on the right which is smaller than the pivot
     *   - while (list[r] > r) r--
     *
     * 3.3 then swap the number smaller than p with the number bigger than p
     *
     * 4. If left and right points to the same element -> Swap that element with pivot
     * 4. Recursively apply the algorithm to the left side
     * 5. Recursively apply the algorithm to the right side
     * - Not merge is needed since the updates have been done in-place
     *   - In case the partition is empty or it does have 1 element
     *      -> return the partition
     *
     * - Corner cases:
     *   1. On step 3.1 there might be all the numbers are smaller than p
     *      l == p -> Do not do anything
     *   2. On step 3.2 there might be all the numbers are bigger than p
     *      l == p -> Do not do anything
     *
     * Algorithm 2.0
     * 1. Take the last element as pivot (list.size - 1)
     * 2. initialize two indexes
     * 2.1 left(l) on the first element
     * 2.2 right(r) on the element immediately left of pivot
     *
     * 3. Loop (while l < r)
     * 3.1 Find the element on the left which is bigger than the pivot and while l smaller than p
     *   - while (list[l] < p && l < r) l++
     *
     * 3.2 Find the element on the right which is smaller than the pivot and while l smaller than p
     *   - while (list[r] > p && l < r) r--
     *
     * 3.3 Check if l == r
     *     3.3.2 If so, swap l with p
     *     3.3.3 finish loop
     * 3.4 If not, swap the number smaller than p with the number bigger than p
     *
     * 4. If left and right points to the same element -> Swap that element with pivot
     * 4. Recursively apply the algorithm to the left side
     * 5. Recursively apply the algorithm to the right side
     *
     * Complexity
     * - Time: Worse case scenario O(n^2)
     *         Best case scenario O(n log n)
     *         Average case scenario O(n log n)
     * - Space complexity:
     *         Average O(log(n)) because of calling stack
     *         Worse   O(n) because of calling stack
     */
    override fun <T: Comparable<T>> sortAlgorithm(mutableList: MutableList<T>) {
        // 0 Corner cases. if the list is empty or the list only have one element, finish
        if (mutableList.isEmpty() || mutableList.size == 1) {
            return
        }

        // 1. Take the last element as pivot (list.size - 1)
        val pivotPosition = mutableList.size - 1
        val pivot = mutableList[pivotPosition]
        // 2. initialize two indexes
        // 2.1 left(l) on the first element
        var l = 0
        // 2.2 right(r) on the element immediately left of pivot
        var r = pivotPosition - 1

        // 3. Loop (while l < r)
        while (l <= r) {
            // 3.1 Find the element on the left which is bigger than the pivot and while l smaller than p
            //   - while (list[l] < p && l < r) l++
            while (mutableList[l] < pivot && l <= r) l++
            //
            // 3.2 Find the element on the right which is smaller than the pivot and while l smaller than p
            //   - while (list[r] > p && l < r) r--
            while (mutableList[r] > pivot && l < r) r--

            // Special case: When the pivot is the biggest number
            // l will be equal r ->
            // - Do not swap
            // - Partition left = [0..p - 1]
            // - Partition right = []
            if (l == pivotPosition) {
                break
            }

            // 3.3 Check if l == r
            if (l == r) {
                //     3.3.2 If so, check if list[l] is bigger than pivot,
                //     3.3.3 if so swap l with p -> special note: The list could be already sorted. In that case,
                //     the left loop will finish because it is the same position as right, and the right loop won't
                //     start
                //     3.3.4 finish loop
                if (mutableList[l] > pivot) mutableList.swap(l, pivotPosition)
                break
            } else {
                // 3.4 If not, swap the number smaller than p with the number bigger than p
                mutableList.swap(l, r)
            }
        }
        // 4. Recursively apply the algorithm to the left side
        sortAlgorithm(mutableList.subList(0, l)) // sublist includes the left but excludes the right
        // 5. Recursively apply the algorithm to the right side
        sortAlgorithm(mutableList.subList(r + 1, mutableList.size)) // skip the pivot
    }

    @Test
    fun testBasic() {
        // Given
        val myList = mutableListOf(4, 1, 8, 2, 5, 3)

        // When
        sortAlgorithm(myList)

        // Then
        Assert.assertTrue(listOf(1, 2, 3, 4, 5, 8) == myList)
    }

    @Test
    fun testBasic2() {
        // Given
        val myList = mutableListOf(2, 1)

        // When
        sortAlgorithm(myList)

        // Then
        Assert.assertTrue(listOf(1, 2) == myList)
    }

    @Test
    fun testBasic3() {
        // Given
        val myList = mutableListOf(4, 5, 8)

        // When
        sortAlgorithm(myList)

        // Then
        Assert.assertTrue(listOf(4, 5, 8) == myList)
    }

    @Test
    fun testBasic4() {
        // Given
        // Special corner case when the biggest element is at the end
        val myList = mutableListOf(0, 1, 3, 2, 4)

        // When
        sortAlgorithm(myList)

        // Then
        Assert.assertTrue(listOf(0, 1, 2, 3, 4) == myList)
    }


    private var list = List(22) { it }
    private var listShuffled = mutableListOf(21, 20, 11, 13, 15, 16, 12, 4, 17, 2, 3, 9, 10, 8, 18, 6, 7, 1, 0, 14, 19, 5)

    @Test
    fun testBasic5() {
        // When
        sortAlgorithm(listShuffled)

        // Then
        Assert.assertTrue(listShuffled == list)
    }
}