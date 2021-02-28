from bitarray import bitarray
import mmh3
# mmh3全程murmurhash3,是一种非加密的哈希算法，
# 常用于hadoop等分布式存储情境中

class BloomFilter:
    def __init__(self, size, hash_num):
        """
        :param size: 总共有多少个元素
        :param hash_num: 一个元素分成多少个二进制位
        """
        self.size = size
        self.hash_num = hash_num
        self.bit_array = bitarray(size)
        self.bit_array.setall(0)

    def add(self, s):
        for seed in range(self.hash_num):
            result = mmh3.hash(s, seed) % self.size
            self.bit_array[result] = 1

    def lookup(self, s):
        for seed in range(self.hash_num):
            result = mmh3.hash(s, seed) % self.size
            if self.bit_array[result] == 0:
                return "Nope"
        return "Probably"

bf = BloomFilter(50000, 7)
bf.add("asdasd")
print(bf.lookup("asdasd"))
print(bf.lookup("qweqwe"))