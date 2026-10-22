class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int best = 0;
        int sum = 0;                                   // fix 1: declare sum, drop res

        for (int i = 0; i < nums.length; i++) {        // fix 5: index loop, not for-each
            if (nums[i] == 0) {
                sum -= 1;                              // fix 2
            } else {
                sum += 1;
            }

            if (map.containsKey(sum)) {                // fix 6 + 7: one if/else
                best = Math.max(best, i - map.get(sum));
            } else {
                map.put(sum, i);                       // fix 3: semicolon; only first time
            }
        }
        return best;                                   // fix 4
    }
}