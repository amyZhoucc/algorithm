class Solution {
    public int[] countBits(int num) {
        if(num == 0) return new int[]{0};
        int[] res = new int[num + 1];       // ·µ»ØÖµ
        res[1] = 1;
        for(int i = 2; i <= num; i++){
            if(i % 2 == 0) res[i] = res[i >> 1];
            else res[i] = res[i - 1] + 1;
        }
        return res;
    }
}