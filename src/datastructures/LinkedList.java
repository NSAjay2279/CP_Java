package datastructures;

public class LinkedList {
    public static class Node {
        int data;
        Node link;
    }

    public static void addAfter(Node q, int)

    public static void addAtBeg(Node q, int num) {
        Node temp;
        temp = new Node();
        temp.data = num;
        temp.link = q;
        q = temp;
    }

    public static void append(Node q, int num) {
        Node temp, r;
        if(q == null) {
            temp = new Node();
            temp.data = num;
            temp.link = null;
            q = temp;
        }
        else {
            temp = q;
            while(temp.link!=null)
                temp = temp.link;
            r = new Node();
            r.data = num;
            r.link = null;
            temp.link = r;
        }
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
        Node p;
        p = null;
        System.out.println("No. of elements in the linked List = " + count(p));
        append(p, 14); append(p, 30); append(p, 25);
        append(p, 42); append(p, 17);
        display(p);
        addAtBeg(p, 99); addAtBeg(p, 88); addAtBeg(p, 77);
        display(p);
        addAfter(p, 3, 41); addAfter(p, 6, 89); addAfter(p, 10, 60);
        display(p);
        System.out.println("No. of elements in the linked List = " + count(p));
        del(p, 99); del(p, 42); del(p, 10);
        display(p);
        System.out.println("No. of elements in the linked List = " + count(p));
    }

}
