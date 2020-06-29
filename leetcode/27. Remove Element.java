package leetcode_algorithm;

class Solution {
    public int removeElement(int[] nums, int val) {
        int first = 0, second = 0;  // 两个指针，一个走前面遍历，一个结果后的指针
        for(; first < nums.length; first++){     // 遍历 
            if(nums[first] != val){             // 如果不相等，就更新second；相等，就不更新second
                nums[second] = nums[first];		// 将数组更新
                second++;
            }
        }
        return second;
    }
}

class secondSolution {					// 适用在要删除的元素比较少时
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while(i < n){					// 两个指针没有相遇
            if(nums[i] == val){			// 如果结点需要删除，那么将尾部的元素替换到前面
                nums[i] = nums[n - 1];
                n--;					// 并且尾部指针更新
            }
            else{
                i++;					// 不相等就更新头指针
            }
        }
        // 到此步，两个指针相遇了，说明数组就 i 的长度
        return i;
    }
}