class Solution {
    public int maxProduct(int[] nums) {

        int maxEnding = nums[0];
        int minEnding = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int option1 = maxEnding * nums[i];
            int option2 = minEnding * nums[i];
            int option3 = nums[i];

            maxEnding = Math.max(option1, Math.max(option2, option3));

            minEnding = Math.min(option1, Math.min(option2, option3));

            maxProduct = Math.max(maxProduct, maxEnding);
        }

        return maxProduct;
    }
}