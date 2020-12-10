class Solution {                // 普通解法，空间消耗O(MN)
    public int uniquePaths(int m, int n) {
        int[][] memory = new int[n][m];     // 做一个备忘录，记录所有的点的路径数
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0) memory[i][j] = 1;      // 处理特殊情况
                else{
                    memory[i][j] = memory[i - 1][j] + memory[i][j - 1];     // 递推方程式：f(n,m) = f(n - 1, m) + f(n, m - 1)
                }
            }
        }
        return memory[n - 1][m - 1];
    }
}

class Solution {            // 优化空间消耗，空间消耗O(2N)
    public int uniquePaths(int m, int n) {
        int[] prev = new int[m];        // 存放上一行
        int[] cur = new int[m];         // 存放当前行
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

class Solution {            // 再次优化空间消耗，空间消耗O(N)
    public int uniquePaths(int m, int n) {
        int[] cur = new int[m];
        Arrays.fill(cur, 1);
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                cur[j] += cur[j - 1];   // cur[j] + cur[j - 1]：就是那上次的结果（上一行的结果）+前一列同行结果
            }
        }
        return cur[m - 1];
    }
}