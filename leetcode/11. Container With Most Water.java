class Solution {                    // 双指针解法，从自己写的代码上稍微优化了的
    public int maxArea(int[] height) {
        int head = 0, tail = height.length - 1;   // 头指针，尾指针
        int maxnum = 0;    // 分别存放面积最大值
        while(head != tail){
            int area = (tail - head) * (Math.min(height[head], height[tail]));  // 当前面积
            maxnum = Math.max(area, maxnum);        // 两者取最大
            if(height[head] < height[tail]) head++;
            else tail--;
        }
        return maxnum;
    }
}

class Solution {                // 本质没变，换成三目运算符，效率更高，代码更漂亮，但是理解性没有上面的好
    public int maxArea(int[] height) {
        int head = 0, tail = height.length - 1;   // 头指针，尾指针
        int maxnum = 0;    // 分别存放面积最大值
        while(head != tail){
            maxnum = height[head] > height[tail] ? 
                    Math.max(maxnum, (tail - head) * height[tail--]):
                    Math.max(maxnum, (tail - head) * height[head++]);
        }
        return maxnum;
    }
}
