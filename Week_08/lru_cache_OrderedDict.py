
class LRUCache(): 
	def __int__(self, capacity):
		self.dic = collections.OrderedDict()
		self.capacity = capacity

	def get(self, key): 
		if key not in self.dic:
			return -1 
		value = self.dic.pop[key]
		self.dic[key] = value
		return value

	def put(self, key, value): 
		if key in self.key: 
			self.dic.pop(key) 
		else: 
			if self.capacity > 0: 
				self.capacity -= 1
			else:
				# If last=False ,the pairs are returned in FIFO order
				self.dic.popitem(last=False) 
		self.dic[key] = value

