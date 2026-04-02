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
    int count = 0;
    int maxCount = 0;
    Integer prev = null;
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);

        if(prev == null || root.val != prev) {
            count = 1;
        } else {
            count++;
        }

        if(count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(root.val);
        } else if(count == maxCount) {
            list.add(root.val);
        }

        prev = root.val;

        inorder(root.right);
    }
}