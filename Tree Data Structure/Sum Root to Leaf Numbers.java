/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) {
 * val = x;
 * left=null;
 * right=null;
 * }
 * }
 */

public class Solution {

    // "Our country made a promise, but you cannot trust a liar
    // So grab a book, and step into the choir"
    // - Oh John, Far Cry 5

    public void recursion(ArrayList<Integer> sum, ArrayList<Integer> currValue, TreeNode iter) {
        // base condition 1
        if (iter.left == null && iter.right == null) {
            currValue.add(iter.val);
            int num = 0;
            for (int elem : currValue) {
                num = ((num * 10) + elem) % 1003;
            }
            // System.out.println("Curr num formed "+num);
            sum.set(0, (sum.get(0) + num) % 1003);
            return;
        }

        // no base condition
        currValue.add(iter.val);
        if (iter.left != null)
            recursion(sum, new ArrayList<Integer>(currValue), iter.left);
        if (iter.right != null)
            recursion(sum, new ArrayList<Integer>(currValue), iter.right);

        return;
    }

    public int sumNumbers(TreeNode A) {
        ArrayList<Integer> sum = new ArrayList<Integer>();
        sum.add(0);
        recursion(sum, new ArrayList<Integer>(), A);
        return sum.get(0) % 1003;
    }
}
