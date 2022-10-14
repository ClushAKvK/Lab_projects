package com.company.Saska.task2.methods;

import com.company.Saska.task2.objects.Dot;

public class LocalSmoothingOfData {

    private static int k = 4;

    public static double[] start(Dot [] dots) {
        double [] resultY = new double[dots.length];
        for (int i = 0; i < dots.length; i++) resultY[i] = dots[i].y;
        for (int i = 0; i < dots.length; i++) {
            Dot [] tempDots = new Dot[2 * k + 1];
            for (int j = i - k, t = 0; j <= i + k; j++) {
                if (j < 0) tempDots[t] = dots[0];
                else if (j >= dots.length) tempDots[t] = dots[dots.length - 1];
                else tempDots[t] = dots[j];
                t++;
            }
            resultY[i] = LeastSquare.run(tempDots, tempDots.length / 2);
        }
        return resultY;
    }
}
