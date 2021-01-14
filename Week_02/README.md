学习笔记

1. 基于图的常见算法

    - DFS: 

        - DFS 递归写法

        ```python
        visited = set() 
        # the difference between tree and graph, since there is no cycle in tree stucture.
        def dfs(node, visited): 
          if node in visited: # end condition 
            return 
          visited.add(node)
        	# process current node here... 
          for next_node in node.children():
            if not next_node in visited: 
              dfs(next_node, visited)
        
        ```

    - BFS template: 

        ```python
        def bfs(graph, start, end): 
          queue = []
          queue.append([start])
          
          visited = set()
          while queue: 
            node = queue.pop()
            visited.add(node) 
            process(node) 
            nodes = generate_related _nodes(node) 
            queue.push(nodes)
        ```

        

2. 图的高级算法
    1. 连通图的个数：https://leetcode-cn.com/problems/number-of-islands/
    2. Topological Sort: https://zhuanlan.zhihu.com/p/34871092
    3. 最短路径： Dijkstra https://www.bilibili.com/video/av25829980?from=search&seid=13391343514095937158
    4. 最小生成树(MST)： https://www.bilibili.com/video/av84820276?from=search&seid=17476598104352152051