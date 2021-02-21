//在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。 
//
// 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成： 
//
// 
// 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角） 
// C_1 位于 (0, 0)（即，值为 grid[0][0]） 
// C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]） 
// 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0） 
// 
//
// 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：[[0,1],[1,0]]
//
//输出：2
//
// 
//
// 示例 2： 
//
// 输入：[[0,0,0],[1,1,0],[1,1,0]]
//
//输出：4
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索 
// 👍 83 👎 0


import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static int[][] directions = {{0,1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
    private int n;
    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }
        //  定义步数位置和步数
        Queue<int[]> queue = new LinkedList<>();
        grid[0][0] = 1; // 直接用grid记录最短路径长度
        queue.add(new int[]{0,0});
        while (!queue.isEmpty() && grid[n-1][n-1] == 0) {
            int[] pos = queue.poll();
            int length = grid[pos[0]][pos[1]];
            for (int i = 0; i < 8; i++) {
                int newX = pos[0] + directions[i][0];
                int newY = pos[1] + directions[i][1];
                if (inGrid(newX, newY) && grid[newX][newY] == 0) {
                    queue.add(new int[]{newX, newY});
                    grid[newX][newY] = length + 1;
                }
            }
        }
        return grid[n-1][n-1] == 0 ? -1 : grid[n-1][n-1];
    }
    private boolean inGrid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
