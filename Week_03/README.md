Week03学习笔记

1. **树前中后序遍历**示例： 

    1. **前序： 根左右**

        ```python
        def preorder(self, root):
          if root:
            self.traverse_path.append(root.val)
            self.preorder(root.left)
            self.preorder(root.right)
        ```

    2. **中序：左根右**

        ```python
        def inorder(self, root):
          if root:
            self.inorder(root.left)
            self.traverse_path.append(root.val)
            self.inorder(root.right)
        ```

    3. **后序：左右根**

        ```python
        def postorder(self, root):
          if root:
            self.postorder(root.left)
            self.postorder(root.right)
            self.traverse_path.append(root.val)
        ```

2. **递归Recursion**

    - 本质是通过**函数**进行的**循环**
    - 一层层的**向下递归**，然后一层层**回溯**
    - 找到有**重复性**的地方

    ```python
    def factorial(n):  # n!, 相当调用栈
      if n <= 1:
        return 1 
      return n * factorial(n-1)
    ```

3. **泛型递归的代码模版**：

    ```python
    def recursion():
    	# 1. recursion terminator 终止条件
      if level > MAX_LEVEL:
        process_result 
        return 
      # 2. process logic in current level 处理当前层
      process(level, data...)
      # 3. drill down 下探到下一层
      self.recursion(level+1, p1, ...) 
      # 4. reverse the curent level status if needed 清理当前层
    ```

    ```java
    public void recur(int level, int param) {
      // terminator 
      if (level > MAX_VALUE) {
     		// process result 
        return; 
      }
      // process the logic of current level 
      process(level, param);
      // drill down
      recur(level: level + 1, newParam);
      // resotre the current status  
    }
    ```

4. **分治和回溯**

    1. 本质就是找**重复性**

    2. 拆分成**子问题**

    3. **分治 divide & conquer**：怎么拆分成子问题 && 怎么合并子结果

        ```python
        def divide_conquer(problem, param1, param2):
          # recursion terminator 
          if problem is None: 
            print_result 
            return 
          # prepare data and divide problem
          data = prepare_data(problem)
          subproblems = split_problem(problem, data)
          # conquer problem 
          subresult1 = self.divide_conquer(subproblems[0], p1, ...)
          subresult2 = self.divide_conquer(subproblems[1], p1, ...)
          subresult3 = self.divide_conquer(subproblems[2], p1, ...)
        	# ... 
          # process and generate the final result 
          result = process_result(subresult1, subresult2,subresult3)
        ```

    4. **回溯**： 

        ```python
        # 回溯算法复杂度较高，因为回溯算法就是暴力穷举，遍历整颗树
        res = []
        def backtrack(path, choice_list):
            if terminator:
                res.append(path)
                return
            for choice in choice_list:    # 核心代码段
                # 做出选择
                # 递归执行backtrack
                # 撤销选择
        ```

        

