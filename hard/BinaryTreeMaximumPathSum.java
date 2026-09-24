public class BinaryTreeMaximumPathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int maxSum;

    public static int maxPathSum(TreeNode root) {

        maxSum = Integer.MIN_VALUE;

        findMaxPath(root);

        return maxSum;
    }

    public static int findMaxPath(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(0, findMaxPath(root.left));
        int right = Math.max(0, findMaxPath(root.right));

        int currentPath = root.val + left + right;

        maxSum = Math.max(maxSum, currentPath);

        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = maxPathSum(root);

        System.out.println(
                "Maximum Path Sum: " + result
        );
    }
}
