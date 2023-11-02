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
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        average(root);
        return count;
    }
    private int[] average(TreeNode root){
        if(root.left==null && root.right==null){
            count++;
            return new int[]{root.val,1};
        }
        int sum=0,c=0;
        if(root.left!=null){
            int[] p = average(root.left);
            sum += p[0];
            c += p[1];
        }
        if(root.right!=null){
            int[] q = average(root.right);
            sum += q[0];
            c += q[1];
        }
        sum+=root.val;
        c++;
        if(root.val == ((sum)/(c)) ){
            count++;
        }
        return new int[]{sum,c};
    }
}