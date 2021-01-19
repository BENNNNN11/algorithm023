//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
// Related Topics 堆 队列 数学 
// 👍 41 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        int p3 = 0, p5 = 0, p7 = 0;
        int[] nums = new int[k];
        nums[0] = 1;
        for (int i = 1; i < k; i++) {
            nums[i] = Math.min(nums[p3] * 3, Math.min(nums[p5] * 5, nums[p7] * 7));
            if (nums[i] == nums[p3] * 3) p3++;
            if (nums[i] == nums[p5] * 5) p5++;
            if (nums[i] == nums[p7] * 7) p7++;
        }
        return nums[k-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//
//1.动态规划
//    1没有质因子，1与任何正整数（包括1本身）都是互质
//    设置1为第一位，dp[0] = 1;
//    初始化三个指针 p3，p5，p7
//    在dp[p3]*3,dp[p5]*5,dp[p7]*7中选取最小数字作为新的数字，并将该数字对应的指针向前移动一步。


//    dp[0] = 1;
//    p3 = 0, p5 = 0, p7 = 0;
//
//    dp[1] = ( dp[p3]*3, dp[p5]*5, dp[p7]*7 ) = ( 3, 5, 7 ) - 3;
//    p3 = 1, p5 = 0, p7 = 0;
//
//    dp[2] = ( dp[p3]*3, dp[p5]*5, dp[p7]*7 ) = ( 9, 5, 7 ) - 5;
//    p3 = 1, p5 = 1, p7 = 0;
//
//    dp[3] = ( dp[p3]*3, dp[p5]*5, dp[p7]*7 ) = ( 9, 15, 7 ) - 7;
//    p3 = 1, p5 = 1, p7 = 1;
//
//    dp[4] = ( dp[p3]*3, dp[p5]*5, dp[p7]*7 ) = ( 9, 15, 21 ) - 9;
//    p3 = 2, p5 = 1, p7 = 1;
//
//    dp[5] = ( dp[p3]*3, dp[p5]*5, dp[p7]*7 ) = ( 15, 15, 21 ) - 15;
//    p3 = 3, p5 = 2, p7 = 1;
//
//    dp[6] = ( dp[p3]*3, dp[p5]*5, dp[p7]*7 ) = ( 21, 25, 21 ) - 21;
//    p3 = 4, p5 = 2, p7 = 2;
//
//    dp[7] = ( dp[p3]*3, dp[p5]*5, dp[p7]*7 ) = ( 27, 25, 35 ) - 25;
//    p3 = 4, p5 = 3, p7 = 2;
//
//    dp[8] = ( dp[p3]*3, dp[p5]*5, dp[p7]*7 ) = ( 27, 35, 35 ) - 27;
//    p3 = 5, p5 = 3, p7 = 2;
//    .....
