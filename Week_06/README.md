

# Week06 学习笔记

1. **爬楼梯问题**： F(n) = F(n-1) + F(n-2)

   -  每次可走1，2，3步

     - F(n) = F(n-1) + F(n-2) + F(n-3)

   -  每次可走1，2，3步， 但相邻两步的步伐不能相同

     - 状态数组：dp\[n阶][步数] = 方法数

     - 转移方程： 

       ```java
       dp[n][1] = dp[n-1][2] + dp[n-1][3]
       dp[n][2] = dp[n-2][1] + dp[n-2][3]  
       dp[n][3] = dp[n-3][1] + dp[n-1][2]  
       ```

     - 代码： 

       ```java
       class Solution{
         public int climbStairs(int n) {
       		int[][] dp = new int[n+1][4];
           dp[1][1] = 1;
           dp[2][2] = 1;
           dp[3][1] = 1;
           dp[3][2] = 1;
           dp[3][3] = 1;
       		for (int i = 4; i <= n; i++) {
             dp[n][1] = dp[n-1][2] + dp[n-1][3]
             dp[n][2] = dp[n-2][1] + dp[n-2][3]  
             dp[n][3] = dp[n-3][1] + dp[n-1][2]  
           }
           return dp[n][1] + dp[n][2] + dp[n][3];
         }
       }
       ```

2. 