class Solution {        // ��ϣ����
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> store = new HashMap<Integer, Integer>();      // ����һ����ϣ��
        for(int num: nums){
            if(store.containsKey(num)) return true;         // �������������ô�Ѿ����ֹ��ˣ��ͷ���true
            else{
                store.put(num, 1);              // ����ͼ����ϣ����
            }
        }
        return false;               // �����ִ����ɶ�û�г����ظ��ģ���ô�Ż�ִ�е��ⲽ���ͷ���false
    }
}