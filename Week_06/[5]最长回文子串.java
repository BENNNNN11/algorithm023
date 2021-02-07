//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3186 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int begin = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 1. dp
//      重复性：一个回文去掉两头以后，剩下的部分依然是回文
//      a. 状态数组：dp[i][j]表示子串s[i..j]是否为回文子串
//                这里子串 s[i..j] 定义为左闭右闭区间，可以取到 s[i] 和 s[j]。
//      b. 转移方程：
//                dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]



// 2. 暴力解法: O(N^3) time | O(1) space, where N is the length of string
