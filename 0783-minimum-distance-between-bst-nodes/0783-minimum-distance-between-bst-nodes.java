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

    List<Integer> inorderNodes = new ArrayList<>();
    
    void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        inorderNodes.add(root.val);
        inorderTraversal(root.right);
    }
    
    public int minDiffInBST(TreeNode root) {
        inorderTraversal(root);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<inorderNodes.size()-1; i++){
            int dif = inorderNodes.get(i+1)-inorderNodes.get(i);
            if(min>dif)
                min=dif;
        }
        return min;
    }
}