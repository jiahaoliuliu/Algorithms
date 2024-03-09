package tree

/**
 * Depth first search algorithm
 *
 * The key is using a stack
 */
class DepthFirstSearch<T>(private val root: Node<T>) {

    /**
     * Search the element by going to the deep first
     */
    fun search(value: T): Node<T>? {
        val stack = ArrayDeque<Node<T>>()
        val traversedNodes = mutableListOf<Node<T>>()

        stack.addFirst(root)

        while (stack.isNotEmpty()) {
            val node = stack.removeFirst()
            if (node.value == value) {
                return node
            }

            // The right node should be traversed first
            // then on next iteration, the left node will be on the first position
            node.rightNode?.let {
                stack.addFirst(node.leftNode!!)
            }

            node.leftNode?.let {
                stack.addFirst(node.leftNode!!)
            }

            traversedNodes.add(node)
        }

        return null
    }
}