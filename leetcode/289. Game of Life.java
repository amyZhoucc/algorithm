class Solution {            // 根据规则，再新加一个规则
    public void gameOfLife(int[][] board) {
        int[][] help = {{-1, -1}, {-1, 0},{-1, 1}, {0, -1},{0, 1}, {1, -1},{1, 0},{1, 1}};  // 辅助数组，周围的8个节点的索引计算
        int lenR = board.length;
        int lenC = board[0].length;
        for(int i = 0; i < lenR; i++){
            for(int j = 0; j < lenC; j++){          // 遍历每个节点
                int neighborLive = 0;
                for(int m = 0; m < help.length; m++){       // 找到周围节点，并记录当前存活的节点数目（不记录更新的）
                    int row = i + help[m][0];
                    int col = j + help[m][1];

                    if(row >= 0 && row < lenR && col >= 0 && col < lenC){       // 越界判断
                        if(board[row][col] == 1 || board[row][col] == -1) neighborLive++;     // 1，表示原来存活现在也存活；-1，表示原来存活现在不存活
                    }
                }
                // 根据规则，判断当前值应该是死or活
                if(neighborLive < 2) board[i][j] = (board[i][j] > 0 ? -1 : 0);      // 要杀死细胞，如果本来是0，那么还是0；如果本来是1，那么变成-1
                else if(neighborLive == 3) board[i][j] = (board[i][j] <= 0 ? 2 : 1);     // 要复活细胞，如果本来是1，那么还是1；如果本来是0，那么变成2
                else if(neighborLive > 3) board[i][j] = (board[i][j] > 0 ? -1 : 0);     // 要杀死细胞             
            }
        }
        // 然后整理数组，将-1/2都修改成0/1
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] > 0) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }
}

class Solution {            // 运用位运算（更为巧妙一点）
    public void gameOfLife(int[][] board) {
        int[][] help = {{-1, -1}, {-1, 0},{-1, 1}, {0, -1},{0, 1}, {1, -1},{1, 0},{1, 1}};
        int lenR = board.length;
        int lenC = board[0].length;
        for(int i = 0; i < lenR; i++){
            for(int j = 0; j < lenC; j++){
                int neighborLive = 0;
                for(int m = 0 ; m < 8; m++){
                    int negihborR = i + help[m][0];
                    int negihborC = j + help[m][1];
                    if(negihborR >= 0 && negihborR < lenR && negihborC >= 0 && negihborC < lenC){
                        neighborLive += board[negihborR][negihborC] & 1;
                    }
                }
                if((board[i][j] & 1) == 1){         // 本来存活的
                    if(neighborLive >= 2 && neighborLive <= 3){ // 如果下一轮还是存活的，那么就是11，需要修改；如果下一轮是死亡的01-不需要修改
                        board[i][j] = 0b11;
                    }
                }
                else if(neighborLive == 3){     // 本来死亡的；下一轮还是死亡的，那么就是00，不需要修改；如果下一轮复活，那么就是10，需要修改
                    board[i][j] = 0b10;
                }
            }
        }
        for(int i = 0; i < lenR; i++){      // 移除最低位，保留最新的一位
            for(int j = 0; j < lenC; j++){
                board[i][j] >>= 1;
            }
        }
    }
}