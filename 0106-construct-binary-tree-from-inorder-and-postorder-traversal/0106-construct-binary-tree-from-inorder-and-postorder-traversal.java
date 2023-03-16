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
    /**
     * Build binary tree from inorder and postorder traversal arrays
     * @param inorder array representing inorder traversal of the binary tree
     * @param postorder array representing postorder traversal of the binary tree
     * @return root node of the binary tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Initialize indices for inorder and postorder arrays
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;
        // Call recursive helper function to build binary tree
        return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }

    /**
     * Helper function to build binary tree from inorder and postorder traversal arrays
     * @param inorder array representing inorder traversal of the binary tree
     * @param inStart starting index of inorder array
     * @param inEnd ending index of inorder array
     * @param postorder array representing postorder traversal of the binary tree
     * @param postStart starting index of postorder array
     * @param postEnd ending index of postorder array
     * @return root node of the binary tree
     */
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        // Base case
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        // Create root node of binary tree from last element of postorder array
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        // Find index of root node in inorder array
        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                k = i;
                break;
            }
        }
        // Recursively build left and right subtrees of binary tree
        root.left = buildTree(inorder, inStart, k - 1, postorder, postStart, postStart + k - (inStart + 1));
        root.right = buildTree(inorder, k + 1, inEnd, postorder, postStart + k - inStart, postEnd - 1);
        return root;
    }
}