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

``` java
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

