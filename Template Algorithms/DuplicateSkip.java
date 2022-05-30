//GOAL : get index of rightmost duplicate number in a sorted array
//Used in Noble Integer, Remove Consecutive Characters and Two Pointers section

public class DuplicateSkip {
    public void algorithm(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {

            // continue to skip till we reach rightmost element
            if (i < arr.length - 1 && arr[i] == arr[i + 1])
                continue;

            // the next number is not a duplicate
            System.out.println("For number " + arr[i] + " the last occuring index is " + i);
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = { -2, -2, -1, 0, 1, 1, 1, 3, 3, 4, 4 };
        DuplicateSkip algo = new DuplicateSkip();
        algo.algorithm(arr);
    }
}

// For number -2 the last occuring index is 1
// For number -1 the last occuring index is 2
// For number 0 the last occuring index is 3
// For number 1 the last occuring index is 6
// For number 3 the last occuring index is 8
// For number 4 the last occuring index is 10