package com.company.Vanish.task2.methods;

import com.company.Vanish.task2.objects.Dot;

import static com.company.Vanish.task2.Main.Program.k;

public class LeastSquare {
    public static double calculateA(Dot[] dots, int j) {

        double sum = 0;
        for (int i = 0; i < k-1;i++) {
            sum += dots[i].y * Math.cos(j * dots[i].x);
        }
//        System.out.println(sum);
        double s1 = (double) 2 / k;
        return s1 * sum;
    }

    public static double calculateB(Dot[] dots, int j) {

        double sum = 0;
        for (int i = 0; i < k-1;i++) {
            sum += dots[i].y * Math.sin(j* dots[i].x);
        }
        //System.out.println((2 / k));
        double s1 = (double) 2 / k;
        return s1 * sum;
    }

    public static double calculateT(double x, double[] A, double[] B) {

        int k1 = A.length;
        double sum = 0;
        for (int i = 1; i < k1 - 1; i++) {
            sum += A[i] * Math.cos(i * x) + B[i] * Math.sin(i * x);
        }

        //System.out.println(A[0] / 2);

        return A[0] / 2 + A[k1 - 1] * Math.cos((k1-1) * x) + sum;
    }
}
