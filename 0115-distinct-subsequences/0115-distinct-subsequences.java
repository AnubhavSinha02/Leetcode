class Solution {

    static int[][] mem;

    public int numDistinct(String s, String t) {
        mem = new int[s.length()+1][t.length()+1];
        for(int[] memi : mem){
            Arrays.fill(memi, -1);
        }
        return solve(s, t, 0, 0);
    }

    public static int solve(String s, String t, int i, int j) {
        if(j == t.length())
            return mem[i][j] = 1;
        if(i == s.length())
            return mem[i][j] = 0;

        if(mem[i][j] != -1)
            return mem[i][j];


        if(s.charAt(i) == t.charAt(j)) {
            return mem[i][j] = solve(s, t, i + 1, j + 1) + solve(s, t, i + 1, j);
        }
        else
            return mem[i][j] = solve(s,t, i+1, j);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna