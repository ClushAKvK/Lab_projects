package com.company.Saska.task2.methods;

import com.company.Saska.task2.objects.Matrix;

public class Zeidel {

    public static double converge(double[] x, double[] lastX) {
        double norm = 0;
        for (int i = 0; i < x.length; i++) {
            norm += Math.pow(x[i] - lastX[i], 2);
        }
        return Math.sqrt(norm);
    }


    public static double[] run(Matrix matrix, double eps) {

        double [] x = new double[matrix.getRank()];
        double [] lastX = new double[matrix.getRank()];

        matrix.toNormalView();
        matrix.print();
        do {
            lastX = x.clone();
            for (int i = 0; i < matrix.getRank(); i++) {
                double tempX = matrix.get(i, matrix.getRank());

                for (int j = 0; j < matrix.getRank(); j++) {
                    if (j == i) continue;
                    else if (j < i) tempX += x[j] * matrix.get(i, j);
                    else tempX += lastX[j] * matrix.get(i, j);
                }
                x[i] = tempX;
            }
        } while (converge(x, lastX) > eps);

        return x;
    }
}
