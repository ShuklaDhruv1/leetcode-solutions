import java.util.Stack;

public class KthSmallestElementInBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            k--;

            if (k == 0) {
                return current.val;
            }

            current = current.right;
        }

        return -1;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.right = new TreeNode(2);

        int k = 1;

        int result = kthSmallest(root, k);

        System.out.println("Kth Smallest Element: " + result);
    }
}
