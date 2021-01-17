//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1075 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(nums, res, new ArrayList<Integer>(), visited);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res,
                           ArrayList<Integer> path, int[] visited) {
        // terminator
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }
        // tranversal
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            path.add(nums[i]);
            backtrack(nums, res, path, visited);
            visited[i] = 0;
            path.remove(path.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
