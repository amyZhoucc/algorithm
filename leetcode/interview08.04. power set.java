class Solution {            // 普通回溯解法
    private void backtrack(int[] nums, List<List<Integer>>res, List<Integer>list, int start){
        if(start == nums.length) return;            // 递归终止条件
        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            res.add(new ArrayList<>(list));         // 在递归之前先把当前结果加入
            backtrack(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());          // 把空集加入结果中
        backtrack(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }
}

class Solution {            // 稍微改进解法（去掉了模板中的终止条件，隐藏有一个终止条件）
    private void backtrack(int[] nums, List<List<Integer>>res, List<Integer>list,int start){
        res.add(new ArrayList<Integer>(list));          // 在执行之前先加入结果数组中（统一空集和其他集合的操作）
        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            backtrack(nums, res, list, i + 1);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<Integer>(), 0);
        return res;

    }
}

class Solution {            // 位运算
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = 1 << nums.length;
        for(int i = 0; i < len; i++){           // 遍历0~2^n-1个数字
            List<Integer>temp = new ArrayList<Integer>();
            for(int j = 0; j < nums.length; j++){       // 数字的二进制长度<= num.length
                if((i & (1 << j)) != 0) temp.add(nums[j]);      // 数字的二进制表示对应每个数字的选择/不选择的判断
            }
            res.add(temp);
        }
        return res;
    }
}

class Solution {                // 迭代法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());      // 先加入空集
        for(int num: nums){
            int len = res.size();
            for(int i = 0; i< len; i++){        // 遍历每个子集，在子集里面添加元素构成一个新的子集加入到结果中
                List<Integer> temp = new ArrayList<Integer>(res.get(i));
                temp.add(num);
                res.add(temp);
            }
        }
        return res;
    }
}