class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (stack.isEmpty())
                    stack.push(c);
                else {
                    stack.push(c);
                    str.append(c);
                }
            } else {
                if (stack.size() == 1) {
                    stack.pop();
                } else {
                    stack.pop();
                    str.append(c);
                }
            }
        }

        return str.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna