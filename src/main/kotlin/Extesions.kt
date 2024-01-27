
/**
 * Swapping two elements in the mutable list in-place
 */
fun<T> MutableList<T>.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}
