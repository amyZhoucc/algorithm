class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums.length < 4) return res;     // 处理特殊情况

        Arrays.sort(nums);          // 排序
        int len = nums.length;
        for(int i = 0; i < len - 3; i++){       // 第一重循环
            // if(nums[i] > target) return res;    // 如果第一个数已经>目标——不能这样简单的判断
            if(i > 0 && nums[i] == nums[i - 1]) continue;   // 第一重的去重
            // 到这一步说明第0个数不重复且<目标
            for(int j = i + 1; j < len - 2; j++){
                // if((nums[i] + nums[j]) > target) return res;  //——判断法不可取
                if(j > (i + 1) && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = len - 1;
                while(left < right){
                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    if(temp == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right]== nums[right - 1]) right--; 
                        left++;
                        right--;
                    }
                    else if(temp < target) left++;
                    else right--;
                }
            }
        }
        return res;
    }
}

class Solution {            // 剪枝一下
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums.length < 4) return res;     // 处理特殊情况

        Arrays.sort(nums);          // 排序
        int len = nums.length;
        for(int i = 0; i < len - 3; i++){       // 第一重循环
            if(i > 0 && nums[i] == nums[i - 1]) continue;   // 第一重的去重
            if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;  // 最小的都大了
            if(nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) continue;  // 该i下，最大的都太小
           
            // 到这一步说明第0个数不重复且在区间内
            for(int j = i + 1; j < len - 2; j++){
                if(j > (i + 1) && nums[j] == nums[j - 1]) continue;
                if(nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if(nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) continue;

                int left = j + 1, right = len - 1;
                while(left < right){
                    int temp = nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if(temp == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right]== nums[right - 1]) right--; 
                        left++;
                        right--;
                    }
                    else if(temp < target) left++;
                    else right--;
                }
            }
        }
        return res;
    }
}