package local.leetcode;

public class DeleteNodeinaBST_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val > key){

            root.left=deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right=deleteNode(root.right, key);
        }
        else{
            if(root.left == null) root=root.right;
            else if(root.right == null) root=root.left;
            else {
                TreeNode minNode= finLastNode(root.right);
                root.val = minNode.val;
                root.right=deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }
    private TreeNode finLastNode(TreeNode root){
        while (root.left!=null) root= root.left;
        return root;
    }
    public class TreeNode {
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
