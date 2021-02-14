//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 
// 👍 694 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 用set 优化查询时间O(1)
        Set<String> wordSet = new HashSet<String>(wordList);
        // 边界条件：wordSet长度为0， 或者endWord不在wordSet中
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        // 用beginset记录从beginword扩散出去的单词
        Set<String> beginSet = new HashSet<String>();
        beginSet.add(beginWord);
        // 用endset记录从endword扩散出去的单词
        Set<String> endSet = new HashSet<String>();
        endSet.add(endWord);

        // 用visited 记录走过的单词， 因为访问过的不能重复访问
        HashSet<String> visited = new HashSet<String>();


        // BFS starts here
        int len = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            // 由于扩散的时候每次只散一个set，所以优先选择小的set
            // 如果beginSet比endSet大的话，互换一下
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            // 扩散beginSet
            Set<String> path = new HashSet<String>();
            for (String word: beginSet) {
                char[] charArray = word.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    // 遍历set中的单词， 变换字符位
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = charArray[i];
                        charArray[i] = c;
                        String target = String.valueOf(charArray);
                        if (endSet.contains(target)) {
                            return len + 1;
                        }
                        // 如果此单词没走过，并且是wordlist中的单词，就添加到路径和visit中
                        if (!visited.contains(target) && wordSet.contains(target)) {
                            path.add(target);
                            visited.add(target);
                        }
                        // 恢复更改
                        charArray[i] = old;
                    }
                }
            }
            beginSet = path;
            len++;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 1. Two-ended BFS