import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    static class Node {

        int key;
        int value;
        int frequency;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    static class DoublyLinkedList {

        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {

            if (size == 0) {
                return null;
            }

            Node node = tail.prev;

            remove(node);

            return node;
        }
    }

    private int capacity;
    private int size;
    private int minFrequency;

    private Map<Integer, Node> nodeMap;

    private Map<Integer, DoublyLinkedList> frequencyMap;

    public LFUCache(int capacity) {

        this.capacity = capacity;
        this.size = 0;
        this.minFrequency = 0;

        nodeMap = new HashMap<>();
        frequencyMap = new HashMap<>();
    }

    public int get(int key) {

        if (!nodeMap.containsKey(key)) {
            return -1;
        }

        Node node = nodeMap.get(key);

        increaseFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        if (nodeMap.containsKey(key)) {

            Node node = nodeMap.get(key);

            node.value = value;

            increaseFrequency(node);

            return;
        }

        if (size == capacity) {

            DoublyLinkedList list =
                    frequencyMap.get(minFrequency);

            Node removed = list.removeLast();

            nodeMap.remove(removed.key);

            size--;
        }

        Node node =
                new Node(key, value);

        nodeMap.put(key, node);

        frequencyMap
                .computeIfAbsent(
                        1,
                        k -> new DoublyLinkedList()
                )
                .addFirst(node);

        minFrequency = 1;

        size++;
    }

    private void increaseFrequency(Node node) {

        int oldFrequency =
                node.frequency;

        DoublyLinkedList oldList =
                frequencyMap.get(oldFrequency);

        oldList.remove(node);

        if (oldFrequency == minFrequency &&
            oldList.size == 0) {

            minFrequency++;
        }

        node.frequency++;

        frequencyMap
                .computeIfAbsent(
                        node.frequency,
                        k -> new DoublyLinkedList()
                )
                .addFirst(node);
    }

    public static void main(String[] args) {

        LFUCache cache =
                new LFUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(
                "Get 1: " + cache.get(1)
        );

        cache.put(3, 30);

        System.out.println(
                "Get 2: " + cache.get(2)
        );

        System.out.println(
                "Get 3: " + cache.get(3)
        );

        cache.put(4, 40);

        System.out.println(
                "Get 1: " + cache.get(1)
        );

        System.out.println(
                "Get 3: " + cache.get(3)
        );

        System.out.println(
                "Get 4: " + cache.get(4)
        );
    }
}
