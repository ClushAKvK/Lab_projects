package com.company.Vanish.task3.methods;

import com.company.Vanish.task3.objects.Function;

public class Newton_halfDivision {

    public static double run(double B, double eps, Function func) {
        double t;
        double x = B;
        do {
            double lastX = x;
            t = func.getValueIn(x) / func.getFirstDifferentiateIn(x);
            x -= t;

            while (Math.abs(func.getValueIn(x)) > Math.abs(func.getValueIn(lastX))) {
                x = (lastX + x) / 2;
            }

        } while (Math.abs(t) > eps);

        return x;
    }
}
