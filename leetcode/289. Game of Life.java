class Solution {            // ���ݹ������¼�һ������
    public void gameOfLife(int[][] board) {
        int[][] help = {{-1, -1}, {-1, 0},{-1, 1}, {0, -1},{0, 1}, {1, -1},{1, 0},{1, 1}};  // �������飬��Χ��8���ڵ����������
        int lenR = board.length;
        int lenC = board[0].length;
        for(int i = 0; i < lenR; i++){
            for(int j = 0; j < lenC; j++){          // ����ÿ���ڵ�
                int neighborLive = 0;
                for(int m = 0; m < help.length; m++){       // �ҵ���Χ�ڵ㣬����¼��ǰ���Ľڵ���Ŀ������¼���µģ�
                    int row = i + help[m][0];
                    int col = j + help[m][1];

                    if(row >= 0 && row < lenR && col >= 0 && col < lenC){       // Խ���ж�
                        if(board[row][col] == 1 || board[row][col] == -1) neighborLive++;     // 1����ʾԭ���������Ҳ��-1����ʾԭ��������ڲ����
                    }
                }
                // ���ݹ����жϵ�ǰֵӦ������or��
                if(neighborLive < 2) board[i][j] = (board[i][j] > 0 ? -1 : 0);      // Ҫɱ��ϸ�������������0����ô����0�����������1����ô���-1
                else if(neighborLive == 3) board[i][j] = (board[i][j] <= 0 ? 2 : 1);     // Ҫ����ϸ�������������1����ô����1�����������0����ô���2
                else if(neighborLive > 3) board[i][j] = (board[i][j] > 0 ? -1 : 0);     // Ҫɱ��ϸ��             
            }
        }
        // Ȼ���������飬��-1/2���޸ĳ�0/1
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] > 0) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }
}

class Solution {            // ����λ���㣨��Ϊ����һ�㣩
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
                if((board[i][j] & 1) == 1){         // ��������
                    if(neighborLive >= 2 && neighborLive <= 3){ // �����һ�ֻ��Ǵ��ģ���ô����11����Ҫ�޸ģ������һ����������01-����Ҫ�޸�
                        board[i][j] = 0b11;
                    }
                }
                else if(neighborLive == 3){     // ���������ģ���һ�ֻ��������ģ���ô����00������Ҫ�޸ģ������һ�ָ����ô����10����Ҫ�޸�
                    board[i][j] = 0b10;
                }
            }
        }
        for(int i = 0; i < lenR; i++){      // �Ƴ����λ���������µ�һλ
            for(int j = 0; j < lenC; j++){
                board[i][j] >>= 1;
            }
        }
    }
}