package Matrix;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Set {
    protected Matrix[] matrices = new Matrix[10];

    public Set(Scanner scanner) {
        for (int i = 0; i < matrices.length; ++i) {
            matrices[i] = new Matrix(scanner);
        }
    }

    public Set(Random random) {
        char ch;
        int m, n;
        for (int i = 0; i < matrices.length; ++i) {
            ch = (char) (random.nextInt(26) + 'A');
            n = random.nextInt(4) + 2;
            m = random.nextInt(4) + 2;
            matrices[i] = new Matrix(ch, n, m, random);
        }
        Arrays.sort(matrices);
    }

    @Override
    public String toString() {
        String str = "";
        for (Matrix matrix : matrices) {
            str += matrix;
            str += "____________\n";
        }
        return str;
    }

    public void print() {
        System.out.println("Set of all types:");
        System.out.println(this);
    }

    /**
     * @param type default, diag, unit, zero
     */
    public void print(String type) {
        System.out.println("Set of " + type + " type:");
        for (Matrix matrix : matrices) {
            if (matrix.getType().equals(type)) {
                System.out.print(matrix);
                System.out.println("____________");
            }
        }
    }
}
