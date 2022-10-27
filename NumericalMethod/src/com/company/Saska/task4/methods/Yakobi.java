package com.company.Saska.task4.methods;

import com.company.Saska.task4.objects.Function;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Yakobi {

    public static Set<Double> run(Function func1, Function func2, double x0, double y0, double eps) {
        if (!checkConvergence(x0, y0, func1, func2)) {
            System.out.println("Условие сходимости не выполняется");
            System.exit(0);
        }

        double x = x0, lastX;
        double y = y0, lastY;
        double tempEps;

        do {
            lastX = x;
            lastY = y;

            x = func1.getValueIn(lastX, lastY);
            y = func2.getValueIn(lastX, lastY);

            tempEps = Math.max(
//                    Math.abs(func1.getValueIn(x, y) - func1.getValueIn(lastX, lastY)),
//                    Math.abs(func2.getValueIn(x, y) - func2.getValueIn(lastX, lastY))
                    Math.abs(lastX - x),
                    Math.abs(lastY - y)
            );

        } while (tempEps > eps);

        Set<Double> ans = new HashSet<>();
        ans.add(x); ans.add(y);

        return ans;
    }


    public static boolean checkConvergence(double x0, double y0, Function func1, Function func2) {
        double checkX = Math.abs(func1.getFirstDifferentiateIn(x0, y0, "x")) + Math.abs(func2.getFirstDifferentiateIn(x0, y0, "x"));
        double checkY = Math.abs(func1.getFirstDifferentiateIn(x0, y0, "y")) + Math.abs(func2.getFirstDifferentiateIn(x0, y0, "y"));
        return checkX <= 1 || checkY <= 1;
    }


    public static Set<Double> calcDiscrepancy(Set<Double> A, Function func1, Function func2) {
        Set<Double> discrepancy = new HashSet<>();
        double[] x = new double[2];
        int j = 0;
        for (Double i : A) {
            x[j] = i;
            j++;
        }
        discrepancy.add(func1.getValueIn(x[0],x[1]));
        discrepancy.add(func2.getValueIn(x[0],x[1]));
        return discrepancy;
    }

}
