class Solution {        // ������
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length -k];
    }
}

class Solution {        // ����partition��
    private int partition(int[] nums, int left, int right){ //
        int compare = nums[right];
        while(left < right){
            while(left < right && nums[left] <= compare) left++;
            if(left < right) nums[right--] = nums[left];
            while(left < right && nums[right] >= compare) right--;
            if(left < right) nums[left++] = nums[right];
        }
        nums[left] = compare;
        return left;
    }
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;       // ��k��Ԫ�����ڵ�indexֵ
        int left = 0, right = nums.length - 1;
        while(true){
            int index = partition(nums, left, right);
            if(index == target) return nums[index];
            else if(index < target) left = index + 1;
            else right = index - 1;
        }
        
    }
}

class Solution {           // �����Ż���
    private static Random random = new Random(System.currentTimeMillis());
    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    private int partition(int[] nums, int left, int right){ // ����������з�
        if(left < right){
            int randIndex = right - (random.nextInt(right - left) + 1);
            swap(nums, randIndex, right);       // �������ߵ�ֵ
        }
        int compare = nums[right];
        while(left < right){
            while(left < right && nums[left] <= compare) left++;
            if(left < right) nums[right--] = nums[left];
            while(left < right && nums[right] >= compare) right--;
            if(left < right) nums[left++] = nums[right];
        }
        nums[left] = compare;
        return left;
    }
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;       // ��k��Ԫ�����ڵ�indexֵ
        int left = 0, right = nums.length - 1;
        while(true){
            int index = partition(nums, left, right);
            if(index == target) return nums[index];
            else if(index < target) left = index + 1;   // �зֵĵ��Ŀ���ҪС����ôĿ����ֵ���������Һ�벿��
            else right = index - 1;           // �зֵ��Ŀ������ôĿ����ֵ��С��������ǰ�벿��
        }
        
    }
}

class Solution {        // ��С�ѽⷨ
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(len, (a, b)-> a - b);
        for(int i = 0; i < len; i++){
            minHeap.add(nums[i]);
        }
        for(int i = 0; i < len - k; i++){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}