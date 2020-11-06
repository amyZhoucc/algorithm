class Solution {
    public int[] sortByBits(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            arr[i] += Integer.bitCount(arr[i]) * 100000;        // 利用算法的求某数的二进制的1个数，然后加上数本身——用来区别同1数，但是值不一样
        }
        Arrays.sort(arr);       // 排序
        for(int i = 0; i < arr.length; i++){            // 恢复原值
            arr[i] %= 100000;
        }
        return arr;
    }
}