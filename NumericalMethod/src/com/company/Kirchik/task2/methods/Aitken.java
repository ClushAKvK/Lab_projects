package com.company.Kirchik.task2.methods;

import com.company.Kirchik.task2.objects.Dot;

public class Aitken {

    public static double determinant(double a11, double a12, double a21, double a22) {
        return a11 * a22 - a12 * a21;
    }

    public static double calcL(double x, Dot[] dots, int start, int end) {
        if (end - start == 1) {
            double det = determinant(
                    dots[start].y, dots[start].x - x,
                    dots[end].y, dots[end].x - x
            );
            return det / (dots[end].x - dots[start].x);
        }

        double det = determinant(
                calcL(x, dots, start, end - 1), dots[start].x - x,
                calcL(x, dots, start + 1, end), dots[end].x - x
        );

        return det / (dots[end]. x - dots[start].x);
    }
}
