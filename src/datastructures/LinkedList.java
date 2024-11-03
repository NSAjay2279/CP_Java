package datastructures;

public class LinkedList {
    public static class Node {
        int data;
        Node link;
    }

    public static Node del(Node q, int num) {
        Node r, temp, s;
        r = q;
        s = new Node();
        while(r.link != null) {
            if (r.data == num) {
                break;
            }
            s = r;
            r = r.link;
        }
        if (r.link == null) {
            if (r.data == num) {
                if (s.link == null) {
                    q = null;
                    return q;
                }
                s.link = null;
            }
            else {
                System.out.println("Element " + num + " not found");
            }
            return q;
        }
        s.link = r.link;
        if (r.data == num) {
            if (q == r) {
                q = r.link;
                return q;
            }
            return q;
        }

        else {
            System.out.println("Element " + num + " not found");
            return q;
        }
    }

    public static void display(Node q) {
        while (q != null) {
            System.out.print(q.data + " ");
            q = q.link;
        }
        System.out.println();
    }

    public static Node addAfter(Node q, int loc, int num) {
        Node temp, r, s;
        temp = new Node();
        r = new Node();
        temp.data = num;
        r = q;
        for (int i = 1; i <= loc; i++) {
            if (i == loc) {
                temp.link = r.link;
                r.link = temp;
                break;
            }
            r = r.link;
        }
        return q;
    }

    public static Node addAtBeg(Node q, int num) {
        Node temp = new Node();
        temp.data = num;
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
        p = del(p, 60);
        p = del(p, 77);
        display(p);
        p = del(p, 17);
        p = del(p, 25);
        p = del(p, 88);
        p = del(p, 89);
        p = del(p, 30);
        p = del(p, 14);
        display(p);
        p = del(p, 41);
        display(p);
        System.out.println("No. of elements in the linked List = " + count(p));
    }
}