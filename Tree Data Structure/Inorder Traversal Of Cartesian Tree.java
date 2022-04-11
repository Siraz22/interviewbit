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

    // "I love you when you're singing that song
    // And I got a lump in my throat
    // 'Cause you're gonna sing the words wrong"
    // - Vance Joy, Riptide

    public TreeNode solve(ArrayList<Integer> A, int start, int end) {

        // Base condition
        if (start > end)
            return null;

        int maxIndex = -1;
        int maxValue = -1;
        for (int i = start; i < end; ++i) {
            if (A.get(i) > maxValue) {
                maxIndex = i;
                maxValue = A.get(i);
            }
        }

        if (maxIndex == -1 && maxValue == -1)
            return null;

        TreeNode root = new TreeNode(A.get(maxIndex));
        root.left = solve(A, start, maxIndex);
        root.right = solve(A, maxIndex + 1, end);

        return root;
    }

    public TreeNode buildTree(ArrayList<Integer> A) {
        TreeNode answerRoot = solve(A, 0, A.size());
        return answerRoot;
    }
}
