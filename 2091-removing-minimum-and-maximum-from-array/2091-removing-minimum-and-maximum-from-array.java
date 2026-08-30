class Solution {
    public int minimumDeletions(int[] nums) {
        int min = 0;
        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[min])
                min = i;
            if (nums[i] > nums[max])
                max = i;
        }

        int minNum, maxNum;
        boolean leftTakeForMin = false;
        boolean leftTakeForMax = false;

        if (min + 1 < nums.length - min) {
            minNum = min + 1;
            leftTakeForMin = true;
        } else {
            minNum = nums.length - min;
        }

        if (max + 1 < nums.length - max) {
            maxNum = max + 1;
            leftTakeForMax = true;
        } else {
            maxNum = nums.length - max;
        }

        if (minNum < maxNum) {
            if (leftTakeForMin) {
                maxNum = solveForMax(Arrays.copyOfRange(nums, min + 1, nums.length));
            } else {
                maxNum = solveForMax(Arrays.copyOfRange(nums, 0, min));
            }
        } else {
            if (leftTakeForMax) {
                minNum = solveForMin(Arrays.copyOfRange(nums, max + 1, nums.length));
            } else {
                minNum = solveForMin(Arrays.copyOfRange(nums, 0, max));
            }
        }

        return minNum + maxNum;
    }

    private static int solveForMin(final int[] nums) {
        int min = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[min])
                min = i;
        }
        return Math.min(min + 1, nums.length - min);
    }

    private static int solveForMax(final int[] nums) {
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[max])
                max = i;
        }

        return Math.min(max + 1, nums.length - max);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna