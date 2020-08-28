class Solution {
    public boolean judgeCircle(String moves) {
        int left = 0, down = 0;
        for(int i = 0; i < moves.length(); i++){
            char temp = moves.charAt(i);
            if(temp == 'L') left++;
            if(temp == 'R') left--;
            if(temp == 'U') down--;
            if(temp == 'D') down++;
        }
        if(left == 0 && down == 0) return true;
        else return false;
    }
}