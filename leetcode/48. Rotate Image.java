class Solution {                // ʹ���˶���ռ�ģ���ԭ���㷨
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }
}

class Solution {        // ���þ�������ԣ�ʵ�ֵ�ԭ���㷨���������·�ת���ٶԽ��߷�ת
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0; i < len / 2; i++){       // ���·�תʵ��
            for(int j = 0; j < len; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1- i][j];
                matrix[len - 1 - i][j] = temp;
            }
        }
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}