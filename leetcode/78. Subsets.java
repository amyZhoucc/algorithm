class Solution {
    private void backtrace(int[] nums, List<List<Integer>>res, List<Integer>list, int cur){
        res.add(new ArrayList<>(list));
        for(int i = cur; i < nums.length; i++){
            list.add(nums[i]);
            backtrace(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrace(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }
}