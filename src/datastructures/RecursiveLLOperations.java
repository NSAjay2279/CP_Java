package datastructures;

public class RecursiveLLOperations {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Counts the number of nodes in a linked list
    int countNodesRecursive(Node head) {
        if (head == null) {
            return 0;
        } else {
            return 1 + countNodesRecursive(head.next);
        }
    }

    // Compares two linked lists
    boolean compareLists(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1 == null || head2 == null) {
            return false;
        }
        return head1.data == head2.data && compareLists(head1.next, head2.next);
    }

    // Clones a linked list
    Node cloneList(Node head) {
        if (head == null) {
            return null;
        }
        Node newNode = new Node(head.data);
        newNode.next = cloneList(head.next);
        return newNode;
    }

    // Adds a node at the end of a linked list
    // Adds a node at the end of a linked list
    void addNodeAtEnd(Node head, int data) {
        // Base case: if the current node's next is null, it is the last node
        if (head.next == null) {
            head.next = new Node(data);
        } else {
            // Recursive case: move to the next node
            addNodeAtEnd(head.next, data);
        }
    }


    public static void main(String[] args) {
        RecursiveLLOperations list = new RecursiveLLOperations();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);

        // Count nodes
        int count = list.countNodesRecursive(list.head);
        System.out.println("Number of nodes: " + count);

        // Compare lists
        RecursiveLLOperations list2 = new RecursiveLLOperations();
        list2.head = new Node(1);
        list2.head.next = new Node(2);
        list2.head.next.next = new Node(3);

        boolean isEqual = list.compareLists(list.head, list2.head);
        System.out.println("Lists are equal: " + isEqual);

        // Clone list
        Node clonedList = list.cloneList(list.head);
        System.out.println("Cloned list: ");
        Node current = clonedList;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();

        // Add node at the end
        list.addNodeAtEnd(list.head, 4);
        System.out.println("List after adding node: ");
        current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}