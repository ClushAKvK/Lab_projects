package com.company.Vanish.task3.methods;

import com.company.Vanish.task3.objects.Function;

public class Newton {
    public static double run(double A, double B, double eps, Function func) {
        double t;
        double x = B;
        do {
            t = func.getValueIn(x) / func.getFirstDifferentiateIn(x);
            x -= t;
        } while (Math.abs(t) > eps);

        return x;
    }
}
