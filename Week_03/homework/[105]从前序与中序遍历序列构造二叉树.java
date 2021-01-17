//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 827 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    public TreeNode helper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start == p_end) return null; // 如果p为空， 直接返回null
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        // 在中序遍历中找到根节点的位置
        int i_root_index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (root_val == inorder[i]){
                i_root_index = i;
                break;
            }
        }
        int left_num = i_root_index - i_start;
        // 递归构造左子树
        root.left = helper(preorder, p_start+1, p_start + left_num+ 1, inorder, i_start, i_root_index);
        // 递归构造右子树
        root.right = helper(preorder, p_start + left_num + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//
//先序遍历的顺序是根节点，左子树，右子树。中序遍历的顺序是左子树，根节点，右子树。
//
//        所以我们只需要根据先序遍历得到根节点，然后在中序遍历中找到根节点的位置，它的左边就是左子树的节点，右边就是右子树的节点。
//
//        生成左子树和右子树就可以递归的进行了。
// e.g,
//        preorder = [3,9,20,15,7]
//        inorder = [9,3,15,20,7]
//        首先根据 preorder 找到根节点是 3

//        然后根据根节点将 inorder 分成左子树和右子树
//        左子树
//        inorder [9]
//        右子树
//        inorder [15,20,7]
//
//        把相应的前序遍历的数组也加进来
//        左子树
//        preorder[9]
//        inorder [9]
//        右子树
//        preorder[20 15 7]
//        inorder [15,20,7]
//
//        现在我们只需要构造左子树和右子树即可，成功把大问题化成了小问题
//        然后重复上边的步骤继续划分，直到 preorder 和 inorder 都为空，返回 null 即可