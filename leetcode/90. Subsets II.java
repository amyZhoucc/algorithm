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
        Arrays.sort(nums);          // �����ٽ������ֻ���һ��
        backtrack(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }
}

class Solution {            // ������
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);          // �����ٽ������ֻ���һ��
        int new_start = 0;          // ��¼ÿ�������ļ��ϵ���ʼλ��
        for(int i = 0; i < nums.length; i++){
            int len = res.size();
            int j = 0;
            if(i != 0 && nums[i - 1] == nums[i]) j = new_start;     // ��������ظ����ʹ��ϴ�������λ�ÿ�ʼ
            for(; j < len; j++){
                List<Integer> temp = new ArrayList<Integer>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
            new_start = len;        // ���µ�ǰ�����������ļ�����res��λ��
        }
        return res;
    }
}