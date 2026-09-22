public class ValidateBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {

        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean validate(
            TreeNode root,
            long min,
            long max) {

        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return validate(root.left, min, root.val) &&
               validate(root.right, root.val, max);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(
            "Is Valid BST: " + isValidBST(root)
        );
    }
}
