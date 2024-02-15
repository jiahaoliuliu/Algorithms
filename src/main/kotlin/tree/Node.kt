package tree

/**
 * Inspiration: https://developerlife.com/2018/08/16/algorithms-in-kotlin-6/
 */
data class Node<T> (
    val value: T,
    var leftNode: Node<T>?,
    var rightNode: Node<T>?,
    var depth: Int = 0) {

    fun linkLeft(left: Node<T>?) = this.apply { leftNode = left }
    fun linkRight(right: Node<T>?) = this.apply { rightNode = right }
    fun link(left: Node<T>?, right: Node<T>?) = this.apply {
        linkLeft(left).linkRight(right)
    }

    fun depth(value: Int) = this.apply { depth = value }

    override fun toString(): String {
        return StringBuffer().apply {
            append("{${value.toString()}")
            if (leftNode != null) {
                append(", Left: ${leftNode.toString()}")
            }
            if (rightNode != null) {
                append(", Right: ${rightNode.toString()}")
            }
        }.toString()
    }
}