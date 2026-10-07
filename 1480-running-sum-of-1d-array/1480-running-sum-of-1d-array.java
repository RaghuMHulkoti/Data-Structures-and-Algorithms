class Solution {
    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
       int left = nums[0];
        runningSum[0]=left;
        for (int i=1;i<nums.length;i++){
            left+=nums[i];
            runningSum[i]=left;
        }
       return  runningSum;
    }
}