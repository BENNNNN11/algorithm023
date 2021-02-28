学习笔记

# 位运算

- xor: 异或， 相同的0， 不同的为1 
  - x ^ 0  = x 
  - x ^ 1s = ~x
  - x ^ (~x) = 1s 
  - x ^ x = 0
  - c = a ^ b  -> a ^ b = c, b ^ c = a 
  - a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c 

- **指定位置的位运算**

  - **将x的最右边的n位清零：x & (~0<<n)**
  - **获取x的第n位： (x >> n) & 1**
  - **获取x的第n位的幂值： x & (1 << n)** 
  - **仅将第n位置1: x | (1 << n)** 
  - **仅将第n位置0：x & (~(1 << n))**
  - **将x最高位至第n位（included）清零：x & ((1 << n) - 1)**

  - **判断奇偶：** 
    - **(x & 1) == 1 odd**  
    - **(x & 1) == 0  even** 
  - **x >> 1: x / 2**
  - **清零最低位的1：x = x & (x - 1)** 
  - **得到最低位的1:   x & -x**

# 布隆过滤器bloom filter

- 哈希表的存储形式： hash函数 + 拉链存储重复元素
- 在只需要查询数据有或者没有的场景下： [bloom filter](https://www.cnblogs.com/cpselvis/p/6265825.html)
- bloom filter vs hash table 
  - bloom filter: 二进制向量 + 随机映射函数， 可以检索一个元素是否在一个集合中
    - 优点： 空间效率和查询时间远远好于一般算法
    - 缺点：存在一定的误识别率， 删除困难
    - 查询结果不存在则一定不存在，查询结果存在则可能存在
    - [例子](https://blog.csdn.net/tianyaleixiaowu/article/details/74721877)： 最外层的缓存，比特币， 分布式网络， redis， 垃圾邮件

# LRU cache 

- cache 缓存
  - 两个要素： 
    - 大小
    - 替换策略
  - hash table（查询） + double linkedlist （修改，更新）
    - O(1) 查询
    - O(1)  修改， 更新
    - ![img](https://pic4.zhimg.com/80/v2-09f037608b1b2de70b52d1312ef3b307_1440w.jpg)
  - [替换算法](https://en.wikipedia.org/wiki/Cache_replacement_policies): LRU, LFU, FIFO, LIFO... 

# 排序

- [十大排序](https://www.cnblogs.com/onepixel/p/7674659.html)
- 比较类：
  - 交换排序：
    - 冒泡排序
    - 快速排序
  - 插入排序：
    - 简单插入排序
    - 希尔排序
  - 选择排序：
    - 简单选择排序
    - 堆排
  - 归并排序： 
    - 二路
    - 多路
- 非比较类：线性时间， 限于整形
  - 计数排序
  - 桶排
  - 基数排序

