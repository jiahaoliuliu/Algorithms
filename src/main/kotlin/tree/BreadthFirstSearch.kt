package tree

import kotlin.collections.ArrayDeque

/**
 * Normal breadth first search. Per each one of the nodes, add its
 * child node in the end of the queue
 */
class BreadthFirstSearch<T>(private val root: Node<T>) {

    /**
     * Find the node with specific value
     * If the value does not exist, return null
     */
    fun search(value: T): Node<T>? {
        val queue = ArrayDeque<Node<T>>()
        val traversalList = mutableListOf<Node<T>>()

        queue.addLast(root)

        while(queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (node.value == value) {
                return node
            }

            if (node.leftNode != null) {
                queue.addLast(node.leftNode!!)
            }

            if (node.rightNode != null) {
                queue.addLast(node.rightNode!!)
            }

            traversalList.add(node)
        }

        return null
    }
}