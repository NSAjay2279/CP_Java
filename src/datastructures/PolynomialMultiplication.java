package datastructures;

public class PolynomialMultiplication {
    static int MAX = 6;
    static int counter = 0;

    public static class Term {
        int coeff, exp;
        Term() {
            coeff = 0;
            exp = 0;
        }
    }

    public static class Poly {
        Term[] t = new Term[MAX];
        Poly() {
            for (int i = 0; i < MAX; i++) {
                t[i] = new Term();
                t[i].coeff = 0;
                t[i].exp = 0;
            }
        }

        void display() {
            for (int i = 0; i < MAX; i++) {
                if (t[i].coeff == 0 && t[i].exp == 0) {
                    System.out.print("\b\b");
                    break;
                }
                System.out.print(t[i].coeff + "x^" + t[i].exp + " + ");
            }
        }

        void polyAppend(int c, int e) {
            this.t[counter].coeff = c;
            this.t[counter].exp = e;
            counter++;
        }

        Poly polyMult(Poly p1, Poly p2) {
            int k = 0;
            for (int i = 0; i < MAX; i++) {
                if (p1.t[i].coeff == 0 && p1.t[i].exp == 0)
                    break;
                else {
                    for (int j = 0; j < MAX; j++) {
                        if (p2.t[j].coeff == 0 && p2.t[j].exp == 0)
                            break;
                        else {
                            this.t[k].coeff = p1.t[i].coeff * p2.t[j].coeff;
                            this.t[k].exp = p1.t[i].exp + p2.t[j].exp;
                            k++;
                        }
                    }
                }
            }
            for (int i = 0; i < MAX; i++) {
                if (this.t[i].coeff == 0 && this.t[i].exp == 0)
                    break;
                for (int j = i + 1; j < MAX; j++) {
                    if (this.t[j].coeff == 0 && this.t[j].exp == 0)
                        break;
                    if (this.t[i].exp == this.t[j].exp) {
                        this.t[i].coeff = this.t[i].coeff + this.t[j].coeff;
                        this.t[j].coeff = 0;
                        this.t[j].exp = 0;
                    }
                }
            }
            return this;
        }
    }

    public static void main(String[] args) {
        Poly p1 = new Poly();
        Poly p2 = new Poly();
        Poly p3 = new Poly();
        System.out.println("First polynomial:");
        p1.polyAppend(1,4);
        p1.polyAppend(2,3);
        /* p1.polyAppend(2,2);
        p1.polyAppend(2,1); */
        p1.display();
        counter = 0;
        System.out.println("\n");
        System.out.println("Second polynomial:");
        p2.polyAppend(2, 3);
        p2.polyAppend(3, 2);
        // p2.polyAppend(4, 1);
        p2.display();
        p3 = p3.polyMult(p1, p2);
        System.out.println("\n");
        System.out.println("Resultant polynomial:");
        p3.display();
    }
}