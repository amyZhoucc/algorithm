class Solution {
    public int matrixScore(int[][] A) {
        int row = A.length;    // ����
        int col = A[0].length;  // ����
        int max = (1<<(col - 1)) * row;   // ÿ�����λ��Ȩ�����һ��ҪΪ1��������ֱ��Ϊ1

        for(int i = 1; i < col; i++){       // �����б������ӵڶ��п�ʼ
            int count = 0;                  // ����ÿһ�е�1�ĸ���
            for(int j = 0; j < row; j++){
                if(A[j][0] == 1){       // �������Ϊ1��˵��û��ִ���б任
                    count += A[j][i];
                }
                else{       // �������Ϊ0��˵��ִ����
                    count += A[j][i]*(-1)+1;    
                }
            }
            // 1�ĸ���Ҫôcount��Ҫôrow-count���Ϳ��ĸ����󣬾�ѡ���ĸ�
            max += Math.max(count, row - count) *(1 <<(col - 1 - i));
        }
        return max;
    }
}