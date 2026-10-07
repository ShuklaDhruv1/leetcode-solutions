import java.util.*;

public class DesignInMemoryFileSystem {

    static class Node {

        Map<String, Node> children =
                new TreeMap<>();

        boolean isFile;

        StringBuilder content =
                new StringBuilder();
    }

    private Node root;

    public DesignInMemoryFileSystem() {
        root = new Node();
    }

    public List<String> ls(String path) {

        Node node = getNode(path);

        if (node.isFile) {
            String fileName =
                    path.substring(
                            path.lastIndexOf('/') + 1
                    );

            return List.of(fileName);
        }

        return new ArrayList<>(
                node.children.keySet()
        );
    }

    public void mkdir(String path) {

        getNode(path);
    }

    public void addContentToFile(
            String filePath,
            String content) {

        Node file = getNode(filePath);

        file.isFile = true;

        file.content.append(content);
    }

    public String readContentFromFile(
            String filePath) {

        Node file = getNode(filePath);

        return file.content.toString();
    }

    private Node getNode(String path) {

        if (path.equals("/")) {
            return root;
        }

        String[] parts =
                path.split("/");

        Node current = root;

        for (String part : parts) {

            if (part.isEmpty()) {
                continue;
            }

            current.children.putIfAbsent(
                    part,
                    new Node()
            );

            current =
                    current.children.get(part);
        }

        return current;
    }

    public static void main(String[] args) {

        DesignInMemoryFileSystem fs =
                new DesignInMemoryFileSystem();

        fs.mkdir("/a/b/c");

        fs.addContentToFile(
                "/a/b/c/d",
                "hello"
        );

        System.out.println(
                "Root: " + fs.ls("/")
        );

        System.out.println(
                "Path /a/b/c: " +
                fs.ls("/a/b/c")
        );

        System.out.println(
                "File Content: " +
                fs.readContentFromFile(
                        "/a/b/c/d"
                )
        );

        fs.addContentToFile(
                "/a/b/c/d",
                " world"
        );

        System.out.println(
                "Updated Content: " +
                fs.readContentFromFile(
                        "/a/b/c/d"
                )
        );
    }
}
