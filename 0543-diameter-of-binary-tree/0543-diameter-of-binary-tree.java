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
    int result = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return result - 1;
    }

    public int solve(TreeNode root) {
        if (root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        int temp = Math.max(left, right) + 1;
        int ans = Math.max(left + right + 1, temp);
        result = Math.max(result, ans);

        return temp;
    }
}
