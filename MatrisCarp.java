package matris;

import java.util.Random;
import java.util.Scanner;

public class MatrisCarp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Row count of first matrix -> M : ");
        int m = input.nextInt();
        System.out.print("Column count of first matrix and row count of second matrix  -> N : ");
        int n = input.nextInt();
        System.out.print("Column count of second matrix -> P : ");
        int p = input.nextInt();

        Matris A = new Matris("A", m, n);
        Matris B = new Matris("B", n, p);

        A.init();
        B.init();

        A.show();
        B.show();

        carp(A, B).show();

    }

    private static Matris carp(Matris a, Matris b) {
        Matris C = new Matris("C", a.x, b.y);
        for (int i = 0; i < a.x; ++i) {
            for (int j = 0; j < b.y; ++j) {
                for (int k = 0; k < b.x; ++k) {
                    C.matris[i][j] += a.matris[i][k] * b.matris[k][j];
                }
            }
        }
        return C;
    }

    public static class Matris {

        private final Random r;
        private final int x, y;
        private final String name;
        private final int[][] matris;

        public Matris(String name, int x, int y) {
            this.x = x;
            this.y = y;
            this.name = name;
            r = new Random();
            matris = new int[x][y];
        }

        private void init() {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    matris[i][j] = r.nextInt(100);
                }
            }
        }

        private void show() {
            System.out.println("-------------------------");
            System.out.println(name + " Matrix :");
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    System.out.print(matris[i][j]);
                    if (j < y - 1) {
                        System.out.print(" - ");
                    }
                }
                System.out.println("");
            }
        }

    }

}
