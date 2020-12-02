class Solution {            // �������м�ֵ����ʱ�临�Ӷ�O(nlogn)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

class Solution {            // ʹ��hash��洢nums���ֵĴ�����Ȼ�����hash���������
    private  Map<Integer, Integer> countNumber(int[] nums){
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int num: nums){
            if(!count.containsKey(num))     // �����ϣ���в�������������ô���룬��value��1
                count.put(num, 1);
            else                            // ���������������ô��Ӧ��value++
                count.put(num, count.get(num) + 1); 
        }
        return count;
    }
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = countNumber(nums);    // �������飬��ֵ�����ϣ����
        Map.Entry<Integer, Integer>majority = null;
        for(Map.Entry<Integer, Integer>entry: count.entrySet()){
            if(majority == null || majority.getValue() < entry.getValue()){
                majority = entry;
            }
        }
        return majority.getKey();
    }
}

class Solution {            // ���η�
    private int countInArray(int[] nums, int left, int right, int value){
        int count = 0;
        for(int i = left; i <= right; i++){
            if(value == nums[i]) count++;
        }
        return count;
    }
    private int majorityFind(int[] nums, int left, int right){
        if(left == right) return nums[left];        // ���������ֻ��һ��Ԫ�أ���ô��һ��Ϊ����

        int mid = (right - left) / 2 + left;        // ����м�ֵ
        int leftValue = majorityFind(nums, left, mid);        // �ݹ�ȥ����ֶε�����
        int rightValue = majorityFind(nums, mid + 1, right);
        
        int leftNum,rightNum;
        if(leftValue == rightValue){
            return leftValue;   // �����������һ������ô�ͷ���
        }
        else{           // ���������һ�����Ϳ��ڴ˷�Χ�ڣ��ĸ����ִ�������
            leftNum = countInArray(nums, left, right, leftValue);
            rightNum = countInArray(nums, left, right, rightValue);
        }
        return leftNum > rightNum? leftValue : rightValue;
    }
    public int majorityElement(int[] nums) {
        return majorityFind(nums, 0, nums.length - 1);
    }
}

class Solution {           // ͶƱ�㷨
    public int majorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;
        for(int num : nums){
            if(count == 0) candidate = num; 
            if(candidate != num)
                count--;
            else
                count++;
        }
        return candidate;
    }
}