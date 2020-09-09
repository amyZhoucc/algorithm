class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;      // 求数组的长度——这个就是递归的深度
        boolean[] used = new boolean[len];      // 维护一个数组来该数字的使用情况、
        List<List<Integer>> res = new ArrayList<>();        // 维护结果——为二维数组
        ArrayList<Integer> path = new ArrayList<>();        // 维护当前遍历的结果

        dfs(nums, used, len, 0, res, path);             // 调用该函数之后，res的结果已经被写入了

        return res;

    }
    public void dfs(int[] nums, boolean[] used, int len, int depth, List<List<Integer>> res, ArrayList<Integer> path){
        if(len == depth){           // 已经达到最大的深度了——将当前的path加入到res中，记得需要拷贝，而不是直接插入——因为后面需要回溯
            ArrayList<Integer> temp = new ArrayList<Integer>(path);
            res.add(temp);
            return;                 // 递归结束
        }

        for(int i = 0; i < len; i++){           // 按照数组的顺序进行遍历——每次dfs都是从index的0开始进行遍历
            if(!used[i]){           // 如果该节点没有被使用，那么就加入到path中，并且标记used
                path.add(nums[i]);      // 加入到队列中
                used[i] = true;         // 并且标记为使用

                dfs(nums, used, len, depth+1, res, path);
                // 表明深度已经到底，开始返回
                // 开始回溯
                path.remove(path.size()-1);         // 将该节点弹出
                used[i] = false;                // 并且将该节点重新标记为未使用
            }
        }
        // 表示该节点下的遍历已经结束，已经找到了该节点以下的所有可能排列
    }
}