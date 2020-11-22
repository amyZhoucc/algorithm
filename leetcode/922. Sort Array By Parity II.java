class Solution {
    public int[] sortArrayByParityII(int[] A) {         // 笨蛋的策略：用双指针，先将奇偶数全部分开放到两边，然后再依次插入
        if(A.length == 0) return A;
        int len = A.length;
        int even = 0, odd = len - 1;
        for(; even < len / 2;){
            if(A[even] % 2 == 0 && A[odd] % 2 == 1){
                even++;
                odd--;
            }
            else if(A[even] % 2 == 0 && A[odd] % 2 == 0) even++;
            else if(A[even] % 2 == 1 && A[odd] % 2 == 1) odd--;
            else{
                int temp = A[even];
                A[even] = A[odd];
                A[odd] = temp;
                even++;
                odd--;
            }
        }
        even = 1;
        odd = len - 2;
        for(; even < len / 2;){
            int temp = A[even];
            A[even] = A[odd];
            A[odd] = temp;
            even += 2;
            odd -= 2;
        }
        return A;
    }
}