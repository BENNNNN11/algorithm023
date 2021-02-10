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

  