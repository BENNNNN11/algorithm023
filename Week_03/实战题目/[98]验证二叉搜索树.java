//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 890 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


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
    private Integer prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }
    public boolean inorder(TreeNode root) {
        if (root == null) return true;
//        boolean l = inorder(root.left);
//        if (root.val <= prev) return false;
//        prev = root.val;
//        boolean r = inorder(root.right);
//        return l && r;
        if (!inorder(root.left)) return false;
        if (prev != null && root.val <= prev) return false;

        prev = root.val;
        return inorder(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


// 1. 中序遍历
// O(N) time: in the worst case when the tree is a BST or
// the "bad" elemnet is a leftmost leaf

// O(N) space: for the space on the run-time stack
