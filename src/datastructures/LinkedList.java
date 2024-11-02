package datastructures;

public class LinkedList {
    public static class Node {
        int data;
        Node link;
    }

    public static Node del(Node q, int num) {
        Node old = null, temp = q;
        while (temp != null) {
            if (temp.data == num) {
                if (temp == q)
                    q = temp.link;
                else
                    old.link = temp.link;
                return q;
            }
            else {
                old = temp;
                temp = temp.link;
            }
        }
        System.out.println("Element " + num + " not found");
        return q;
    }

    public static void display(Node q) {
        while (q != null) {
            System.out.print(q.data + " ");
            q = q.link;
        }
        System.out.println();
    }

    public static Node addAfter(Node q, int loc, int num) {
        Node temp, r;
        int i;
        temp = q;
        for (i = 0; i < loc; i++) {
            temp = temp.link;
            if (temp == null) {
                System.out.println("There are less than " + loc + " elements in list");
                return q;
            }
            temp = temp.link;
        }
        r = new Node();
        r.data = num;
        r.link = temp.link;
        temp.link = r;
        return q;
    }

    public static Node addAtBeg(Node q, int num) {
        Node temp = new Node();
        temp.data = num;
        temp.link = null;
        Node r = new Node();
        r = q;
        q = temp;
        q.link = r;
        return q;
    }

    public static Node append(Node q, int num) {
        if (q == null) {
            q = new Node();
            q.data = num;
            q.link = null;
        }
        else {
            Node temp = new Node();
            temp.data = num;
            temp.link = null;
            Node r = q;
            while (r.link != null)
                r = r.link;
            r.link = temp;
        }
        return q;
    }

    public static int count(Node q) {
        int c = 0;
        while (q != null) {
            q = q.link;
            c++;
        }
        return c;
    }

    public static void main(String[] args) {
        Node p = null;
        System.out.println("No. of elements in the linked List = " + count(p));
        p = append(p, 14);
        p = append(p, 30);
        p = append(p, 25);
        p = append(p, 42);
        p = append(p, 17);
        display(p);
        p = addAtBeg(p, 99);
        p = addAtBeg(p, 88);
        p = addAtBeg(p, 77);
        display(p);
        p = addAfter(p, 3, 41);
        p = addAfter(p, 6, 89);
        p = addAfter(p, 10, 60);
        display(p);
        System.out.println("No. of elements in the linked List = " + count(p));
        p = del(p, 99);
        p = del(p, 42);
        p = del(p, 10);
        display(p);
        System.out.println("No. of elements in the linked List = " + count(p));
    }
}