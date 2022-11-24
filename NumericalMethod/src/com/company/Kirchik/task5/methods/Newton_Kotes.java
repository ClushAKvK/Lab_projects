package com.company.Kirchik.task5.methods;

import com.company.Kirchik.task5.objects.Function;

public class Newton_Kotes {
    public static double run(double A, double B, double eps, Function func) {
        int n = 1; //шаг разбиения по Рунге
        double formulaN;
        double formula2N;

        do {
            n *= 2;
            formulaN = formula(A, B, n, func);
            formula2N = formula(A, B, 2 * n, func);
        } while (Math.abs(formula2N - formulaN) > eps);

        return formula2N;
    }

    public static double formula(double A, double B, double n, Function func) {
        double h = (B - A) / n;
        double integrateSum = 0;

        double lastX = A;
        for (int i = 1; i <= n; i++) {
            double x = lastX + h;
            integrateSum +=
                                (19 * func.getValueIn(lastX) +
                                 75 * func.getValueIn(lastX + h / 5) +
                                 50 * func.getValueIn(lastX + (2 * h) / 5) +
                                 50 * func.getValueIn(x - (2 * h) / 5) +
                                 75 * func.getValueIn(x - h / 5) +
                                 19 * func.getValueIn(x));
            lastX = x;
        }

        return integrateSum * (h / 288);
    }
}
