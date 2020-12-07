class Solution {
    public int matrixScore(int[][] A) {
        int row = A.length;    // 行数
        int col = A[0].length;  // 列数
        int max = (1<<(col - 1)) * row;   // 每行最高位，权重最大，一定要为1——所以直接为1

        for(int i = 1; i < col; i++){       // 按照列遍历，从第二列开始
            int count = 0;                  // 计算每一列的1的个数
            for(int j = 0; j < row; j++){
                if(A[j][0] == 1){       // 如果行首为1，说明没有执行行变换
                    count += A[j][i];
                }
                else{       // 如果行首为0，说明执行了
                    count += A[j][i]*(-1)+1;    
                }
            }
            // 1的个数要么count，要么row-count，就看哪个更大，就选择哪个
            max += Math.max(count, row - count) *(1 <<(col - 1 - i));
        }
        return max;
    }
}