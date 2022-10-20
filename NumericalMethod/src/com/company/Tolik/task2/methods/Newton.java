package com.company.Tolik.task2.methods;


import com.company.Tolik.task2.objects.Dot;

public class Newton {

    public static double run(double x, Dot[] dots) {
        double P = 0;
        double mult = 1;
        for (int i = 1; i < dots.length; i++) {
            double divDiff = dividedDifference(dots, 0, i);
            if (i != 0) mult *= (x - dots[i - 1].x);
            P += divDiff * mult;
        }
        return P;
    }

    public static double dividedDifference(Dot[] dots, int start, int end) {
        if (end - start == 0) return dots[start].y / dots[start].x;
        else if (end - start == 1) {
            return (dots[end].y - dots[start].y) / (dots[end].x - dots[start].x);
        }

        double diff = dividedDifference(dots, start + 1, end) - dividedDifference(dots, start, end - 1);
        return diff / (dots[end].x - dots[start].x);
    }
}
