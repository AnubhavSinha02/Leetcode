class Solution {
    public boolean isValid(String s) {
        boolean result = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if (c == ')' && (stack.isEmpty() || stack.pop() != '('))
                return false;
            if (c == '}' && (stack.isEmpty() || stack.pop() != '{'))
                return false;
            if (c == ']' && (stack.isEmpty() || stack.pop() != '['))
                return false;
        }
        if (!stack.isEmpty())
            return false;
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna