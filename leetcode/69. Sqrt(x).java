class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;      // 除去特殊值
        int left = 1;           // 设置三个指针，指示左中右
        int right = x - 1;
        int mid;
        while(left <= right){       // 设置循环条件
            mid = ((right - left) >> 1) + left;
            if((long)mid * mid == x) {  // 找到正解，直接返回
                return mid;
            }
            else if((long)mid * mid < x){   // 缩小左边界
                left = mid + 1;
            }   
            else{           // 缩小右边界
                right = mid - 1;
            }
        }
        // 循环停止时，left = right + 1，那么正解就是left - 1
        return left - 1;
    }
}