/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        goDFS(root, 0, 0, list);
        int max = 0;
        for (List<Integer> l : list) {
            int left = l.get(0), right = l.get(l.size() - 1);
            int curr = left == right ? 1 : right - left + 1;
            max = Math.max(curr, max);
        }
        return max;
    }

    private void goDFS(TreeNode node, int row, int col, List<List<Integer>> list) {
        if (node == null) return;

        if (list.size() <= row) {
            List<Integer> l = new ArrayList<>();
            l.add(col);
            list.add(l);
        } else list.get(row).add(col);

        goDFS(node.left, row + 1, col * 2, list);
        goDFS(node.right, row + 1, col * 2 + 1, list);
    }
}