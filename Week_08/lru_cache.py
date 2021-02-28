#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time : 2021-02-28 20:49
# @Author : XXX
# @Site : 
# @File : lru_cache.py
# @Software: PyCharm
class DLinkedNode(object):
	def __init__(self, key=0, value=0):
		self.key = key
		self.value = value
		self.prev = None 
		self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        self.cache = dict()
        self.head = DLinkedNode()
        self.tail = DLinkedNode()
        self.head.next = self.tail	
        self.tail.prev = self.head
        self.capacity = capacity
        self.size = 0 

    def get(self, key: int) -> int:
        if key not in self.cache: 
            return -1 
        # 如果key存在， 先通过哈希表定位， 然后定位到头部
        node = self.cache[key]
        self.moveToHead(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        if key not in self.cache:
            node = DLinkedNode(key, value)
            # 再添加到哈希表中
            self.cache[key] = node 
            # 再添加到头部 
            self.addToHead(node)
            self.size += 1 
            # 判断是否超出容量
            if self.size > self.capacity:
                removed = self.removeTail()
                self.cache.pop(removed.key)
                self.size -= 1 
        else: 
            # 如果在缓存中， 先通过哈希表定位，再修改value，然后移到头部
            node = self.cache[key]
            node.value = value
            self.moveToHead(node)
    def moveToHead(self, node):
        self.removeNode(node)
        self.addToHead(node)

    def addToHead(self, node): 
        node.prev = self.head
        node.next = self.head.next
        self.head.next.prev = node 
        self.head.next = node 

    def removeTail(self): 
        node = self.tail.prev
        self.removeNode(node)
        return node 

    def removeNode(self, node): 
        node.prev.next = node.next
        node.next.prev = node.prev	



# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
