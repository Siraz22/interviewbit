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

    // "All is stone
    // And all is soft inside"
    // - all is soft inside, AURORA

    public void recursion(ArrayList<ArrayList<Integer>> answer, ArrayList<Integer> currValue, TreeNode iter,
            int sumReq) {
        // base condition 1
        if (iter.left == null && iter.right == null) {
            currValue.add(iter.val);
            int localSum = 0;
            for (int elem : currValue) {
                localSum += elem;
            }
            // System.out.println("Curr num formed "+num);
            if (localSum == sumReq) {
                answer.add(currValue);
            }
            return;
        }

        // no base condition
        currValue.add(iter.val);
        if (iter.left != null)
            recursion(answer, new ArrayList<Integer>(currValue), iter.left, sumReq);
        if (iter.right != null)
            recursion(answer, new ArrayList<Integer>(currValue), iter.right, sumReq);

        return;
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int sumReq) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        recursion(answer, new ArrayList<Integer>(), A, sumReq);
        return answer;
    }
}
