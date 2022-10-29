package com.company.Kirchik.task3.methods;

import com.company.Kirchik.task3.objects.Function;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Newton {

    private static double n = 9;

    private static double eps = 0.01;

    public static Set<Double> run(double A, double B, Function func) {
        Set<Double> x = new HashSet<>();

        for (int i = 0; i < n; i++) {
            double left = A + i * (B - A) / n;
            double right = A + (i + 1) * (B - A) / n;

            if (func.getValueIn(left) * func.getValueIn(right) < 0) x.add(differenceNewton(right, eps, func));
            else if (func.getFirstDifferentiateIn(left) * func.getFirstDifferentiateIn(right) < 0) {
                double temp = differenceNewton(right, eps, func);
                if (func.getValueIn(temp) < eps && temp <= right) {
                    x.add(temp);
                }
            }
            else if (func.getValueIn(left) * func.getValueIn(right) == 0) {
                if (func.getValueIn(left) == 0) x.add(left);
                else x.add(right);
            }
        }

        return x;
    }


    public static Double differenceNewton(double right, double eps, Function func) {
        double temp;
        double x = right;
        double lastX;

        double h = 0.1;

        do {
            lastX = x;
            temp = (func.getValueIn(x) * h) / (func.getValueIn(x + h) - func.getValueIn(x));
            x -= temp;
            h /= 10;
        } while (Math.abs(func.getValueIn(lastX) - func.getValueIn(x)) > eps);
        return x;
    }

    public static ArrayList<Double> calcDiscrepancy(Set<Double> A, Function func) {
        ArrayList<Double> discrepancy = new ArrayList<>();
        for (Double i : A) {
            discrepancy.add(func.getValueIn(i));
        }
        return discrepancy;
    }

}
