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

    // "We are not alive
    // We are surviving every time"
    // - AURORA, Home

    public void solve(ArrayList<Integer> answer,
            HashMap<Integer, TreeNode> childToParent, HashMap<Integer, Integer> visited,
            TreeNode currNode, int targetDist, int currDist) {
        // Base condition 1 - null node
        if (currNode == null)
            return;
        // Base condition 2 - node already visited
        if (visited.containsKey(currNode.val)) {
            return;
        }
        visited.put(currNode.val, 1);

        if (currDist == targetDist) {
            answer.add(currNode.val);
            return;
        } else {
            // radially outward
            solve(answer, childToParent, visited, currNode.left, targetDist, currDist + 1);
            solve(answer, childToParent, visited, currNode.right, targetDist, currDist + 1);
            solve(answer, childToParent, visited, childToParent.get(currNode.val), targetDist, currDist + 1);
        }
        return;
    }

    public ArrayList<Integer> distanceK(TreeNode A, int target, int dist) {
        HashMap<Integer, TreeNode> childToParent = new HashMap<Integer, TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> answer = new ArrayList<Integer>();

        queue.add(A);
        while (queue.size() > 0) {
            TreeNode currNode = queue.remove();
            if (currNode.left != null) {
                queue.add(currNode.left);
                childToParent.put(currNode.left.val, currNode);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
                childToParent.put(currNode.right.val, currNode);
            }
            // check if currNode is the req one
            if (currNode.val == target) {
                solve(answer, childToParent, new HashMap<Integer, Integer>(), currNode, dist, 0);
            }

        }
        return answer;
    }
}
