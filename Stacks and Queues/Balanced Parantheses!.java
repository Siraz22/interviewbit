public class Solution {
    public int solve(String A) {
        ArrayList<Character> stack = new ArrayList<Character>();
        for (int i = 0; i < A.length(); ++i) {
            char ch = A.charAt(i);

            if (ch == '(')
                stack.add(ch);
            else {
                if (stack.size() == 0)
                    return 0;
                else {
                    // stack is not empty - hence check
                    if (stack.get(stack.size() - 1) == '(') {
                        // pop
                        stack.remove(stack.size() - 1);
                    } else {
                        stack.add(ch);
                    }
                }
            }
        }

        if (stack.size() == 0)
            return 1;
        else
            return 0;
    }
}
