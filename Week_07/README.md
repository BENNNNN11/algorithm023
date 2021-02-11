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

- 启发式搜索A*：优先队列

