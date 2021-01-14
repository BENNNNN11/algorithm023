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

    1. 本质是通过**函数**进行的**循环**
    2.  一层层的**向下递归**，然后一层层**回溯**
3. 找到有**重复性**的地方
    
    ```python
    def factorial(n):  # n!, 相当调用栈
      if n <= 1:
    		return 1 
      return n * factorial(n-1)
```
    
3. **递归的代码模版**：
    
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
        
        