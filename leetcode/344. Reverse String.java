class Solution {                    // 普通解法
    public void reverseString(char[] s) {
        int len = s.length;   // 求数组的长度
        for(int i = 0; i < len / 2; i++){       // 从两端开始遍历到中间，左边遍历到中间节点那么就结束
            char temp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = temp;
        }
    }
}


class Solution {                    // 递归解法
    public void reverse(char[] s, int left, int right){
        if(left >= right) return;               // 递归的终止条件——两个节点相遇
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reverse(s, ++left, --right);
    }
    public void reverseString(char[] s) {
        reverse(s, 0, s.length - 1);
    }
}