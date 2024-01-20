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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int maxFrequency = 0;

        dfs(root, frequencyMap);

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int sum = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFrequency) {
                result.clear();
                result.add(sum);
                maxFrequency = frequency;
            } else if (frequency == maxFrequency) {
                result.add(sum);
            }
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    private int dfs(TreeNode node, Map<Integer, Integer> frequencyMap) {
        if (node == null) {
            return 0;
        }

        int leftSum = dfs(node.left, frequencyMap);
        int rightSum = dfs(node.right, frequencyMap);

        int subtreeSum = leftSum + rightSum + node.val;
        frequencyMap.put(subtreeSum, frequencyMap.getOrDefault(subtreeSum, 0) + 1);

        return subtreeSum;
    }
}
