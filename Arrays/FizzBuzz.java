public class Solution {
    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> answer = new ArrayList<String>();

        for (int i = 1; i <= A; ++i) {
            if (i % 15 == 0)
                answer.add("FizzBuzz");
            else if (i % 3 == 0)
                answer.add("Fizz");
            else if (i % 5 == 0)
                answer.add("Buzz");
            else
                answer.add(Integer.toString(i));
        }

        return answer;
    }
}
