class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A.length == 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = A.length;
        for(int i = 0; i < len; i++){               // ��A��B���б������㣬�����ŵ���ϣ����
            for(int j = 0; j < len; j++){
                int sum = A[i] + B[j];
                if(!map.containsKey(sum)) map.put(sum, 1);
                else map.put(sum, map.get(sum) + 1);
            }
        }
        for(int i = 0; i < len; i++){           // C��D���б������㣬��ȡ���෴����������Զ����ֵ�Ļ��������޸ĳ�target-sum��
            for(int j = 0; j < len; j++){
                int sum = -(C[i] + D[j]);
                if(map.containsKey(sum)) count += map.get(sum);     // ֱ���ڹ�ϣ������Ŀ��ֵ����O(1)
            }
        }
        return count;
    }
}