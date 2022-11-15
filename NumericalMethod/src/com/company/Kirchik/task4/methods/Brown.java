package com.company.Kirchik.task4.methods;

import com.company.Saska.task4.objects.Function;

import java.util.HashSet;
import java.util.Set;

public class Brown {

    public static Set<Double> run(Function function1, Function function2, double x0, double y0, double eps) {
        double x = x0, lastX;
        double y = y0, lastY;
        double check;

        double lastP = 1, lastQ = 1;


        if (!convergenceIs(x0, y0, function1, function2)) {
            return null;
        }

        do {

            lastX = x;
            lastY = y;

            double tempX = lastX - (function1.getValueIn(lastX, lastY) / function1.getFirstDifferentiateIn(lastX, lastY, "x"));

            double q = (function2.getValueIn(tempX, lastY) * function1.getFirstDifferentiateIn(lastX, lastY, "x")) /
                    (function1.getFirstDifferentiateIn(lastX, lastY, "x") * function2.getFirstDifferentiateIn(lastX, lastY, "y") -
                            function1.getFirstDifferentiateIn(lastX, lastY, "y") * function2.getFirstDifferentiateIn(tempX, lastY, "x"));

            double p = function1.getValueIn(lastX, lastY) - q * function1.getFirstDifferentiateIn(lastX, lastY, "y") /
                    function1.getFirstDifferentiateIn(lastX, lastY, "x");

            x = lastX - p;
            y = lastY - q;


            check = Math.max(Math.abs(lastP), Math.abs(lastQ));

            lastP = p;
            lastQ = q;

        } while (check > eps);

        Set<Double> ans = new HashSet<>();
        ans.add(x); ans.add(y);

        return ans;
    }

    public static boolean convergenceIs(double x0, double y0, Function func1, Function func2) {
        double checkX = Math.abs(func1.getFirstDifferentiateIn(x0, y0, "x")) +
                        Math.abs(func2.getFirstDifferentiateIn(x0, y0, "x"));

        double checkY = Math.abs(func1.getFirstDifferentiateIn(x0, y0, "y")) +
                        Math.abs(func2.getFirstDifferentiateIn(x0, y0, "y"));

        return checkX < 1 && checkY < 1 && false;
    }

}
