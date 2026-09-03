class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Arrays.stream(nums1).min().getAsInt();

        if (min % 2 == 1) {
            return true;
        }

        for (int num : nums1) {
            if (num % 2 == 1) {
                return false;
            }
        }

        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna