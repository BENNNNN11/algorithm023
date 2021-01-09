//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 430 👎 0


import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0, index = 0;
        int[] intersection = new int[Math.min(length1, length2)];
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index++] = nums1[index1++];
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


// 1. hashmap
//if (nums1.length > nums2.length) return intersect(nums2, nums1);
//Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
//for (int num : nums1) {
//    int count = hashMap.getOrDefault(num, 0) + 1;
//    hashMap.put(num, count);
//}
//int[] intersection = new int[nums1.length];
//int index = 0;
//for (int num : nums2) {
//    int count = hashMap.getOrDefault(num, 0);
//    if (count > 0) {
//    intersection[index++] = num;
//    count--;
//    }
//    if (count > 0) {
//    hashMap.put(num, count);
//    } else {
//    hashMap.remove(num);
//    }
//}
//return Arrays.copyOfRange(intersection, 0, index);

// 2. sort first