//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 326 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 1. clarification
    // 什么是异位词
    //  tt 是 ss 的异位词等价于「两个字符串中字符出现的种类和次数均相等
    // 词的大小写敏感吗
    //  ...

// 2. possible solutions
    // 1. 暴力：判断sorted_str 是否想等
    // O(nlogn) time
        //if (s.length() != t.length()) { return false; }
        //char[] str1 = s.toCharArray();
        //char[] str2 = t.toCharArray();
        //Arrays.sort(str1);
        //Arrays.sort(str2);
        //return Arrays.equals(str1, str2);

    // 2. 哈希， 统计每个字母的频次
    // O(n) time, n是s的长度
    // O(S) space, S为字符集的大小
//    if (s.length() != t.length()) { return false; }
//    Map<Character, Integer> table = new HashMap<>();
//    for (int i = 0; i < s.length(); i++) {
//        char ch = s.charAt(i);
//        table.put(ch, table.getOrDefault(ch, 0) + 1);
//    }
//    for (int i = 0; i < t.length(); i++) {
//        char ch = t.charAt(i);
//        table.put(ch, table.getOrDefault(ch, 0) - 1);
//        if (table.get(ch) < 0){
//            return false;
//        }
//    }
//    return true;


// 3. code
// 4. test cases