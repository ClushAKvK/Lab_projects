package com.company.Saska.task2.methods;

import com.company.Saska.task2.objects.Dot;


public class LeastSquare {

    public static double run(Dot[] dots, int idx) {
        int k = dots.length;
        double[] A = new double[k / 2 - 1];
        double[] B = new double[k / 2 - 1];

        for (int i = 0; i < k / 2 - 1; i++) {
            A[i] = calculateA(dots, i);
            B[i] = calculateB(dots, i);
        }

        return calculateT(dots[idx].x, A, B);
    }

    public static double calculateA(Dot[] dots, int j) {
        int k = dots.length;
        double sum = 0;
        for (int i = 1; i < k-1; i++) {
            sum += dots[i].y * Math.cos(j * dots[i].x);
        }
        double s1 = (double) 2 / (k);
        return s1 * sum;
    }

    public static double calculateB(Dot[] dots, int j) {
        int k = dots.length;
        double sum = 0;
        for (int i = 1; i < k-1; i++) {
            sum += dots[i].y * Math.sin(j * dots[i].x);
        }
        double s1 = (double) 2 / (k);
        return s1 * sum;
    }

    public static double calculateT(double x, double[] A, double[] B) {

        int k1 = A.length;
        double sum = 0;
        for (int i = 1; i < k1-1; i++) {
            sum += A[i] * Math.cos(i * x) + B[i] * Math.sin(i * x);
        }

        return (A[0] / 2) + A[k1 - 1] * Math.cos((k1-1) * x) + sum;
    }
}
