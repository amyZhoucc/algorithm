class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        while(n % 2 == 0) n /= 2;
        return n == 1;
    }
}

class Solution {               
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        int bit = 0;
        int mask = 1;
        while(n != 0){
            bit++;
            if(bit > 1) return false;
            n &= (n - 1);
        }
        return true;
    }
}
 
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        if((n & (n - 1)) == 0) return true;
        else return false;
    }
}