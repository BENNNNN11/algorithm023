//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意：字符串长度 和 k 不会超过 104。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 双指针 Sliding Window 
// 👍 229 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] map = new int[26]; // 维护一个字典，记录窗口内字符的频数
    public int characterReplacement(String s, int k) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        int left = 0, right = 0, maxCount = 0;
        while (right < chars.length) {
            int index = chars[right] - 'A';
            map[index]++;
            maxCount = Math.max(maxCount, map[index]);
            if (right - left + 1 > maxCount + k) {
                map[chars[left] - 'A']--;
                left++;
            }
            right++;
        }
        return chars.length - left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 1. 滑动窗口的问题（k=0时就相当于求最长连续子字符串问题）
//      定义窗口左边界left和窗口右边界right
//      当right < s.length()时
//          向当前窗口覆盖的子字符串后追加一个字符
//              如果满足（要求）： 窗口扩张
//              else:   窗口移动(left++)
//      要求是： 判断一个字符串改变k个字符能使其变成一个连续的
//                即判断当前子字符串的长度+k是否能大于历史最大子字符串长度