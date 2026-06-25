import java.util.Arrays;

class Solution {
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);

        int maxXor = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] > 2 * nums[left]) {
                left++;
            }

            for (int i = left; i <= right; i++) {
                maxXor = Math.max(maxXor, nums[i] ^ nums[right]);
            }
        }

        return maxXor;
    }
}