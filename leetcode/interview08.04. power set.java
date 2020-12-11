class Solution {            // ��ͨ���ݽⷨ
    private void backtrack(int[] nums, List<List<Integer>>res, List<Integer>list, int start){
        if(start == nums.length) return;            // �ݹ���ֹ����
        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            res.add(new ArrayList<>(list));         // �ڵݹ�֮ǰ�Ȱѵ�ǰ�������
            backtrack(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());          // �ѿռ���������
        backtrack(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }
}

class Solution {            // ��΢�Ľ��ⷨ��ȥ����ģ���е���ֹ������������һ����ֹ������
    private void backtrack(int[] nums, List<List<Integer>>res, List<Integer>list,int start){
        res.add(new ArrayList<Integer>(list));          // ��ִ��֮ǰ�ȼ����������У�ͳһ�ռ����������ϵĲ�����
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

class Solution {            // λ����
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = 1 << nums.length;
        for(int i = 0; i < len; i++){           // ����0~2^n-1������
            List<Integer>temp = new ArrayList<Integer>();
            for(int j = 0; j < nums.length; j++){       // ���ֵĶ����Ƴ���<= num.length
                if((i & (1 << j)) != 0) temp.add(nums[j]);      // ���ֵĶ����Ʊ�ʾ��Ӧÿ�����ֵ�ѡ��/��ѡ����ж�
            }
            res.add(temp);
        }
        return res;
    }
}

class Solution {                // ������
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());      // �ȼ���ռ�
        for(int num: nums){
            int len = res.size();
            for(int i = 0; i< len; i++){        // ����ÿ���Ӽ������Ӽ��������Ԫ�ع���һ���µ��Ӽ����뵽�����
                List<Integer> temp = new ArrayList<Integer>(res.get(i));
                temp.add(num);
                res.add(temp);
            }
        }
        return res;
    }
}