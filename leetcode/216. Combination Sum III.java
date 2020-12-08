class Solution {            // 回溯算法
    private void backtrack(List<List<Integer>>res, List<Integer>list, int k, int start, int n){     // 回溯函数
        if(list.size() == k || n <= 0){         // 递归终止条件：长度满足要求 or 当前列表的和已经>=请求的大小
            if(list.size() == k && n == 0){
                res.add(new ArrayList<>(list));     // 注意是需要新建一个数组来存放的，因为add的是一个引用变量，所以后面对list修改会被影响
            }
            return;
        }
        for(int i = start; i <= 9; i++){        // 从start~9遍历
            list.add(i);
            backtrack(res, list, k, i + 1, n - i);  // i+1是为了防止数组值出现重复，n-i表示的是当前列表和达到n还差多少
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), k, 1, n);
        return res;
    }
}

class Solution {        // 稍微排除一些特殊情况，优化
    private void backtrack(List<List<Integer>>res, List<Integer>list, int k, int start, int n){
        if(10 - start < k - list.size()) return;    // 剩余的个数全部加上去都不能凑够k个数，那么直接返回（可能是因为判断+取数组长度导致占用内存更多了）
        if(list.size() == k || n <= 0){
            if(list.size() == k && n == 0){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i = start; i <= 9; i++){
            list.add(i);
            backtrack(res, list, k, i + 1, n - i);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(k > n || k <= 0 || n <= 0) return res;
        if((19 - k) * k / 2 < n) return res;
        backtrack(res, new ArrayList<Integer>(), k, 1, n);
        return res;
    }
}