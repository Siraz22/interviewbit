public class Solution {
    public int solve(String A) {
        ArrayList<Character> arrayStack = new ArrayList<Character>();

        for (int i = 0; i < A.length(); ++i) {
            char ch = A.charAt(i);
            if (ch == '(')
                arrayStack.add(ch);
            else if (ch == ')') {
                // pop operation
                if (arrayStack.size() > 0 && arrayStack.get(arrayStack.size() - 1) == '(') {
                    arrayStack.remove(arrayStack.size() - 1);
                } else {
                    arrayStack.add(ch);
                }
            }
        }

        return arrayStack.size();
    }
}
