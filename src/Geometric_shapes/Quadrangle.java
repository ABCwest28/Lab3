package Geometric_shapes;

import java.util.Scanner;

public class Quadrangle {
    protected static class Point {
        protected int num;
        protected float x, y;

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

        public void setX(float x) {
            this.x = x;
        }

        public void setY(float y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "num=" + num +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }

        public void setPointByConsole(Scanner scanner) {
            System.out.print("Введите x");
            x = scanner.nextFloat();
            y = scanner.nextFloat();
        }

    }
    Point[] points = new Point[4];

}
