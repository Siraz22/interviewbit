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

    // "I have no one to meet
    // And the ancient empty street's too dead for dreaming"
    // - Bob Dylan, Mr. Tambourine Man

    public int findIndex(ArrayList<Integer> A, int toSearch) {
        for (int i = 0; i < A.size(); ++i) {
            if (A.get(i) == toSearch)
                return i;
        }
        return -1;
    }

    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {

        // Base condition
        if (inorder.size() == 0 && postorder.size() == 0)
            return null;

        // INORDER = [left, root, right]
        // POSTORDER = [left, right, root]

        // 2 , [1] , 3 -> inorder
        // 2 , 3 , [1] -> postorder

        TreeNode root = new TreeNode(postorder.get(postorder.size() - 1));

        // find value in inorder
        int leftTreeSize = findIndex(inorder, root.val);

        ArrayList<Integer> leftInorder = new ArrayList<Integer>(inorder.subList(0, leftTreeSize));
        ArrayList<Integer> leftPostorder = new ArrayList<Integer>(postorder.subList(0, leftTreeSize));

        ArrayList<Integer> rightInorder = new ArrayList<Integer>(inorder.subList(1 + leftTreeSize, inorder.size()));
        ArrayList<Integer> rightPostorder = new ArrayList<Integer>(
                postorder.subList(leftTreeSize, postorder.size() - 1));

        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);

        return root;
    }
}
