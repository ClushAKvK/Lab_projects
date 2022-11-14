package com.company.Saska.task5.methods;

import com.company.Saska.task5.objects.Function;

public class Newton {

    public static double run(double B, double eps, Function func) {
        double t;
        double x = B;
        //double lastX;
        do {
            //lastX = x;
            t = func.getValueIn(x) / func.getFirstDifferentiateIn(x);
            x -= t;

        } while (Math.abs(t) > eps || func.getValueIn(x) > eps);

        //Math.abs(func.getValueIn(lastX) - func.getValueIn(x))

        return x;
    }
}
