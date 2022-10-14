package com.company.Vanish.task3.methods;

import com.company.Vanish.task3.objects.Function;

public class HalfDivision {
    public static double run(Double A, Double B, double eps, Function func) {
        double x = 0;
        do {
            x = A;
            double y = func.getValueIn(x);
            x = (A + B) / 2;
            double y1 = func.getValueIn(x);
            if (y * y1 <= 0) B = x;
            else A = x;
        } while (Math.abs(B - A) > eps);

        return x;
    }
}
