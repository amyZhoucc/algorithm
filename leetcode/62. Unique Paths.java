class Solution {                // ��ͨ�ⷨ���ռ�����O(MN)
    public int uniquePaths(int m, int n) {
        int[][] memory = new int[n][m];     // ��һ������¼����¼���еĵ��·����
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0) memory[i][j] = 1;      // �����������
                else{
                    memory[i][j] = memory[i - 1][j] + memory[i][j - 1];     // ���Ʒ���ʽ��f(n,m) = f(n - 1, m) + f(n, m - 1)
                }
            }
        }
        return memory[n - 1][m - 1];
    }
}

class Solution {            // �Ż��ռ����ģ��ռ�����O(2N)
    public int uniquePaths(int m, int n) {
        int[] prev = new int[m];        // �����һ��
        int[] cur = new int[m];         // ��ŵ�ǰ��
        Arrays.fill(prev, 1);
        Arrays.fill(cur, 1);
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                cur[j] = cur[j - 1] + prev[j];
            }
            prev = cur.clone();
        }
        return cur[m - 1];
    }
}

class Solution {            // �ٴ��Ż��ռ����ģ��ռ�����O(N)
    public int uniquePaths(int m, int n) {
        int[] cur = new int[m];
        Arrays.fill(cur, 1);
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                cur[j] += cur[j - 1];   // cur[j] + cur[j - 1]���������ϴεĽ������һ�еĽ����+ǰһ��ͬ�н��
            }
        }
        return cur[m - 1];
    }
}