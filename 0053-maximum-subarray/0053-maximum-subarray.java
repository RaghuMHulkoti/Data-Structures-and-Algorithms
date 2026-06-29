class Solution {
    public int maxSubArray(int[] nums) {
        int bestAns = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int option1 = bestAns + nums[i];
            int option2 = nums[i];

            bestAns = Math.max(option1, option2);

            maxSum = Math.max(maxSum, bestAns);
        }

        return maxSum;
    }
}