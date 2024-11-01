package datastructures;

public class PolynomialAddition {
    static final int MAX = 10;

    public static class Term {
        int coeff;
        int exp;
    }

    public static class Poly {
        Term[] t = new Term[MAX];
        int noofterms;

        Poly() {
            int i;
            noofterms = 0;
            for (i = 0; i < MAX; i++) {
                t[i] = new Term();
                t[i].coeff = 0;
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
        p.t[p.noofterms].coeff = c;
        p.t[p.noofterms].exp = e;
        (p.noofterms)++;
    }

    public static void display(Poly p) {
        boolean flag = false;
        int i;
        for (i = 0; i < p.noofterms; i++) {
            if (p.t[i].exp != 0)
                System.out.print(p.t[i].coeff + "x^" + p.t[i].exp + " + ");
            else {
                System.out.print(p.t[i].coeff);
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
        if (p1.noofterms > p2.noofterms)
            c = p1.noofterms;
        else
            c = p2.noofterms;
        for (i = 0, j = 0; i <= c; p3.noofterms++) {
            if (p1.t[i].coeff == 0 && p2.t[j].coeff == 0)
                break;
            if (p1.t[i].exp >= p2.t[j].exp) {
                if (p1.t[i].exp == p2.t[j].exp) {
                    p3.t[p3.noofterms].coeff = p1.t[i].coeff + p2.t[j].coeff;
                    p3.t[p3.noofterms].exp = p1.t[i].exp;
                    i++;
                    j++;
                } else {
                    p3.t[p3.noofterms].coeff = p1.t[i].coeff;
                    p3.t[p3.noofterms].exp = p1.t[i].exp;
                    i++;
                }
            } else {
                p3.t[p3.noofterms].coeff = p2.t[j].coeff;
                p3.t[p3.noofterms].exp = p2.t[j].exp;
                j++;
            }
        }
        return p3;
    }
}
