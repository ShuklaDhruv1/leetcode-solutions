import java.util.*;

public class SerializeAndDeserializeBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current == null) {
                result.append("null,");
                continue;
            }

            result.append(current.val).append(",");

            queue.offer(current.left);
            queue.offer(current.right);
        }

        return result.toString();
    }

    public static TreeNode deserialize(String data) {

        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] values = data.split(",");

        TreeNode root =
                new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty() &&
               index < values.length) {

            TreeNode current = queue.poll();

            if (!values[index].equals("null")) {
                current.left =
                        new TreeNode(
                                Integer.parseInt(values[index])
                        );

                queue.offer(current.left);
            }

            index++;

            if (index < values.length &&
                !values[index].equals("null")) {

                current.right =
                        new TreeNode(
                                Integer.parseInt(values[index])
                        );

                queue.offer(current.right);
            }

            index++;
        }

        return root;
    }

    public static void printTree(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current == null) {
                continue;
            }

            System.out.print(current.val + " ");

            queue.offer(current.left);
            queue.offer(current.right);
        }

        System.out.println();
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String data = serialize(root);

        System.out.println("Serialized: " + data);

        TreeNode newRoot = deserialize(data);

        System.out.print("Deserialized Tree: ");
        printTree(newRoot);
    }
}
