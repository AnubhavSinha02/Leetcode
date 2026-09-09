class Solution {
    public long countCommas(long n) {
        if(n<=999)
            return 0;

        long res = 0;
        long lower = 1000;
        long upper;
        int comma =1;

        while(lower <=n) {
            upper = lower*1000 -1;
            if(upper > n)
                upper = n;

            long countNum = upper - lower +1;
            res +=  countNum*comma;

            lower = lower*1000;
            comma++;
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna