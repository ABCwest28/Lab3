package Geometric_shapes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Quadrangle implements Comparable<Quadrangle> {
    private class Point {
        private int num;
        private float x, y;
        private float min_diag, max_diag;
        private float area;

        public Point(int num, float x, float y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
        public Point(int num) {
            this.num = num;
            this.x = 0;
            this.y = 0;
        }

        public Point(Scanner scanner, int num) {
            this.num = num;
            System.out.print("Точка №" + num + ":\n");
            System.out.print("x: "); this.x = scanner.nextFloat();
            System.out.print("y: "); this.y = scanner.nextFloat();
        }

        public Point(Random random, int num) {
            this.num = num;
            this.x = (float) random.nextInt(19) - 9;
            this.y = (float) random.nextInt(19) - 9;
        }

        public void setX(float x) {
            this.x = x;
        }

        public void setY(float y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return  "Point №" + num + "(" + this.x + ", " + this.y + ")";
        }
    }

    protected Point[] points = new Point[4];
    protected int num;
    protected float ab, bc, cd, ad;
    protected float min_diag, max_diag;
    protected float area;


    public Quadrangle(int num) {
        this.num = num;
        for (int i = 0; i < 4; ++i) {
            points[i] = new Point(i);
        }
        count_values();
    }

    public Quadrangle(Scanner scanner, int num) {
        this.num = num;
        for (int i = 0; i < 4; ++i) {
            points[i] = new Point(scanner, i);
        }
        count_values();
    }

    public Quadrangle(Random random, int num) {
        this.num = num;
        for (int i = 0; i < 4; ++i) {
            points[i] = new Point(random, i);
        }
        count_values();
    }

    public void count_values() {
        ab = (float) Math.sqrt(Math.pow(points[1].x - points[0].x, 2) + Math.pow(points[1].y - points[0].y, 2));
        bc = (float) Math.sqrt(Math.pow(points[2].x - points[1].x, 2) + Math.pow(points[2].y - points[1].y, 2));
        cd = (float) Math.sqrt(Math.pow(points[3].x - points[2].x, 2) + Math.pow(points[3].y - points[2].y, 2));
        ad = (float) Math.sqrt(Math.pow(points[3].x - points[0].x, 2) + Math.pow(points[3].y - points[0].y, 2));

        float p = (float) (0.5 * (ab + bc + cd + ad));
        this.area = (float) Math.sqrt((p - ab) * (p - bc) * (p - ab) * (p - ab));

        float ac = (float) Math.sqrt(Math.pow(points[2].x - points[0].x, 2) + Math.pow(points[2].y - points[0].y, 2));
        float bd = (float) Math.sqrt(Math.pow(points[3].x - points[1].x, 2) + Math.pow(points[3].y - points[1].y, 2));
        if (ac <= bd)   {this.min_diag = ac; this.max_diag = bd;}
        else            {this.min_diag = bd; this.max_diag = ac;}
    }

    @Override
    public int compareTo(Quadrangle other) {
        return Float.compare(this.area, other.area);
    }

    @Override
    public String toString() {
        return "Quadrangle №" + num + "\n" +
                "Area = " + area + "\n" +
                "Min_diag = " + min_diag + "\n" +
                "Max_diag = " + max_diag + "\n" +
                "points:\n" +
                Arrays.toString(points) + "\n";
    }

    public void print_lengths() {
        System.out.print("AB = " + ab + "\n");
        System.out.print("BC = " + bc + "\n");
        System.out.print("CD = " + cd + "\n");
        System.out.print("AD = " + ad + "\n");
    }

    public void print_diagonals() {
        System.out.print("Diagonals: \n" +
                this.min_diag + "\n" +
                this.max_diag + "\n");
    }

    public void print_area() {
        System.out.print("Area = " + area + "\n");
    }

}

