package com.company.Saska.task3.methods;

import com.company.Saska.task3.objects.Function;

import java.util.HashSet;
import java.util.Set;

import static com.company.Saska.task3.Main.Program.eps;

public class Hord {

    private static double n = 10;

    public static Set<Double> run(double A, double B, Function func) {

        Set<Double> resultX = new HashSet<>();

        for (int i = 0; i < n; i++) {
             double left = A + i * (B - A) / n;
             double right = A + (i + 1) * (B - A) / n;
             if (func.getValueIn(left) * func.getValueIn(right) < 0) {
                 resultX.add(calculateInterval(left, right, (left + right) / 2, func));
             }
             else if (func.getValueIn(left) * func.getValueIn(right) == 0) {
                if (func.getValueIn(left) == 0) resultX.add(left);
                else resultX.add(right);
             }
         }

        return resultX;
    }

    public static double calculateInterval(double A, double B, double x, Function func) {
        double F = func.getValueIn(x);
        double d2F = func.getSecondDifferentiateIn(x);

        double resultX;

        if (d2F * F > 0) {
            resultX = B;
            double x0 = A;
            double Fa = func.getValueIn(A);

            while (Math.abs(x0 - resultX) > eps) {
                x0 = resultX;
                double Fx = func.getValueIn(x0);
                resultX = x0 - Fx * (x0 - A) / (Fx - Fa);
            }
        }
        else {
            resultX = A;
            double x0 = B;
            double Fb = func.getValueIn(B);

            while (Math.abs(x0 - resultX) > eps) {
                x0 = resultX;
                double Fx = func.getValueIn(x0);
                resultX = x0 - Fx * (B - x0) / (Fb - Fx);
            }
        }

        return resultX;
    }

    public static Set<Double> calcDiscrepancy(Set<Double> A, Function func) {
        Set<Double> discrepancy = new HashSet<>();
        for (Double i : A) {
            discrepancy.add(func.getValueIn(i));
        }
        return discrepancy;
    }
}
