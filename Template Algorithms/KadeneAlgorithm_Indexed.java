//GOAL : get index of the start and end index for maximum continuos subarray

public class KadeneAlgorithm_Indexed {
    public void algorithm(int[] arr) {

        int max = Integer.MIN_VALUE;
        int currSum = 0;

        int newStartIndex = 0;
        int startIndex = 0;
        int endIndex = -1;

        for (int i = 0; i < arr.length; ++i) {
            currSum += arr[i];

            if (currSum > max) {
                max = currSum;

                startIndex = newStartIndex;
                endIndex = i;
            }

            if (currSum < 0) {
                currSum = 0;

                newStartIndex = i + 1; // ignore current num, causes sum to go < 0
            }
        }

        System.out.println("start index = " + startIndex + ", end index = " + endIndex);
        // output : start index = 3, end index = 6
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        KadeneAlgorithm_Indexed algo = new KadeneAlgorithm_Indexed();
        algo.algorithm(arr);
    }
}