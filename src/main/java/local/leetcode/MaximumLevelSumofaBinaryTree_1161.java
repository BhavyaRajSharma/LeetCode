package local.leetcode;

import java.util.HashMap;

public class MaximumLevelSumofaBinaryTree_1161 {
    private HashMap<Integer, Integer> maxLevelMap= new HashMap<>();
    public int maxLevelSum(TreeNode root) {
        maxLevelSum(root, 1);
        int maxLevel=0, maxLevelValue=Integer.MIN_VALUE;
        for(int i=1;i<=maxLevelMap.size();i++){
            if(maxLevelValue> maxLevelMap.get(i)){
                maxLevelValue= maxLevelMap.get(i);
                maxLevel=i;
            }
        }
        return maxLevel;
    }
    private void maxLevelSum(TreeNode root, int level) {
        if(root==null) return;
        maxLevelMap.put(level, maxLevelMap.getOrDefault(level, 0)+ root.val);
        maxLevelSum(root.left, level+1);
        maxLevelSum(root.right, level+1);
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
