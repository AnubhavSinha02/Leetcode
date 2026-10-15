class Solution {
    public int sumCounts(List<Integer> nums) {
        int size = 2;
        int sum = nums.size();

        while (size <= nums.size()) {
            for (int i = 0; i <= nums.size() - size; i++) {

                int count = Math.toIntExact(nums.subList(i, i + size).stream().distinct().count());
                sum = sum + count * count;
            }
            size++;
        }

        return sum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna