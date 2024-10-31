package datastructures;

public class PolynomialAddition {
    static final int MAX = 10;

    public static class Term {
        int coEff;
        int exp;
    }

    public static class Poly {
        Term[] t = new Term[10];
        int noOfTerms;

        Poly() {
            int i;
            noOfTerms = 0;
            for (i = 0; i < MAX; i++) {
                t[i] = new Term();
                t[i].coEff = 0;
                t[i].exp = 0;
            }
        }
    }

    public static void main(String[] args) {
        Poly p1 = new Poly();
        Poly p2 = new Poly();
        Poly p3 = new Poly();
        polyAppend(p1, 1, 7);
        polyAppend(p1, 2, 6);
        polyAppend(p1, 3, 5);
        polyAppend(p1, 4, 4);
        polyAppend(p1, 5, 2);
        polyAppend(p2, 1, 4);
        polyAppend(p2, 1, 3);
        polyAppend(p2, 1, 2);
        polyAppend(p2, 1, 1);
        polyAppend(p2, 2, 0);
        p3 = polyAdd(p1, p2);
        System.out.println("First polynomial:");
        display(p1);
        System.out.println("Second polynomial:");
        display(p2);
        System.out.println("Resultant polynomial:");
        display(p3);
    }

    public static void polyAppend(Poly p, int c, int e) {
        p.t[p.noOfTerms].coEff = c;
        p.t[p.noOfTerms].exp = e;
        (p.noOfTerms)++;
    }

    public static void display(Poly p) {
        boolean flag = false;
        int i;
        for (i = 0; i < p.noOfTerms; i++) {
            if (p.t[i].exp != 0)
                System.out.print(p.t[i].coEff + "x^" + p.t[i].exp + " + ");
            else {
                System.out.print(p.t[i].coEff);
                flag = true;
            }
        }
        if (!flag)
            System.out.print("\b\b ");
        System.out.println();
    }

    public static Poly polyAdd(Poly p1, Poly p2) {
        int i, j, c;
        Poly p3 = new Poly();
        if (p1.noOfTerms > p2.noOfTerms)
            c = p1.noOfTerms;
        else
            c = p2.noOfTerms;
        for (i = 0, j = 0; i < c; p3.noOfTerms++) {
            if (p1.t[i].coEff == 0 && p2.t[j].coEff == 0)
                break;
            if (p1.t[i].exp >= p2.t[j].exp) {
                if (p1.t[i].exp == p2.t[j].exp) {
                    p3.t[p3.noOfTerms].coEff = p1.t[i].coEff + p2.t[j].coEff;
                    p3.t[p3.noOfTerms].exp = p1.t[i].exp;
                    i++;
                    j++;
                } else {
                    p3.t[p3.noOfTerms].coEff = p1.t[i].coEff;
                    p3.t[p3.noOfTerms].exp = p1.t[i].exp;
                    i++;
                }
            } else {
                p3.t[p3.noOfTerms].coEff = p2.t[j].coEff;
                p3.t[p3.noOfTerms].exp = p2.t[j].exp;
                j++;
            }
        }
        return p3;
    }
}
