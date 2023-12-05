package Matrix;

import java.util.Random;
import java.util.Scanner;

public class Matrix implements Comparable<Matrix>{
    protected char name;
    protected int n, m;
    protected int size;
    protected String type;
    protected float[][] arr;

    private Matrix(char name, int n, int m) {
        this.name = name;
        if (n >= 0) this.n = n; else this.n = -1 * n;
        if (m >= 0) this.m = m; else this.m = -1 * m;
        if (n == 0) this.n = 1;
        if (m == 0) this.m = 1;
        if (this.n > 20) this.n = 20;
        if (this.m > 20) this.m = 20;
        this.size = n * m;
        arr = new float[n][m];
    }

    public Matrix(Scanner scanner) {
        System.out.print("Name matrix: "); this.name = scanner.next().charAt(0);
        System.out.print("N(0-20): "); this.n = scanner.nextInt();
        System.out.print("M(0-20): "); this.m = scanner.nextInt();
        if (n < 0) this.n = -1 * n;
        if (m < 0) this.m = -1 * m;
        if (n == 0) this.n = 1;
        if (m == 0) this.m = 1;
        if (this.n > 20) this.n = 20;
        if (this.m > 20) this.m = 20;
        this.size = n * m;
        arr = new float[n][m];
        this.set_values(scanner);
        this.check_type();
        //this.print();
    }

    public Matrix(char name, int n, int m, Random random) {
        this(name, n, m);
        this.set_values(random);
        this.check_type();
        //this.print();
    }

    protected void set_values(Scanner scanner) {
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < this.m; ++j) {
                System.out.print(this.name + "[" + i + "][" + j + "] = ");
                arr[i][j] = scanner.nextFloat();
            }
        }
    }

    protected void set_values(Random random) {
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < this.m; ++j) {
                arr[i][j] = random.nextInt(19)-9;
            }
        }
    }

    protected void check_type() {
        if (this.n != this.m) {
            this.type = "default";
            return;
        }

        boolean is_zero, is_unit;

        if (arr[0][0] == 0) {
            is_zero = true;
            is_unit = false;
        } else if (arr[0][0] == 1) {
            is_zero = false;
            is_unit = true;
        } else {
            is_zero = false;
            is_unit = false;
        }

        for (int i = 0; i < this.n; ++i) {
            for (int j = 1; j < this.m; ++j) {
                if (i != j) {
                    if (arr[i][j] != 0) {
                        this.type = "default";
                        return;
                    }
                } else if (is_unit && arr[i][j] != 1) {
                    is_unit = false;
                } else if (is_zero && arr[i][j] != 0) {
                    is_zero = false;
                }
            }
        }

        if (is_zero) this.type = "zero";
        else if (is_unit) this.type = "unit";
        else this.type = "diag";
    }

    public void print() {
        System.out.print(this);
    }

    @Override
    public String toString() {
        String string = this.name + "(" + this.type + ", " + this.size + ")\n";
        for(float[] row : arr) {
            for(float el : row) {
                string += this.name + "[" + el + "] ";
            }
            string += "\n";
        }
        return string;
    }

    @Override
    public int compareTo(Matrix other) {
        return Integer.compare(this.size, other.size);
    }

    public String getType() {
        return this.type;
    }
}
