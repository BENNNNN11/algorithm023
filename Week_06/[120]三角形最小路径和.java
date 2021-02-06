//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 
// 👍 685 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int row;
    Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        row = triangle.size();
        memo = new Integer[row][row];
        return helper(triangle, 0, 0);
    }
    private int helper(List<List<Integer>> triangle, int level, int col) {
        if (memo[level][col] != null) {
            return memo[level][col];
        }
        if (level == row-1) {
            return triangle.get(level).get(col);
        }
        int left = helper(triangle, level+1, col);
        int right = helper(triangle, level+1, col+1);
        return memo[level][col] = Math.min(left, right) + triangle.get(level).get(col);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 1. dp
//    a. 重复性:
//      problem(i,j) = min(sub(i+1,j), sub(i+1,j+1)) + a[i,j]
//    b. 状态数组: f[i,j]
//    c. dp方程:
//      f[i,j] = min(f[i+1,j], f[i+1,j+1]) + a[i,j]

// 2. 递归+记忆化搜索