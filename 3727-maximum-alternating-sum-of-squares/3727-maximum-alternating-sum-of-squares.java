class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int i = 0;
        int j = (nums.length / 2);

        boolean flip = true;

        long sum = 0;

        int last = j;

        while (i < last || j < nums.length) {

            if (flip) {
                sum += (long) nums[j] * nums[j];
                j++;
                flip = false;
            } else {
                sum -= (long) nums[i] * nums[i];
                i++;
                flip = true;
            }
        }

        return sum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna