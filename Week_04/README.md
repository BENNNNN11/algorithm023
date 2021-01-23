# DFS、BFS的实现和特性

## DFS 代码模版

### 递归写法

- python	

```python
# bianry tree 
visited = set()
def dfs(node):
  # terminator 
  if node in visited:
    return 
  # process current level 
  visited.add(node) 
  # drill down 
  dfs_binary(node.left)
  dfs_binary(node.right) 
```

```python
# multi-tree 
visited = set()
def dfs(node, visited):
  if node in visited: 
    return
  visited.add(node)
  for child in node.children():
    if not children in visited:
      dfs(child, visited)
```

- java

```java
public List<List<Integer>> levelOrder(TreeNode root) {
  List<List<Integer>> result = new ArrayList<>();
  if (root == null) {
    return result;
  }
  traversal(root, 0, result);
  return result;
}
private void traversal(TreeNode root, int level, List<List<Integer>> result) {
  if (result.size() == level) {
    result.add(new ArrayList<>());
  }
  result.get(level).add(root.val);
  if (root.left != null) {
    traversal(root.left, level+1, result);
  }
  if (root.right != null) {
    traversal(root.right, level+1, result);
  }
}
```

### 非递归写法

```python
def DFS(self, tree):
	if tree.root is None:
  	return []
  visited, stack = [], [tree.node]
  while stack:
    node = stack.pop()
    visited.add(node)
    process(node)
    nodes = generate_related_nodes(node)
    stack.push(nodes)
 	# ... 
```

## BFS 代码模版

```python
# python 
def BFS():
  visited = set()
  queue = []
  queue.append([start])
  while queue: 
    node = queue.popleft()
    visited.add(node)
    process(node)
    nodes = generate_realted_nodes(node)
    queue.push(nodes)
```

```java
// java 
public class TreeNode {
  int val; 
  TreeNode left;
  TreeNode right;
  TreeNode(int x){
    val = x;
  }
}

public List<List<Integer>> levelOrder(TreeNode root){
  List<List<Integer>> allResults = new ArrayList<>();
  if (root == null) {
    return;
  }
  Queue<TreeNode> queue = new LinkedList<>();
  queue.add(root);
  while(!queue.isEmpty()){
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < queue.size(); i++) {
      TreeNode node = queue.poll();
      res.add(node);
      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }
    }
    allResults.add(res);
  }
  return allResults;
}
```

# 贪心算法

- 每一子问题都采取局部最优的选择，不能回退。

  - 求最小生成树，霍夫曼树...

- **动态规划**会保存之前的运算结果，并且根据以前的结果对当前进行选择，有回退功能

- 子问题的最优解能递推到最终问题的最优解

- 算法思想： 

  - 贪心算法
  - 分治算法
  - 动态规划
  - 回溯算法

# 动态规划

- 把原问题分解为相对简单的子问题的方式求解复杂问题的方法

- 常常适用于有重叠子问题[[1\]](https://zh.wikipedia.org/wiki/动态规划#cite_note-1)和[最优子结构](https://zh.wikipedia.org/w/index.php?title=最优子结构&action=edit&redlink=1)性质的问题

- 动态规划背后的基本思想非常简单。大致上，若要解一个给定问题，我们需要解其不同部分（即子问题），再根据子问题的解以得出原问题的解。

- 一旦某个给定子问题的解已经算出，则将其[记忆化](https://zh.wikipedia.org/wiki/记忆化)存储，以便下次需要同一个子问题解之时直接查表。

- 切割钢条问题,Floyd最短路问题,最大不下降子序列,矩阵链乘,凸多边形三角剖分,0-1背包,最长公共子序列,最优二分搜索树

- **背包问题**：

  - 模版一：

  ```java
  // weight:物品重量，n:物品个数，w:背包可承载重量
  public int knapsack(int[] weight, int n, int w) {
    boolean[][] states = new boolean[n][w+1];
    // 哨兵优化
    states[0][0] = true; 
    if (weight[0] <= w) {
      states[0][weight[0]] = true; 
    }
    for (int i = 1; i < n; ++i) { // 动态规划状态转移
      for (int j = 0; j <= w; ++j) { // 不把第i个物品放入背包
        if (states[i-1][j]==true) states[i][j] = states[i-1][j];
      }
      for (int j = 0; j <= w-weight[i]; ++j) {//把第i个物品放入背包 
        if (states[i-1][j]==true) states[i][j+weight[i]] = true; 
      }
      for (int i = w; i >= 0; --i) { // 输出结果 
        if (states[n-1][i] == true) return i; 
      }
  		return 0;
    }
  }
  
  
  public static int knapsack2(int[] items, int n, int w) {
    boolean[] states = new boolean[w+1]; // 默认值false
    states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
    if (items[0] <= w) {
      states[items[0]] = true;
    }
    for (int i = 1; i < n; ++i) { // 动态规划
      for (int j = w-items[i]; j >= 0; --j) {//把第i个物品放入背包
        if (states[j]==true) states[j+items[i]] = true;
      }
    }
    for (int i = w; i >= 0; --i) { // 输出结果
      if (states[i] == true) return i;
    }
    return 0;
  }
  
  
  public static int knapsack3(int[] weight, int[] value, int n, int w) {
    int[][] states = new int[n][w+1];
    for (int i = 0; i < n; ++i) { // 初始化states
      for (int j = 0; j < w+1; ++j) {
        states[i][j] = -1;
      }
    }
    states[0][0] = 0;
    if (weight[0] <= w) {
      states[0][weight[0]] = value[0];
    }
    for (int i = 1; i < n; ++i) { //动态规划，状态转移
      for (int j = 0; j <= w; ++j) { // 不选择第i个物品
        if (states[i-1][j] >= 0) states[i][j] = states[i-1][j];
      }
      for (int j = 0; j <= w-weight[i]; ++j) { // 选择第i个物品
        if (states[i-1][j] >= 0) {
          int v = states[i-1][j] + value[i];
          if (v > states[i][j+weight[i]]) {
            states[i][j+weight[i]] = v;
          }
        }
      }
    }
    // 找出最大值
    int maxvalue = -1;
    for (int j = 0; j <= w; ++j) {
      if (states[n-1][j] > maxvalue) maxvalue = states[n-1][j];
    }
    return maxvalue;
  }
  ```

  

