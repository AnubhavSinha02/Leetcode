class Solution {
    int n;
    int[] prefixSum;

    public int stoneGameVIII(int[] stones) {
        n = stones.length;
        prefixSum = new int[n];
        prefixSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }
        int[] t = new int[n];
        t[n-1] = prefixSum[n-1];

        for(int i = n-2;i>=1;i--){
            int take = prefixSum[i] - t[i+1];
            int skip = t[i+1];
            t[i]= Math.max(take,skip);
        }
        return t[1];
    }

    
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna