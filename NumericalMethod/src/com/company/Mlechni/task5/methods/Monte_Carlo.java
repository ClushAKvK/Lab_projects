package com.company.Mlechni.task5.methods;

import com.company.Mlechni.task5.objects.Function;

public class Monte_Carlo {

    public static int n = 10;

    private static double min = 0.0;
    private static double max = 1.0;

    public static double run(double start, double end, Function function) {
        double h = (end - start) / n;
        double ans = 0;

        for (int i = 0; i < n; i++) {
            double a = start + h * i;
            double b = start + h * (i + 1);

            double sigma = (Math.random() * ((max - min) + 1)) + min;
            double x = a + sigma * (b - a);

            ans += function.getValueIn(x);
        }

        return ans * h;
    }

}
