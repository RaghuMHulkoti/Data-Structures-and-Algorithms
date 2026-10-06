import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 has occurred once
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            // Calculate current prefix sum
            sum += num;

            // Find the prefix sum we need
            int required = sum - k;

            // If it exists, we found that many subarrays
            if (map.containsKey(required)) {
                count += map.get(required);
            }

            // Store current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}