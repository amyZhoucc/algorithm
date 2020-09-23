class Solution {                            // 暴力解法
    public int[] buildArray(HashSet<Integer> set1, HashSet<Integer> set2){      // set1是更长的集合，set2是稍短的集合
        int[] out = new int[set2.size()];
        int count = 0;
        for(int i: set1){
            if(set2.contains(i)) out[count++] = i;          // 查看set1中是否存在set2中的元素
        }
        int[] output = new int[count];                      // 再将数组整理成需要的大小
        for(int i = 0; i < count; i++) output[i] = out[i];
        return output;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();        // 将两个数组都转换成哈希集合
        HashSet<Integer> set2 = new HashSet<>();
        int num = 0;
        for(int i: nums1){
            set1.add(i);
        }
        for(int i: nums2){
            set2.add(i);
        }
        if(set1.size() >= set2.size()) return buildArray(set1, set2);       // 比较两个集合哪个更大，大的放在前小的放在后
        else return buildArray(set2, set1);
    }
}

class Solution {
    public int[] buildArray(HashSet<Integer> set1, HashSet<Integer> set2){
        int[] out = new int[set2.size()];
        int count = 0;
        for(int i: set1){
            if(set2.contains(i)) out[count++] = i;
        }
        return Arrays.copyOf(out, count);                           // 复制数组生成新的数组对象，参数二指定新生成的数组大小
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int num = 0;
        for(int i: nums1){
            set1.add(i);
        }
        for(int i: nums2){
            set2.add(i);
        }
        if(set1.size() >= set2.size()) return buildArray(set1, set2);
        else return buildArray(set2, set1);
    }
}

class Solution {                            // 使用内置函数
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();        // 将数组构建两个哈希表
        HashSet<Integer> set2 = new HashSet<>();
        int num = 0;
        for(int i: nums1){
            set1.add(i);
        }
        for(int i: nums2){
            set2.add(i);
        }
        set1.retainAll(set2);               // 内置函数，set1中移除set2中不包含的数字

        int[] out = new int[set1.size()];           // 将新set1转换为数组
        for(int i: set1){
            out[num++] = i;
        }
        return out;
    }
}