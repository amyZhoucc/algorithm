class Solution {
    private void backtrack(int[] nums, List<List<Integer>>res, List<Integer>list, int start){
        res.add(new ArrayList<Integer>(list));
        for(int i = start; i < nums.length; i++){
            if(i != start && nums[i - 1] == nums[i]) continue;
            list.add(nums[i]);
            backtrack(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);          // 排序，临近的数字会在一起
        backtrack(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }
}

class Solution {            // 迭代法
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);          // 排序，临近的数字会在一起
        int new_start = 0;          // 记录每次新增的集合的起始位置
        for(int i = 0; i < nums.length; i++){
            int len = res.size();
            int j = 0;
            if(i != 0 && nums[i - 1] == nums[i]) j = new_start;     // 如果出现重复，就从上次新增的位置开始
            for(; j < len; j++){
                List<Integer> temp = new ArrayList<Integer>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
            new_start = len;        // 更新当前数字下新增的集合在res的位置
        }
        return res;
    }
}