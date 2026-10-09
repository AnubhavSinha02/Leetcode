class Solution {
    public int minInsertions(String s) {
        int result = 0;
        int count = 0;
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                count++;
                i++;
            } else if (s.charAt(i) == ')' && count > 0) {
                if (i < s.length() - 1 && s.charAt(i + 1) == ')') {
                    count--;
                    i += 2;
                } else {
                    count--;
                    result++;
                    i++;
                }
            } else if (s.charAt(i) == ')' && count == 0) {
                if (i < s.length() - 1 && s.charAt(i + 1) == ')') {
                    result++;
                    i += 2;
                } else {
                    result += 2;
                    i++;
                }
            }
        }

        if (count != 0) {
            result += 2 * count;
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna