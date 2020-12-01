class Solution {            // 快慢指针法
    private int count(int n){       // 计算下一个数
        int sum = 0;
        while(n != 0){
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int one = n, two = count(n);
        while(two != 1 && one != two){
            one = count(one);       // 慢指针一次走一步
            two = count(two);       // 快指针一次走两步
            two = count(two);
        }
        if(two == 1) return true;       // 如果是衰减到1了，那么就是快乐数
        else return false;          // 如果是因为相遇跳出的，那么就是因为出现了循环
    }
}

class Solution {            // 哈希集合法
    private int count(int n){
        int sum = 0;
        while(n != 0){
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        Set<Integer> store = new HashSet<Integer>();        // 用一个hash集合存放出现过的数字（不包括本身）
        while(n != 1){
            n = count(n);
            if(!store.contains(n)) store.add(n);        // 如果不包含该数字，就加入集合中，查找的时间复杂度为O(1)
            else return false;          // 如果出现过，就说明出现循环，就直接返回
        }
        return true;
    }
}