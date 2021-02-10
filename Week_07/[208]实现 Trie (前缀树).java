//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 519 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Node {
    public Map<Character, Node> children;
    public boolean isEnd;
    public Node () {
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}
class Trie {
    private Node root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = this.root;
        for (char c : word.toCharArray()){
            if (!node.children.containsKey(c)){
                node.children.put(c, new Node());
            }
            node = node.children.get(c);
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = this.root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)){
                return false;
            }
            node = node.children.get(c);
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = this.root;
        for (char c : prefix.toCharArray()){
            if (!node.children.containsKey(c)){
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
