package com.company.Saska.task4.methods;

import com.company.Vanish.task4.objects.Function;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Yakobi {

    public static Set<Double> run(Function func1, Function func2, double eps) {
        double x = 1.0, lastX;
        double y = 1.0, lastY;
        double tempEps;


        do {
            lastX = x;
            lastY = y;

            x = func1.getValueIn(lastX, lastY);
            y = func2.getValueIn(lastX, lastY);

            tempEps = Math.max(
                    Math.abs(func1.getValueIn(x, y) - func1.getValueIn(lastX, lastY)),
                    Math.abs(func2.getValueIn(x, y) - func2.getValueIn(lastX, lastY))
            );

        } while (tempEps > eps);

        Set<Double> ans = new HashSet<>();
        ans.add(x); ans.add(y);

        return ans;
    }

    public static Set<Double> calcDiscrepancy(Set<Double> A, Function func1, Function func2) {
        Set<Double> discrepancy = new HashSet<>();
        double[] x =new double[2];
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
