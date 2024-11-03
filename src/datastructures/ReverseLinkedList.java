package datastructures;

public class ReverseLinkedList {

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
        Node r,s,x;
        int[] list = new int[6];
        r = q;
        int i = 0;
        while(r.link != null) {
             = r.link;
            r = r.link;
        }
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
