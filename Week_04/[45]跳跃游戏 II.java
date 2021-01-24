//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 806 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int step = 0, end = 0, maxPostion = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPostion = Math.max(maxPostion, i + nums[i]);
            if (end == i) {
                end = maxPostion;
                step++;
            }
        }
        return step;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


// 1. 贪心: 正向查找可到达的最大位置
// 维护当前能够到达的最大下标位置，记为边界。
// 从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1。