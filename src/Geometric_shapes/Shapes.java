package Geometric_shapes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Shapes {
    protected Quadrangle[] quadrangles = new Quadrangle[10];

    public Shapes(Scanner scanner) {
        for (int i = 0; i < quadrangles.length; ++i) {
            quadrangles[i] = new Quadrangle(scanner, i);
        }
        Arrays.sort(quadrangles);
    }
    public Shapes(Random random) {
        for (int i = 0; i < quadrangles.length; ++i) {
            quadrangles[i] = new Quadrangle(random, i);
        }
        Arrays.sort(quadrangles, Comparator.reverseOrder());
    }

    @Override
    public String toString() {
        return "Shapes:\n" +
                Arrays.toString(quadrangles) + "\n";
    }

    public void print() {
        System.out.print(this);
    }
    public void print(int a, int b) {
        for (Quadrangle quadrangle : quadrangles) {
            if (quadrangle.min_diag > a && quadrangle.max_diag < b) {
                System.out.println(quadrangle);
            }
        }
    }
}
