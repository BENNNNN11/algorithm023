#  Week07 学习笔记

## **字典树（ Trie 树）**的数据结构：

1. 字典树的核心思想：空间换时间
2. 字典树的基本性质：
   1. 节点本身不存完整单词
   2. 每个节点的所有子节点路径代表的字符都不同

## **并查集(disjoint set)**:

- 组团，配对，判断是否在一个群组中

- 基本操作： 

  - makeSet():
  - unionSet():
  - find(x):

- 代码模版：

  - Java

  ```java
  class UnionFind{
    private int count = 0;
    private int[] parent;
    public UnionFind(int n) {
      count = n;
      parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }
    public int find(int p){
      while (p != parent[p]){
        parent[p] = parent[parent[p]];
  			p = parent[p];
      }
  		return p;
    }
    public void union(int p, int q) {
     	int roorP = find(p);
      int roorQ = find(q);
      if (rootP == rootQ) return;
      parent[rootP] = rootQ;
      count--;
    }
  }
  ```

  - python 

  ```python
  def init(p):
    p = [i for i in range(n)] 
    
  def union(self, p, i, j):
    p1 = self.parent[p, i]
    p2 = self.parent[p, j]
    p[p1] = p2
  
  def parent(self, p, i):
  	while p[root] != root:
  		root = p[root]	
    while p[i] != i:	# 路径压缩
      x = i; i = p[i]; p[x] = root
     return root 
  ```

  

# 高级搜索

- 朴素搜索：

  - 优化方法： 避免重复，剪枝

  - DFS模版：

    ```python
    # recursion 
    visited = set()
    def dfs(node, visited):
      # terminator 
    	if node in visited:
    		return 
      visited.add(node)
      
      # process current node here 
      
      for next_node in node.children():
        if not next_node in visited:
          dfs(next_node, visited)
    ```

    ```python
    # stack version
    def dfs(self, tree):
      if tree.node is None:
        return []
      visited, stack = [tree.root]
      while stack:
    		node = stack.pop()
        visited.add(node)
      	process(node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)
    ```

    

  - BFS模版：

    ```python
    def bfs(graph, start, end):
      queue = []
      queue.append([start])
      visited.add(start) 
      while queue:
        node = queue.pop(0)
        visited.add(node)
        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)
    ```

- 剪枝：

  - 已经计算过的
  - 次优解
  - [AlphaZero Explained](https://nikcheerla.github.io/deeplearningschool/2018/01/01/AlphaZero-Explained/)
  - [棋类复杂度](https://en.wikipedia.org/wiki/Game_complexity)

- 回溯：

  - 采用试错的思想
  - 本质是递归和分治

- 双向bfs：

  ```java
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
  ```

  

- 启发式搜索A*：优先队列

  - A* search 

    ```python
    def AstarSearch(graph, start, end):
    	pq = collections.prioity_queue() 
      pq.append([start])
    	visited.append(start)
      while pq: 
        node = pq.pop()
        visited.apppend(node) 
       	
        process(node) 
        nodes = generate_related_nodes(node)
        unvisited = [node for node in nodes if node not in visited] 
        pq.push([unvisited])
    ```

  - 启发式函数： heuristics

- [8 puzzles](https://zxi.mytechroad.com/blog/searching/8-puzzles-bidirectional-astar-vs-bidirectional-bfs/)

# AVL树和红黑树

1. 二叉搜索树
2. 平衡二叉树
   - AVL 
   - 红黑树
   - spray伸展树
   - 23树
   - b树
   - treap树
3. 如何保证一棵树的平衡： [维基百科：平衡树](https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree)

4. AVL树

   - 平衡因子： 左子树的高度减去右子树的高度，或相反
     - Balance factor = {-1, 0, 1}
   - 通过旋转
     - **左旋**
       - **右右子树： 左旋**
     - **右旋：**
       - **左左子树： 右旋**
     - **左右旋：** 
       - **左右子树：左右旋**
     - **右左旋 ：**
       - **右左子树： 右左旋**
   - 带有子树的旋转

   - 不足： 节点需要存储额外信息， 维护成本较高

5. 红黑树： 

   - **近似平衡二叉树**： 确保任何一个节点的左右子树的**高度差小于两倍**
   - 优点：旋转的频次降低
   - 特性
     - 每个节点要么是红色，要么是黑色
     - 根节点是黑色
     - 每个叶节点（NIL节点， 空节点）是黑色的
     - 不能有相邻接的两个红色节点
     - 从任一节点到其每个叶子节点的所有路径包含相同数目的黑色节点
   - **关键性质： 从根节点的最长可能路径不多于最短的可能路径的两倍长**

6. **AVL和红黑树对比：**

   - **读和查找： AVL更好，因为AVL是严格的平衡**
   - **插入和删除：红黑树更好，因为AVL的旋转操作会更多**
   - **存储空间：**
     - **AVL树的每个节点都存balance factor 和 height**
     - **红黑树的每个节点只需要存1 bit来表示黑或红**
   - **使用场景：** 
     - **读操作很多，插入操作很少， 用AVL**
     - **插入操作很多，或者读写一半一半， 用红黑树**
     - **红黑树常用于高级语言的库， 例如Java的map， set**
     - **database常用AVL**















