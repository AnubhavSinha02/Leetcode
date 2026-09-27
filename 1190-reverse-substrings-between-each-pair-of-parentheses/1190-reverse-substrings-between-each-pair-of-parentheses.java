class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();

        for(int i =0; i< s.length(); i++){
            if(s.charAt(i) != ')')
                stack.push(s.substring(i, i+1));
            else{
                StringBuilder stringBuilder = new StringBuilder();
                while(!Objects.equals(stack.peek(), "(")){
                    if(stack.peek().length() > 1){
                        stringBuilder.append(new StringBuilder(stack.pop()).reverse());
                    }
                    else {
                        stringBuilder.append(stack.pop());
                    }
                }
                stack.pop();
                stack.push(stringBuilder.toString());
            }
        }

        if(stack.size() == 1){
            return stack.pop();
        }
        else {
            StringBuilder result = new StringBuilder();
            while(!stack.empty()){
                if(stack.peek().length() > 1){
                    result.append(new StringBuilder(stack.pop()).reverse());
                }
                else{
                    result.append(stack.pop());
                }
            }

            return result.reverse().toString();
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna