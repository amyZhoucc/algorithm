class Solution {				// 双指针解法
    public int maxArea(int[] height) {
        int head = 0;       // 头指针
        int tail = height.length - 1;   // 尾指针
        int maxnum = 0, left, right;    // 分别存放面积最大值和对应的坐标
        while(head != tail){
            int area = (tail - head) * (Math.min(height[head], height[tail]));  // 当前面积
            if(area > maxnum){			// 如果面积较大就更新
                maxnum = area;
                left = head;
                right = tail;
            }
            if(height[head] < height[tail]) head++;	// 更新值较小的索引
            else tail--;
        }
        return maxnum;
    }
}
