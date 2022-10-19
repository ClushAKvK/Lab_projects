package com.company.Vanish.task3.Main;


import com.company.Vanish.task3.methods.Newton_halfDivision;
import com.company.Vanish.task3.objects.Function;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static double A;

    public static double B;

    public static String expression;

    public static Function function;

    public static final double eps = 0.0001;

    public static final int n = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.UK);

        A = sc.nextInt();
        B = sc.nextInt();

        sc.nextLine();
        expression = sc.nextLine();

        function = new Function(expression);


        for (int i = 0; i < n; i++) {
            double left = A + i * (B - A) / n;
            double right = A + (i + 1) * (B - A) / n;

            double x;

            if (function.getValueIn(left) * function.getValueIn(right) < 0) {
                x = Newton_halfDivision.run(right, eps, function);
                System.out.println("X: " + x + "\ndiscrepancy: " + function.getValueIn(x) + "\n");
            }
            else if (function.getValueIn(left) * function.getValueIn(right) == 0) {
                if (function.getValueIn(left) == 0) x = left;
                else x = right;
                System.out.println("X: " + x + " \ndiscrepancy: " + function.getValueIn(x) + "\n");
            }

        }

    }
}
