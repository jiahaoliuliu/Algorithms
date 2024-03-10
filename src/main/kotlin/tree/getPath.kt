package tree

/**
 * Given a root and a tree, find the path from the root to that node
 */
class GetPath {
    fun getPath(root: TreeNode?, num: TreeNode, path: MutableList<TreeNode>): Boolean {
        if (root == null) return false
        path.add(root)
        if (root.`val` == num.`val`) {
            return true
        }

        if (getPath(root.left, num, path) || getPath(root.right, num, path)) {
            return true
        }
        path.removeLast()
        return false
    }
}

