class Solution {
    private void backtrack(List<List<Integer>>res, int[] candidates, 
                           List<Integer> list, int start, int target){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(target - candidates[i] < 0) return;      // ��֦
            if(i > start && candidates[i] == candidates[i - 1]) continue;     // ȥ�ء����ظ�ֻ�ܳ�����ͬһ�㣬�����ǰ�ڵ��ǰ��������Ľڵ�һ������һ��������ظ���������Ҫ�����˴α���
            list.add(candidates[i]);
            backtrack(res, candidates, list, i + 1, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res = new ArrayList<>(); 
        Arrays.sort(candidates);        // ����
        backtrack(res, candidates, new ArrayList<Integer>(), 0, target);
        return res;
    }
}