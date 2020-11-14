class Solution {                // 解法1
    public boolean validMountainArray(int[] arr) {
        if(arr.length <= 2) return false;       // 处理特殊情况  
        if(arr[1] <= arr[0]) return false;      // 初始就开始下坡的，就不符合要求

        boolean flag = true;
        int prev = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(flag && prev < arr[i]){      // 依然增高中
                flag = true;
            }
            else if(flag && prev > arr[i]){     // 前面增高当前开始降低了
                flag = false;
            }
            else if(!flag && prev > arr[i]){    // 前面降低，后面继续降低了
                flag = false;
            }
            else{               // 其他情况均为非
                return false;
            }
            prev = arr[i];
        }
        if(flag == true) return false;      // 一直没有降低过
        return true;
    }
}

class Solution {            // 解法2
    public boolean validMountainArray(int[] arr) {
        if(arr.length <= 2) return false;
        int high = 0;
        int i = 1;
        while(i < arr.length && arr[i - 1] < arr[i]){         // 先求出顶峰的位置
            i++;
        }
        high = i - 1;           
        if(high == 0 || high == arr.length-1) return false; // 判断顶峰是不是出现在开头还是结尾，都不符合要求
        while(i < arr.length){                  // 遍历下坡
            if(arr[i - 1] <= arr[i]) return false;      // 如果是平地/上坡就直接false
            i++;
        }
        return true;
    }
}