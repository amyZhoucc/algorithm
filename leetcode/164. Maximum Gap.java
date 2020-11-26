class Solution {            // ÎÞÄÔ½â·¨
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int maxGap = 0;
        for(int i = 1; i < nums.length; i++){
            int temp = nums[i] - nums[i - 1];
            maxGap = temp > maxGap ? temp : maxGap;
        }
        return maxGap;
    }
}