class Solution {
    private void backtrack(List<List<Integer>>res, int[] candidates, 
                           List<Integer> list, int start, int target){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(target - candidates[i] < 0) return;      // 剪枝
            if(i > start && candidates[i] == candidates[i - 1]) continue;     // 去重——重复只能出现在同一层，如果当前节点和前面遍历过的节点一样，那一定会出现重复，所以需要跳过此次遍历
            list.add(candidates[i]);
            backtrack(res, candidates, list, i + 1, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res = new ArrayList<>(); 
        Arrays.sort(candidates);        // 排序
        backtrack(res, candidates, new ArrayList<Integer>(), 0, target);
        return res;
    }
}