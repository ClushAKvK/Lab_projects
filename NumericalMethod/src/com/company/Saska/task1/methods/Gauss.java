package com.company.Saska.task1.methods;

import com.company.Saska.task1.objects.Matrix;

public class Gauss {

    public static void straightRunning(Matrix a) throws Exception {
        for (int i = 0; i < a.getRank() - 1; i++) {
            a.toNormalView(i);
            for (int j = i + 1; j < a.getRank(); j++) {
                if (a.get(j, i) == 0.0) continue;
                a.divideLineBy(j, a.get(j, i));
                a.multipleLineBy(j, a.get(i, i));
                a.subtractLine(j, i);
            }
        }

        if (a.get(a.getRank() - 1, a.getRank() - 1) == 0) {
            if (a.get(a.getRank() - 1, a.getRank()) == 0)
                throw new IllegalArgumentException("This system have many solutions");
            throw new IllegalArgumentException("This system is unsolvable");
        }
    }


    public static void reverseRunning(Matrix a) {
        for (int i = a.getRank() - 1; i > 0; i--) {
            a.toNormalView(i);
            for (int j = i - 1; j >= 0; j--) {
                if (a.get(j, i) == 0.0) continue;
                a.divideLineBy(j, a.get(j, i));
                a.multipleLineBy(j, a.get(i, i));
                a.subtractLine(j, i);
            }
        }
    }


    public static double[] resultRunning(Matrix a) {
        for (int i = 0; i < a.getRank(); i++) {
            a.divideLineBy(i, a.get(i, i));
        }

        double [] x = new double[a.getRank()];
        for (int i = 0; i < a.getRank(); i++) {
            x[i] = a.get(i, a.getRank());
        }
        return x;
    }


    public static double[] calcDiscrepancy(double [][] A, double [] x, double [] b) {
        double [] discrepancy = new double[x.length];
        for (int i = 0; i < discrepancy.length; i++) {
            for (int j = 0; j < discrepancy.length; j++) {
                discrepancy[i] += A[i][j] * x[j];
            }
        }

        //Program.printWithRound(discrepancy);

        for (int i = 0; i < discrepancy.length; i++) {
            discrepancy[i] = b[i] - discrepancy[i];
        }

        return discrepancy;
    }
}
