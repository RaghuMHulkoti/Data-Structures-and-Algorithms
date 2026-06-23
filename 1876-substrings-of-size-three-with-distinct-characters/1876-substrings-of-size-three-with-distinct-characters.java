class Solution {
    public int countGoodSubstrings(String s) {
        int l = 0;
        int count = 0;
        for (int r = 0; r < s.length(); r++) {
            if (r - l + 1 == 3) {
                if (isGoodString(s.substring(l, r + 1))) {
                    count++;
                }
                l++;

            }
        }
        return count;
    }

    public boolean isGoodString(String s) {
        HashSet<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            if (!set.add(ch)) {
                return false;
            }
        }

        return true;
    }
}