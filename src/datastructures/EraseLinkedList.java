package datastructures;

class EraseLinkedList {

    // Define the Node class (equivalent to struct node in C)
    static class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    // Method to append a node at the end of the linked list
    public static void append(Node[] head, int num) {
        Node temp = head[0];

        if (head[0] == null) {
            // If the list is empty, create the first node
            head[0] = new Node(num);
        } else {
            // Go to the last node
            while (temp.link != null) {
                temp = temp.link;
            }
            // Add a node at the end
            temp.link = new Node(num);
        }
    }

    // Method to concatenate two linked lists
    public static void concat(Node[] firstList, Node[] secondList) {
        Node temp;

        // If the first list is empty, the second list becomes the first
        if (firstList[0] == null) {
            firstList[0] = secondList[0];
        } else {
            if (secondList[0] != null) {
                temp = firstList[0];  // Point to the first list

                // Traverse the first list to the last node
                while (temp.link != null) {
                    temp = temp.link;
                }

                // Concatenate the second list after the first list
                temp.link = secondList[0];
            }
        }
    }

    // Method to display the contents of the linked list
    public static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.link;
        }
        System.out.println();
    }

    // Method to count the number of nodes in the linked list
    public static int count(Node head) {
        int c = 0;
        while (head != null) {
            head = head.link;
            c++;
        }
        return c;
    }

    // Method to erase all the nodes from a linked list
    public static Node erase(Node head) {
        Node temp;
        // Traverse till the end erasing each node
        while (head != null) {
            temp = head;
            head = head.link;
            temp = null; // In Java, memory is managed by garbage collection, so we just nullify the reference
        }
        return null;
    }

    public static void main(String[] args) {
        // Initialize the linked lists
        Node[] firstList = {null};  // Using an array to pass by reference
        Node[] secondList = {null};

        // Append elements to the first list
        append(firstList, 1);
        append(firstList, 2);
        append(firstList, 3);
        append(firstList, 4);

        // Display the first list
        System.out.println("First List:");
        display(firstList[0]);
        System.out.println("No. of elements in first Linked List = " + count(firstList[0]));

        // Append elements to the second list
        append(secondList, 5);
        append(secondList, 6);
        append(secondList, 7);
        append(secondList, 8);

        // Display the second list
        System.out.println("Second List:");
        display(secondList[0]);
        System.out.println("No. of elements in second Linked List = " + count(secondList[0]));

        // Concatenate the second list to the first
        concat(firstList, secondList);

        // Display the concatenated list
        System.out.println("Concatenated List:");
        display(firstList[0]);

        // Erase all nodes from the concatenated list
        System.out.println("No. of elements before erasing = " + count(firstList[0]));
        firstList[0] = erase(firstList[0]);
        System.out.println("No. of elements after erasing = " + count(firstList[0]));
    }
}
