public class CountGoodNodesInBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int goodNodes(TreeNode root) {

        return dfs(root, root.val);
    }

    public static int dfs(TreeNode root, int maxValue) {

        if (root == null) {
            return 0;
        }

        int count = 0;

        if (root.val >= maxValue) {
            count = 1;
            maxValue = root.val;
        }

        count += dfs(root.left, maxValue);
        count += dfs(root.right, maxValue);

        return count;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(3);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        int result = goodNodes(root);

        System.out.println("Good Nodes: " + result);
    }
}
