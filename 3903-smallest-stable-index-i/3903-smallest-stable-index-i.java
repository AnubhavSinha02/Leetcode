class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] maxArr = new int[n];
        int[] minArr = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[n-1-i], min);

            maxArr[i] = max;
            minArr[n-1-i] = min;
        }

        for (int i = 0; i < n; i++) {
            if(maxArr[i] - minArr[i] <= k){
                return i;
            }
        }

        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna