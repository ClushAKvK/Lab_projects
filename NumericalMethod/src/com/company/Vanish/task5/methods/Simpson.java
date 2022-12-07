package com.company.Vanish.task5.methods;

import com.company.Vanish.task5.objects.Function;

public class Simpson {

    public static double run(double A, double B, double eps, Function func) {
        int n = 1; //шаг разбиения
        double simpsonN;
        double simpson2N;
        do {
            n *= 2;
            simpsonN = simpson(A, B, n, func);
            simpson2N = simpson(A, B, n * 2, func);
        } while (Math.abs(simpson2N - simpsonN) > eps);

        return simpson2N + (simpson2N - simpsonN) / 15;
    }

    public static double simpson(double A, double B, double n, Function func) {
        double h = (B - A) / n;
        double integrateSum = func.getValueIn(A) + func.getValueIn(B);

        double sumOfEven = 0;
        double sumOFNotEven = 0;
        double tempX = A;
        for (int i = 1; i <= n-1; i++) {
            tempX += h;
            if (i % 2 != 0) sumOFNotEven += func.getValueIn(tempX);
            else sumOfEven += func.getValueIn(tempX);
        }

        integrateSum += sumOfEven * 2 + sumOFNotEven * 4;

        return integrateSum * (h / 3);
    }

    public static double calcDiscrepancy(double x, double A, double B, Function func) {
        double value = func.getValueIn(x);
        return value * B - value * A;
    }

}
