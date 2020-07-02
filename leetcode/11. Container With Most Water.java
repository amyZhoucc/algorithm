class Solution {				// ˫ָ��ⷨ
    public int maxArea(int[] height) {
        int head = 0;       // ͷָ��
        int tail = height.length - 1;   // βָ��
        int maxnum = 0, left, right;    // �ֱ���������ֵ�Ͷ�Ӧ������
        while(head != tail){
            int area = (tail - head) * (Math.min(height[head], height[tail]));  // ��ǰ���
            if(area > maxnum){			// �������ϴ�͸���
                maxnum = area;
                left = head;
                right = tail;
            }
            if(height[head] < height[tail]) head++;	// ����ֵ��С������
            else tail--;
        }
        return maxnum;
    }
}
