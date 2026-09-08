class Solution {
    static double M = 1e9+7;

    static int[] mem = new int[2001];

    static int[] prev;

    public int distinctSubseqII(String s) {
        int n = s.length();

        Arrays.fill(mem, -1);
        prev = new int[n+1];

        int[] last = new int[26];

        for (int i = 1; i <=n; i++) {
            int idx = s.charAt(i-1) - 'a';
            prev[i] = last[idx];
            last[idx] = i;
        }
        return (int)((solve(n) - 1 +M) % M);
    }

    public static int solve(int n) {
        if(n == 0) return 1;
        if(mem[n] != -1) return mem[n];

        double total = (2*solve(n-1)) % M;

        if (prev[n] != 0){
            int duplicate = solve(prev[n] - 1);
            total = (total - duplicate + M) % M;
        }

        return mem[n] = (int)total;
    }
    
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna