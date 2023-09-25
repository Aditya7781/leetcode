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
    public boolean isCompleteTree(TreeNode root) {
       if(root==null){
           return true;
       }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        TreeNode front;
        
        boolean flag = false;
        
        while(!queue.isEmpty()){
            front = queue.poll();
            if (flag && (front.left != null || front.right != null)) {
                return false;
            }
             if (front.left == null && front.right != null) {
                return false;
            }
             if (front.left != null) {
                queue.add(front.left);
            } else {
                flag = true;
            }
            if (front.right != null) {
                queue.add(front.right);
            } else {
                flag = true;
            }
        }
        return true;
    }
}