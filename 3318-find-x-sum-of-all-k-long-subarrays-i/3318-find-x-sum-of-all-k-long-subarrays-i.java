class Solution {

    public int[] findXSum(int[] nums, int k, int x) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int[] answer = new int[nums.length - k + 1];

        int left = 0;
        int index = 0;

        for (int right = 0; right < nums.length; right++) {
            addElement(frequencyMap, nums[right]);

            if (right - left + 1 > k) {
                removeElement(frequencyMap, nums[left]);
                left++;
            }

            if (right - left + 1 == k) {
                answer[index++] = calculateXSum(frequencyMap, x);
            }
        }

        return answer;
    }

    private void addElement(HashMap<Integer, Integer> frequencyMap, int num) {
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    private void removeElement(HashMap<Integer, Integer> frequencyMap, int num) {
        frequencyMap.put(num, frequencyMap.get(num) - 1);

        if (frequencyMap.get(num) == 0) {
            frequencyMap.remove(num);
        }
    }

    private int calculateXSum(HashMap<Integer, Integer> frequencyMap, int x) {
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());

        sortEntries(entries);

        return calculateSum(entries, x);
    }

    private void sortEntries(List<Map.Entry<Integer, Integer>> entries) {
        entries.sort((first, second) -> {
            if (!first.getValue().equals(second.getValue())) {
                return second.getValue() - first.getValue();
            }

            return second.getKey() - first.getKey();
        });
    }

    private int calculateSum(List<Map.Entry<Integer, Integer>> entries, int x) {
        int sum = 0;

        for (int i = 0; i < Math.min(x, entries.size()); i++) {
            Map.Entry<Integer, Integer> entry = entries.get(i);
            sum += entry.getKey() * entry.getValue();
        }

        return sum;
    }
}