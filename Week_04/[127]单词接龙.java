//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的最短转换序列中的单
//词数目。如果不存在这样的转换序列，返回 0。 
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
// 👍 682 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 1. 将wordList变成wordSet, 用来判断某个单词是否在wordList里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        // 2. 创建queue和visited
        Queue<String> queue = new LinkedList<>(); // 维护一个queue用来bfs
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>(); // 用哈希表来表示是否访问过
        visited.add(beginWord);

        // 3. 开始bfs，包含起点所以开始步数为1
        int step = 1;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                // 依次遍历当前队列中的单词
                String curWord = queue.poll();
                // 转换成字符数组然后对每个字符遍历
                char[] charArray = curWord.toCharArray();
                for (int j = 0; j < endWord.length(); j++) {
                    char originChar = charArray[j]; // 先保存，之后恢复
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == originChar) continue;
                        charArray[j] = k;
                        String nextWord = String.valueOf(charArray);
                        if (wordSet.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(nextWord)) {
                                queue.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                    charArray[j] = originChar;
                }
            }
            step++;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
