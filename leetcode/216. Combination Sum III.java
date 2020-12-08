class Solution {            // �����㷨
    private void backtrack(List<List<Integer>>res, List<Integer>list, int k, int start, int n){     // ���ݺ���
        if(list.size() == k || n <= 0){         // �ݹ���ֹ��������������Ҫ�� or ��ǰ�б�ĺ��Ѿ�>=����Ĵ�С
            if(list.size() == k && n == 0){
                res.add(new ArrayList<>(list));     // ע������Ҫ�½�һ����������ŵģ���Ϊadd����һ�����ñ��������Ժ����list�޸ĻᱻӰ��
            }
            return;
        }
        for(int i = start; i <= 9; i++){        // ��start~9����
            list.add(i);
            backtrack(res, list, k, i + 1, n - i);  // i+1��Ϊ�˷�ֹ����ֵ�����ظ���n-i��ʾ���ǵ�ǰ�б�ʹﵽn�������
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), k, 1, n);
        return res;
    }
}

class Solution {        // ��΢�ų�һЩ����������Ż�
    private void backtrack(List<List<Integer>>res, List<Integer>list, int k, int start, int n){
        if(10 - start < k - list.size()) return;    // ʣ��ĸ���ȫ������ȥ�����ܴչ�k��������ôֱ�ӷ��أ���������Ϊ�ж�+ȡ���鳤�ȵ���ռ���ڴ�����ˣ�
        if(list.size() == k || n <= 0){
            if(list.size() == k && n == 0){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i = start; i <= 9; i++){
            list.add(i);
            backtrack(res, list, k, i + 1, n - i);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(k > n || k <= 0 || n <= 0) return res;
        if((19 - k) * k / 2 < n) return res;
        backtrack(res, new ArrayList<Integer>(), k, 1, n);
        return res;
    }
}