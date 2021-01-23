//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换后得到的单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回一个空列表。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 数组 字符串 回溯算法 
// 👍 389 👎 0


import java.nio.file.Path;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return res;
        }
        bfs(beginWord, endWord, wordList, res);
        return res;
    }
    public void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> res) {
        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.offer(path);
        boolean isFound = false;
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            HashSet<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> p = queue.poll();
                String temp = p.get(p.size()-1);  // 得到当前路径的最后一个单词
                // 然后得到这个单词的子节点
                ArrayList<String> neighbors = getNeighbors(temp, dict);
                for (String neighbor : neighbors) {
                    // 只考虑之前没有出现过的单
                    if (!visited.contains(neighbor)) {
                        if (neighbor.equals(endWord)) {
                            // 到达结束词，将路径添加到结果列表中
                            isFound = true;
                            p.add(neighbor);
                            res.add(new ArrayList<String>(p));
                            p.remove(p.size()-1);
                        } // 否则如果没到达结束词，加入该单词到路径中, queue中开辟branch
                        p.add(neighbor);
                        queue.offer(new ArrayList<String>(p));
                        p.remove(p.size()-1);
                        subVisited.add(neighbor);
                    }
                }
            }
            if (isFound) break;
            visited.addAll(subVisited);
        }


    }
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char[] chs = node.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char originChar = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = originChar;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
