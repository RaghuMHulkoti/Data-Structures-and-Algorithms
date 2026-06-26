class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        if (k == 0) return 1;

        int[] bitCount = new int[32];
        int left = 0;
        int currentOr = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            for (int bit = 0; bit < 32; bit++) {
                if (((nums[right] >> bit) & 1) == 1) {
                    bitCount[bit]++;
                    currentOr |= (1 << bit);
                }
            }

            while (left <= right && currentOr >= k) {
                ans = Math.min(ans, right - left + 1);

                for (int bit = 0; bit < 32; bit++) {
                    if (((nums[left] >> bit) & 1) == 1) {
                        bitCount[bit]--;
                        if (bitCount[bit] == 0) {
                            currentOr &= ~(1 << bit);
                        }
                    }
                }

                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}