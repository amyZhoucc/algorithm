class Solution {           // 回溯算法
    // 存储满足要求的数组；存储当前递归路径上的数字；数组遍历起点；当前路径上数字和和目标还差多少；存放候选值的数组
    private void backtrack(List<List<Integer>>res, List<Integer>list, int start, int target, int[] candidates){
        if(target <= 0){            // 说明路径总和已经>=目标，递终止条件
            if(target == 0){        // 如果正好相等，说明就是需要的解
                res.add(new ArrayList<>(list));    // 注意要新建一个数组存放
            }
            return;
        }
        for(int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            backtrack(res, list, i, target - candidates[i], candidates);    // 注意这边的传参：target要相应的减少；并且要传递的是i（不能从整个数组头开始遍历——出现重复；也不能从i+1开始遍历，那么不能出现重复数字构成）
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();            // 存储满足要求的数组
        backtrack(res, new ArrayList<Integer>(), 0, target, candidates);
        return res;
    }
}

class Solution {            // 剪枝版本
    private void backtrack(List<List<Integer>>res, List<Integer>list, int start, int target, int[] candidates){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(target - candidates[i] < 0) return;      // 如果当前候选值加上就已经超过target，那么就直接返回（因为后面的数更大）
            list.add(candidates[i]);
            backtrack(res, list, i, target - candidates[i], candidates);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);        // 排序
        backtrack(res, new ArrayList<Integer>(), 0, target, candidates);
        return res;
    }
}