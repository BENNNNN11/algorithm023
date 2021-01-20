//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 748 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return res;
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode node, int level){
        // start the current level
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }

        // fullfil the current level
        res.get(level).add(node.val);

        // process the child ndoes for the next level
        if (node.left != null) {
            dfs(node.left, level+1);
        }
        if (node.right != null) {
            dfs(node.right, level+1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 1. BFS
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int n = queue.size();
//            List<Integer> level = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                TreeNode node = queue.poll();
//                level.add(node.val);
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//            res.add(level);
//        }
//        return res;

// 2. DFS