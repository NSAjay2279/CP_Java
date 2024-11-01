package datastructures;

public class PolynomialMultiplication {
    static int MAX = 6;

    public static class Term {
        int coeff, exp;
    }

    public static class Poly {
        Term[] t = new Term[MAX];
        int noofterms;

        Poly() {
            noofterms = 0;
            for (int i = 0; i < MAX; i++) {
                t[i] = new Term();
                t[i].coeff = 0;
                t[i].exp = 0;
            }
        }
    }

    public static void display(Poly p) {
        boolean flag = false;
        int i;
        for (i = 0; i < p.noofterms; i++) {
            if (p.t[i].exp != 0)
                System.out.print(p.t[i].coeff + "x^" + p.t[i].exp + " + ") ;
            else {
                System.out.print(p.t[i].coeff) ;
                flag = true;
            }
        }
        if (!flag)
            System.out.println("\b\b") ;
        System.out.println() ;
    }

    public static void polyAppend(Poly p, int c, int e) {
        p.t[p.noofterms].coeff = c;
        p.t[p.noofterms].exp = e;
        (p.noofterms)++;
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
                }
                else {
                    p3.t[p3.noofterms].coeff = p1.t[i].coeff;
                    p3.t[p3.noofterms].exp = p1.t[i].exp;
                    i++;
                }
            }
            else {
                p3.t[p3.noofterms].coeff = p2.t[j].coeff;
                p3.t[p3.noofterms].exp = p2.t[j].exp;
                j++;
            }
        }
        return p3;
    }

    public static Poly polyMul(Poly p1, Poly p2) {
        int coeff, exp ;
        Poly temp, p3 ;
        temp = new Poly();
        p3 = new Poly();
        if (p1.noofterms != 0 && p2.noofterms != 0) {
            int i ;
            for (i = 0 ; i < p1.noofterms ; i++) {
                int j;
                Poly p = new Poly();
                for (j = 0 ; j < p2.noofterms ; j++) {
                    coeff = p1.t[i].coeff * p2.t[j].coeff ;
                    exp = p1.t[i].exp + p2.t[j].exp ;
                    polyAppend(p, coeff, exp) ;
                }
                if (i != 0) {
                    p3 = polyAdd(temp, p) ;
                    temp = p3;
                }
                else
                    temp = p;
            }
        }
        return p3 ;
    }

    public static void main(String[] args) {
        Poly p1, p2, p3;
        p1 = new Poly();
        p2 = new Poly();
        p3 = new Poly();
        polyAppend(p1, 1, 4);
        polyAppend(p1, 2, 3);
        polyAppend(p1, 2, 2);
        polyAppend(p1, 2, 1);
        polyAppend(p2, 2, 3);
        polyAppend(p2, 3, 2);
        polyAppend(p2, 4, 1);
        p3 = polyMul(p1, p2);
        System.out.println("First polynomial:");
        display(p1);
        System.out.println("Second polynomial:");
        display(p2);
        System.out.println("Resultant polynomial:");
        display(p3);
    }
}