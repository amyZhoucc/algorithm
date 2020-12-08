class Solution {           // �����㷨
    // �洢����Ҫ������飻�洢��ǰ�ݹ�·���ϵ����֣����������㣻��ǰ·�������ֺͺ�Ŀ�껹����٣���ź�ѡֵ������
    private void backtrack(List<List<Integer>>res, List<Integer>list, int start, int target, int[] candidates){
        if(target <= 0){            // ˵��·���ܺ��Ѿ�>=Ŀ�꣬����ֹ����
            if(target == 0){        // ���������ȣ�˵��������Ҫ�Ľ�
                res.add(new ArrayList<>(list));    // ע��Ҫ�½�һ��������
            }
            return;
        }
        for(int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            backtrack(res, list, i, target - candidates[i], candidates);    // ע����ߵĴ��Σ�targetҪ��Ӧ�ļ��٣�����Ҫ���ݵ���i�����ܴ���������ͷ��ʼ�������������ظ���Ҳ���ܴ�i+1��ʼ��������ô���ܳ����ظ����ֹ��ɣ�
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();            // �洢����Ҫ�������
        backtrack(res, new ArrayList<Integer>(), 0, target, candidates);
        return res;
    }
}

class Solution {            // ��֦�汾
    private void backtrack(List<List<Integer>>res, List<Integer>list, int start, int target, int[] candidates){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(target - candidates[i] < 0) return;      // �����ǰ��ѡֵ���Ͼ��Ѿ�����target����ô��ֱ�ӷ��أ���Ϊ�����������
            list.add(candidates[i]);
            backtrack(res, list, i, target - candidates[i], candidates);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);        // ����
        backtrack(res, new ArrayList<Integer>(), 0, target, candidates);
        return res;
    }
}