
public class BrowserHistoryPractice {

    private static class Node {
        String url;
        Node previous;
        Node next;

        Node(String url) {
            this.url = url;
        }
    }

    private Node current;

    public BrowserHistoryPractice(String homepage) {
        current = new Node(homepage);
    }

    public void visit(String url) {
        Node newPage = new Node(url);

        current.next = newPage;
        newPage.previous = current;

        // New visit ke baad forward history clear ho jaati hai
        current = newPage;
    }

    public String back(int steps) {
        while (steps > 0 && current.previous != null) {
            current = current.previous;
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
        BrowserHistoryPractice browser =
                new BrowserHistoryPractice("google.com");

        browser.visit("youtube.com");
        browser.visit("github.com");
        browser.visit("leetcode.com");

        System.out.println(browser.back(1));
        System.out.println(browser.back(1));
        System.out.println(browser.forward(1));

        browser.visit("stackoverflow.com");

        System.out.println(browser.forward(2));
        System.out.println(browser.back(2));
    }
}
