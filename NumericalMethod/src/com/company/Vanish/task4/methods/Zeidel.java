package com.company.Vanish.task4.methods;

import com.company.Vanish.task4.objects.Function;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Zeidel {

    public static List<Double> run(Function function1, Function function2, double x0, double y0, double eps) {
        double tempX = x0, lastX;
        double tempY = y0, lastY;
        double check;


        if (!convergenceIs(tempX, tempY, function1, function2)) {
            System.out.println("Условие сходимости не выполняется");
            System.exit(0);
        }

        do {
            lastX = tempX;
            lastY = tempY;

            tempX = function1.getValueIn(lastX, lastY);
            tempY = function2.getValueIn(tempX, lastY);

            check = Math.max(Math.abs(function1.getValueIn(tempX, tempY) - function1.getValueIn(lastX, lastY)),
                    Math.abs(function2.getValueIn(tempX, tempY) - function2.getValueIn(lastX, lastY)));
        } while (check > eps);

        List<Double> ans = new ArrayList<>();
        ans.add(tempX); ans.add(tempY);

        return ans;
    }


    public static boolean convergenceIs(double x0, double y0, Function func1, Function func2) {
        double checkX = Math.abs(func1.getFirstDifferentiateIn(x0, y0, "x")) +
                        Math.abs(func2.getFirstDifferentiateIn(x0, y0, "x"));

        double checkY = Math.abs(func1.getFirstDifferentiateIn(x0, y0, "y")) +
                        Math.abs(func2.getFirstDifferentiateIn(x0, y0, "y"));

        return checkX <= 1 || checkY <= 1;
    }


    public static ArrayList<Double> calcDiscrepancy(List<Double> A, Function func1, Function func2) {
        ArrayList<Double> discrepancy = new ArrayList<>();
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
