//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 119 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    public void dfs(TreeNode node, List<Integer> res, int level) {
        // terminator
        if (node == null) return;
        // 添加值的过程
        if (res.size() == level) {
            res.add(node.val);
        } else {
            // 处理每层的最大值
            res.set(level, Math.max(res.get(level), node.val));
        }
        // drill down
        dfs(node.left, res, level+1);
        dfs(node.right, res, level+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 1. BFS
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int n = queue.size();
//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < n; i++) {
//                TreeNode node = queue.poll();
//                max = Math.max(node.val, max);
//                // 添加子节点进queue
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//            res.add(max);
//        }
//        return res;


// 2. DFS:
