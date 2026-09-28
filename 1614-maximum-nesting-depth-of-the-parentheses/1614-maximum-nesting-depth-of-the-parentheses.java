class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int counter = 0;
        for(int i =0; i< s.length(); i++) {
            if(s.charAt(i) == '('){
                counter ++;
            }
            else if(s.charAt(i) == ')'){
                counter --;
            }

            if(counter > res)
                res = counter;
        }

        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna