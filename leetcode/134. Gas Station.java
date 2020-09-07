class Solution {                // 最直白解法
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        for(int i = 0; i < len; i++){    // 遍历起点
            if(gas[i] < cost[i]) continue;      // 如果起点获得的汽油值小于消耗的汽油值，即无法到达下一个节点
            int sum = 0;
            int k = i;              // 当前节点到下一个节点的消耗
            int flag = 0;
            for(int j = 0; j < len; j++){    // 控制遍历次数
                sum += gas[k];              // 先获得油
                sum -= cost[k];             // 减去当前节点到下一个节点的消耗
                if(sum < 0){
                    flag = 1;
                    break;      // 无法到下一个节点
                }
                k++;
                k = (k == len) ? 0 : k;   // 移动到下一个节点
            }
            if(flag == 0) return i;
        }
        return -1;
    }
}