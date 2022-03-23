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

    // "I have heard your claims, and believe what you say.
    // We will follow you to Chinon."
    // - Man at Arms, Joan of Arc, AoE2

    void DFS(ArrayList<Integer> answer, ArrayList<Integer> temp, TreeNode iter, int toSearch) {
        if (iter == null)
            return;
        if (iter.val == toSearch) {
            temp.add(iter.val);
            answer.addAll(temp);
            return;
        }

        temp.add(iter.val);
        if (iter.left != null)
            DFS(answer, new ArrayList<Integer>(temp), iter.left, toSearch);
        if (iter.right != null)
            DFS(answer, new ArrayList<Integer>(temp), iter.right, toSearch);
        return;
    }

    public int lca(TreeNode A, int B, int C) {
        LinkedHashMap<Integer, Integer> first = new LinkedHashMap<Integer, Integer>();
        ArrayList<Integer> answer = new ArrayList<Integer>();

        DFS(answer, new ArrayList<Integer>(), A, B);
        // System.out.println("answer at main " +answer.toString());
        for (int elem : answer) {
            first.put(elem, elem);
        }
        answer = new ArrayList<Integer>();
        DFS(answer, new ArrayList<Integer>(), A, C);
        // System.out.println("answer at main " +answer.toString());

        int LCA = -1;

        for (int i = answer.size() - 1; i > -1; --i) {
            int num = answer.get(i);
            if (first.containsKey(num)) {
                LCA = num;
                break;
            }
        }

        return LCA;
    }
}
