package local.leetcode;

public class LowestCommonAncestorofaBinaryTree_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val==p.val || root.val == q.val)
            return root;
        TreeNode leftValue=null, rightValue=null;
        if(root.left!=null) leftValue= lowestCommonAncestor(root.left, p, q);
        if(root.right!=null) rightValue= lowestCommonAncestor(root.right, p, q);
        if(leftValue!= null && rightValue!=null)
            return root;
        if(leftValue!=null) return leftValue;
        return rightValue;
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
