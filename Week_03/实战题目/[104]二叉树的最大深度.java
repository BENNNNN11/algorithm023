//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 771 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//        if (root == null) return 0;
//        int res = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            res++;
//            int n = queue.size();
//            for (int i = 0; i < n; i++) {
//                TreeNode node = queue.poll();
//                if (node.left != null) queue.add(node.left);
//                if (node.right != null) queue.add(node.right);
//            }
//        }
//        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 1. DFS:
// O(N) time: 需要遍历所有树的节点
// O(N) space: 最差情况下，当树退化为链表时，递归深度可达到 N
//        if (root == null) return 0;
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
// 2. BFS: 用队列
// O()
