//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 624 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str: strs) {
            // turn each string in the array into the char array then sort
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            // turn each element into string after sorting, then store it as the key
            String key = new String(charArray);

            // create the list for this key, then add this element.
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)


// 1. 排序 O(nklogk) time | O(nk) space
//  n是字符串的数量， k是最大字符串的长度， O（klogk）是排序的复杂度
// set up a hash table with string key and list of string values



// 2. 哈希表计数
// creation of the hash table
//    Map<String, List<String>> map = new HashMap<String, List<String>>();
//    for (String str : strs) {
//        int[] counts = new int[26];
//        for (int i = 0; i < str.length(); i++) {
//            counts[str.charAt(i) - 'a']++;
//        }
//    // concatenate each character with count > 0
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < 26; i++) {
//            if (counts[i] != 0) {
//                sb.append((char) ('a' + i));
//                sb.append(counts[i]);
//            }
//        }
//        String key = sb.toString();
//        List<String> list = map.getOrDefault(key, new ArrayList<String>());
//        list.add(str);
//        map.put(key, list);
//    }
//    return new ArrayList<List<String>>(map.values());
