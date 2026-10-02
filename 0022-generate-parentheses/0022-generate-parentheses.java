class Solution {
    public List<String> generateParenthesis(int n) {
        Stack<Character> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        return solve(n, result, stack, "");
    }

    public static List<String> solve(int n,List<String> result, Stack<Character> stack,  String str){
        if(stack.empty() && n==0){
            return result;
        }
        else if (n==0) {
            stack.pop();
             if (stack.isEmpty()) {
                 result.add(str+")");
                 return result;
             }
             solve(n, result, stack, str+")");
        }
        else  {
            Stack<Character> stack1 = (Stack<Character>) stack.clone();
            stack1.push('(');
            solve(n-1, result, stack1, str+"(");

             if (!stack.empty()) {
                 Stack<Character> stack2 = (Stack<Character>) stack.clone();
                 stack2.pop();
                 if (n>0) {
                     solve(n,result,stack2, str+")");
                 }
                 else {
                     result.add(str+")");
                     return result;
                 }
             }
         }
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna