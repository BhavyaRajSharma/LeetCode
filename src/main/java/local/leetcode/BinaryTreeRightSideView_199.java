package local.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView_199 {
    private List<Integer> rightViewNodes= new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        rightSideView(root, 0);
        return rightViewNodes;
    }
    private void rightSideView(TreeNode root, int index) {
        if(root==null) return;
        if(index>=rightViewNodes.size()){
            System.out.println(index+" "+rightViewNodes.size());
            rightViewNodes.add(root.val);
        }
        rightSideView(root.right, index+1);
        rightSideView(root.left, index+1);
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
