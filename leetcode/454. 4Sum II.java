class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A.length == 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = A.length;
        for(int i = 0; i < len; i++){               // 将A与B进行遍历计算，将解存放到哈希表中
            for(int j = 0; j < len; j++){
                int sum = A[i] + B[j];
                if(!map.containsKey(sum)) map.put(sum, 1);
                else map.put(sum, map.get(sum) + 1);
            }
        }
        for(int i = 0; i < len; i++){           // C与D进行遍历计算，获取其相反数（如果是自定义和值的话，可以修改称target-sum）
            for(int j = 0; j < len; j++){
                int sum = -(C[i] + D[j]);
                if(map.containsKey(sum)) count += map.get(sum);     // 直接在哈希表中找目标值——O(1)
            }
        }
        return count;
    }
}