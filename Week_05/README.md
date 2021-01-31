# 学习笔记

## 动态规划

- 动态递归

- 分治+最优子结构

  - 共性： 找到重复子问题
  - 差异： 中途可以淘汰次优解

- Fibonacci sequence:

  - Naive verison: O(2^n) time 

  ```java
  int fib(int n){
    if (n <= 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return fib(n-1) + fib(n-2);
    }
  }
  ```

  - Memorization: O(n) time 

  ```java
  int fib(int n, int[] memo) {
    if (n <= 1) return n;
    if (memo[n] == 0) {
      memo[n] = fib(n-1) + fib(n-2);
    }
    return memo[n];
  }
  ```

  - Bottom up: 

    ```java
    a[0] = 1, a[1] = 1
    for (int i = 2; i <= n; i++) {
      a[i] = a[i-1] + a[i-2];
    }
    ```

- 路径计数： 

  - 分治

  ```java
  int countPaths(boolean[][] grid, int row, int col){
    if (!validSquare[grid, row, col]) return 0;
    if (isAtEnd(grid, row, col)) return 1;
    return countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
  }
  ```

  - 动态规划

  ```python
  # 状态转移方程
  if a[i, j] == '空地':
  	opt[i,j] = opt[i+1, j] + opt[i, j+1]
  else: 
    a[i,j] = 0
  ```

- 动态规划关键点： 

  - 最优子结构： 
  - 储存中间状态：
  - 递推公式

- 爬楼梯

  - 每次能走1，2，3步， 但是相邻的两步不能相同

  ```
  
  ```

  

  

## 期中考试：

1. 数组，链表， 跳表， 栈，队列，优先队列 ，哈希表，映射，集合
2. 树，二叉树，二叉搜索树， 堆，图， 泛型递归，树的递归 
3. 分治，回溯， bfs,  dfs 
4. 贪心，动态规划

