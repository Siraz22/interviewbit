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

    // "But when the sinners find us, we won't hide
    // They'll come loud and they'll come fast
    // We shoot first and we can last"
    // - Keep Your Rifle by Your Side, Far Cry 5

    public int getHeight(TreeNode iter) {
        if (iter == null)
            return 0;
        return 1 + Math.max(getHeight(iter.left), getHeight(iter.right));
    }

    public int lastNode(TreeNode A) {
        int answer = -1;
        int leftHeight = -1;
        int rightHeight = -1;

        TreeNode iter = A;
        while (iter != null) {
            leftHeight = getHeight(iter.left);
            rightHeight = getHeight(iter.right);

            answer = iter.val;

            if (leftHeight > rightHeight) {
                // go to left
                iter = iter.left;
            } else {
                iter = iter.right;
            }
        }

        return answer;
    }
}
