package graph

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

interface Node

data class Edge(val node1: Node, val node2: Node, val distance: Int)

/**
 * Source: https://gist.github.com/trygvea/6067a744ee67c2f0447c3c7f5b715d62
 * Video: https://www.youtube.com/watch?v=EFg3u_E6eHU
 */
class Dijkstra {

    /**
     * See https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
     */
    fun findShortestPath(edges: List<Edge>, source: Node, target: Node): ShortestPathResult {
        // Note: this implementation uses similar variable names as the algorithm given do.
        // We found it more important to align with the algorithm than to use possibly more sensible naming.
        val dist = mutableMapOf<Node, Int>()
        val prev = mutableMapOf<Node, Node?>()
        // Find all the nodes that are different
        val q = findDistinctNodes(edges)

        // Init the distance
        q.forEach { v ->
            dist[v] = Integer.MAX_VALUE
            prev[v] = null
        }
        dist[source] = 0

        // Going through each node
        while (q.isNotEmpty()) {
            // Find the shortest distance
            val u = q.minByOrNull { dist[it] ?: 0 }
            q.remove(u)

            // If the target is found, finish the algorithm
            if (u == target) {
                break // Found shortest path to target
            }
            // For each one of the edges
            edges
                .filter { it.node1 == u } // Find the one which has u as origin
                .forEach { edge ->
                    // Calculate the distance between the u and the distance to next node
                    val v = edge.node2
                    val alt = (dist[u] ?: 0) + edge.distance
                    // if the new distance is shorter than the existing distance
                    if (alt < (dist[v] ?: 0)) {
                        dist[v] = alt // Update the distance
                        prev[v] = u   // Update the node previous to the u node
                    }
                }
        }

        return ShortestPathResult(prev, dist, source, target)
    }

    private fun findDistinctNodes(edges: List<Edge>): MutableSet<Node> {
        val nodes = mutableSetOf<Node>()
        edges.forEach {
            nodes.add(it.node1)
            nodes.add(it.node2)
        }
        return nodes
    }
}
/**
 * Traverse result
 */
class ShortestPathResult(val prev: Map<Node, Node?>,
                         val dist: Map<Node, Int>,
                         private val source: Node,
                         private val target: Node) {

    fun shortestPath(from: Node = source, to: Node = target, list: List<Node> = emptyList()): List<Node> {
        val last = prev[to] ?: return if (from == to) {
            list + to
        } else {
            emptyList()
        }
        return shortestPath(from, last, list) + to
    }

    fun shortestDistance(): Int? {
        val shortest = dist[target]
        if (shortest == Integer.MAX_VALUE) {
            return null
        }
        return shortest
    }
}

// Tests
data class StringNode(val s: String) : Node

class GenericShortestPathTest {

    @Test
    fun `should find shortest path`() {
        val graph = listOf(
            Edge(StringNode("a"), StringNode("b"), 4),
            Edge(StringNode("a"), StringNode("c"), 2),
            Edge(StringNode("b"), StringNode("c"), 3),
            Edge(StringNode("c"), StringNode("b"), 1),
            Edge(StringNode("c"), StringNode("d"), 5),
            Edge(StringNode("b"), StringNode("d"), 1),
            Edge(StringNode("a"), StringNode("e"), 1),
            Edge(StringNode("e"), StringNode("d"), 4)
        )
        val result = Dijkstra().findShortestPath(graph, StringNode("a"), StringNode("d"))
    println("prev: ${result.prev}")
    println("dist: ${result.dist}")
        assertEquals(listOf(StringNode("a"), StringNode("c"), StringNode("b"), StringNode("d")), result.shortestPath())
        assertEquals(4, result.shortestDistance())
    }

    @Test
    fun `should behave when shortest path is not reachable`() {
        val graph = listOf(
            Edge(StringNode("a"), StringNode("b"), 4),
            Edge(StringNode("a"), StringNode("c"), 2),
            Edge(StringNode("b"), StringNode("c"), 3),
            Edge(StringNode("c"), StringNode("b"), 1),
            Edge(StringNode("c"), StringNode("d"), 5),
            Edge(StringNode("b"), StringNode("d"), 1),
//        Edge(StringNode("a"), StringNode("e"), 1),
            Edge(StringNode("e"), StringNode("d"), 4)
        )
        val result = Dijkstra().findShortestPath(graph, StringNode("a"), StringNode("e"))
        assertEquals(emptyList<Node>(), result.shortestPath())
        assertNull(result.shortestDistance())
    }

    @Test
    fun `should behave when to-node doesnt event exist`() {
        val graph = listOf(
            Edge(StringNode("a"), StringNode("b"), 4),
            Edge(StringNode("a"), StringNode("c"), 2),
            Edge(StringNode("b"), StringNode("c"), 3),
            Edge(StringNode("c"), StringNode("b"), 1),
            Edge(StringNode("c"), StringNode("d"), 5),
            Edge(StringNode("b"), StringNode("d"), 1),
            Edge(StringNode("a"), StringNode("e"), 1),
            Edge(StringNode("e"), StringNode("d"), 4)
        )
        val result = Dijkstra().findShortestPath(graph, StringNode("a"), StringNode("f"))
        assertEquals(emptyList<Node>(), result.shortestPath())
        assertNull(result.shortestDistance())
    }

    @Test
    fun `should behave when the world is empty`() {
        val graph = emptyList<Edge>()
        val result = Dijkstra().findShortestPath(graph, StringNode("a"), StringNode("f"))
        assertEquals(emptyList<Node>(), result.shortestPath())
        assertNull(result.shortestDistance())
    }
}