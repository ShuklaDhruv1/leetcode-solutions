public class LowestCommonAncestorBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q) {

        while (root != null) {

            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } 
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } 
            else {
                return root;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;
        TreeNode q = root.right;

        TreeNode result = lowestCommonAncestor(root, p, q);

        System.out.println(
                "Lowest Common Ancestor: " + result.val
        );
    }
}
