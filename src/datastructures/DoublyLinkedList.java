package datastructures;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    Node head;

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void addAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void addAfter(int afterData, int data) {
        Node current = head;
        while (current != null && current.data != afterData) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Element not found");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void deleteNode(int data) {
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Element not found");
            return;
        }
        if (current == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(11);
        list.append(2);
        list.append(14);
        list.append(17);
        list.append(99);
        list.display();
        System.out.println("No. of elements in the DLL = " + list.countNodes());

        list.addAtBeginning(33);
        list.addAtBeginning(55);
        list.display();
        System.out.println("No. of elements in the DLL = " + list.countNodes());

        list.addAfter(4, 66);
        list.addAfter(2, 96);
        list.display();
        System.out.println("No. of elements in the DLL = " + list.countNodes());

        list.deleteNode(55);
        list.deleteNode(2);
        list.deleteNode(99);
        list.display();
        System.out.println("No. of elements in the DLL = " + list.countNodes());
    }
}