//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 558 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        helper1(nums, res, new ArrayList<Integer>(), visited);
        return res;
    }
    public void helper1(int[] nums, List<List<Integer>> res,
                        ArrayList<Integer> temp, int[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || (i > 0 && nums[i] == nums[i-1] && visited[i-1] == 0)){
                continue; // 保证在填第i个数的时候重复数字只会被填入一次即可
            }
            temp.add(nums[i]);
            visited[i] = 1;
            helper1(nums, res, temp, visited);
            visited[i] = 0;
            temp.remove(temp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
