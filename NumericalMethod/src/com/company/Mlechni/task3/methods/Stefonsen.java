package com.company.Mlechni.task3.methods;

import com.company.Mlechni.task3.objects.Function;

import java.util.HashSet;
import java.util.Set;

public class Stefonsen {

    private static double n = 9;

    private static double eps = 0.0001;

    public static Set<Double> run(double A, double B, Function func) {
        Set<Double> x = new HashSet<>();

        for (int i = 0; i < n; i++) {
            double l = A + i * (B - A) / n;
            double r = A + (i + 1) * (B - A) / n;

            if (func.getValueIn(l) * func.getValueIn(r) < 0) x.add(steff(r, eps, func));
            else if (func.getValueIn(l) * func.getValueIn(r) == 0) {
                if (func.getValueIn(l) == 0) x.add(l);
                else x.add(r);
            }
        }

        return x;
    }


    public static Double steff(double right, double eps, Function func) {
        double temp;
        double x = right;
        double lastX;
        do {
            lastX = x;
            temp = Math.pow(func.getValueIn(x), 2) / (func.getValueIn(x + func.getValueIn(x)) - func.getValueIn(x));
            x -= temp;
        } while (Math.abs(func.getValueIn(lastX) - func.getValueIn(x)) > eps);
        return x;
    }

    public static Set<Double> calcDiscrepancy(Set<Double> A, Function func) {
        Set<Double> discrepancy = new HashSet<>();
        for (Double i : A) {
            discrepancy.add(func.getValueIn(i));
        }
        return discrepancy;
    }

}
