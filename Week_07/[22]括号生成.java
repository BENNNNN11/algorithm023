//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1555 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        dfs("", res, 0, 0, n);
        return res;
    }
    private void dfs(String s, List<String> res,
                     int left, int right, int n) {
        // terminator
        if (left == n && right == n) {
            res.add(s);
        }
        if (left < n) { // 剪枝
            dfs(s + '(', res, left + 1, right, n);
        }
        if (right < left) { // 剪枝
            dfs(s + ')', res, left, right + 1, n);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
