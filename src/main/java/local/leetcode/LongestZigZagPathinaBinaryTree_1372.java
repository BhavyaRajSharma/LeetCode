package local.leetcode;

public class LongestZigZagPathinaBinaryTree_1372 {
    private int MAX_VALUE=0;
    public int longestZigZag(TreeNode root) {
        if(root.left!=null) longestZigZag(root.left, 1, false);
        if(root.right!=null) longestZigZag(root.right, 1, true);
        return MAX_VALUE;
    }
    private void longestZigZag(TreeNode root, int value, boolean isParentLeft) {
        MAX_VALUE= Math.max(MAX_VALUE, value);
        if(isParentLeft){
            if(root.left!=null) longestZigZag(root.left, value+1, false);
            if(root.right!=null) longestZigZag(root.right, 1, true);
        }
        else{
            if(root.left!=null) longestZigZag(root.left, 1, false);
            if(root.right!=null) longestZigZag(root.right, value+1, true);
        }
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
