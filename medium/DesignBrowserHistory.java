public class DesignBrowserHistory {

    static class Node {
        String url;
        Node prev;
        Node next;

        Node(String url) {
            this.url = url;
        }
    }

    private Node current;

    public DesignBrowserHistory(String homepage) {
        current = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);

        current.next = newNode;
        newNode.prev = current;

        // Remove forward history
        current = newNode;
    }

    public String back(int steps) {
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }

        return current.url;
    }

    public String forward(int steps) {
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }

        return current.url;
    }

    public static void main(String[] args) {

        DesignBrowserHistory browser =
                new DesignBrowserHistory("google.com");

        browser.visit("youtube.com");
        browser.visit("github.com");
        browser.visit("leetcode.com");

        System.out.println(
                "Back 1: " + browser.back(1)
        );

        System.out.println(
                "Back 1: " + browser.back(1)
        );

        System.out.println(
                "Forward 1: " + browser.forward(1)
        );

        browser.visit("openai.com");

        System.out.println(
                "Forward 2: " + browser.forward(2)
        );

        System.out.println(
                "Back 2: " + browser.back(2)
        );
    }
}
