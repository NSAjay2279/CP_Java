package datastructures;

public class ReverseLinkedList {
    public static boolean count = true;

    public static class Node {
        int data;
        Node link;
    }

    public static void display(Node q) {
        while(q != null) {
            System.out.print(q.data + " ");
            q = q.link;
        }
        System.out.println();
    }

    public static Node reverse(Node q) {
        Node r, s, t, w;
        t = null;
        s = null;
        w = q;
        if (count) {
            while (w.link != null)
                w = w.link;
            count = false;
        }
        while (q.link != null) {
            r = null;
            r = q;
            while (r.link != null) {
                s = r;
                r = r.link;
            }
            r.link = s;
            if (r.data == w.data)
                t = r;
            s.link = null;
        }
        return t;
    }

    public static Node addAtBeg(Node q, int num) {
        Node temp;
        temp = new Node();
        temp.data = num;
        temp.link = q;
        q = temp;
        return q;
    }

    public static void main(String[] args) {
        Node p;
        p = null;
        p = addAtBeg(p, 7); p = addAtBeg(p, 43); p = addAtBeg(p, 17);
        p = addAtBeg(p, 3); p = addAtBeg(p, 23); p = addAtBeg(p, 5);
        display(p);
        p = reverse(p);
        display(p);
    }
}
