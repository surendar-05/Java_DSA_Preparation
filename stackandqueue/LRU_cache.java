import java.util.*;

class Node {
    public int key, val;
    public Node next, prev;

    Node() {
        key = val = -1;
        next = prev = null;
    }

    Node(int k, int value) {
        key = k;
        val = value;
        next = prev = null;
    }
}

class LRUCache {

    private Map<Integer, Node> map;
    private int cap;
    private Node head;
    private Node tail;

    private void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertAfterHead(Node node) {
        Node nextNode = head.next;
        head.next = node;
        nextNode.prev = node;
        node.prev = head;
        node.next = nextNode;
    }

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        int val = node.val;

        deleteNode(node);
        insertAfterHead(node);

        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;

            deleteNode(node);
            insertAfterHead(node);

            return;
        }

        if (map.size() == cap) {
            Node node = tail.prev;
            map.remove(node.key);
            deleteNode(node);
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAfterHead(newNode);
    }
}
