class Solution {        // 哈希表方法
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> store = new HashMap<Integer, Integer>();      // 创建一个哈希表
        for(int num: nums){
            if(store.containsKey(num)) return true;         // 如果该数存在那么已经出现过了，就返回true
            else{
                store.put(num, 1);              // 否则就加入哈希表中
            }
        }
        return false;               // 如果到执行完成都没有出现重复的，那么才会执行到这步，就返回false
    }
}