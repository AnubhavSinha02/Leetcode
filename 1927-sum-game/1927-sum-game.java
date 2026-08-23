class Solution {
    public boolean sumGame(String num) {
        int[] stat = checkDiff(num);
            if((stat[2] + stat[3]) %2 != 0 )
                return true;

            return  ! (((2*stat[1]) + (9* stat[3])) == ((2*stat[0]) + (9*stat[2])));
    }

    public static int[] checkDiff(String num) {
        int lsum = 0, rsum = 0;
        int mid = num.length()/2;
        int qLeft = 0, qRight = 0;
        for(int i = 0; i < num.length(); i++) {
            if(num.charAt(i) != '?') {
                if(i < mid)
                    lsum += num.charAt(i)-'0';
                else
                    rsum += num.charAt(i)-'0';
            }
            else {
                if(i < mid)
                    qLeft++;
                else
                    qRight++;
            }
        }
        return new  int[]{lsum, rsum, qLeft, qRight};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna