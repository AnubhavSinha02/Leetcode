class Solution {
    public int reverseDegree(String s) {
        char[] ch = s.toCharArray();

        int product = 0;

        for(int i = 0; i < ch.length; i++) {
            int res = (int) ch[i];
            res = res - 71 - 2*(ch[i] - 'a');
            res =res * (i+1);
            product += res;
        }

        return product;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna