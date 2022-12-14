package com.company.Di.task4.Main;

import com.company.Di.task4.methods.Relaxation;
import com.company.Di.task4.objects.Function;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static String expression1;
    public static String expression1X;

    public static String expression2;
    public static String expression2Y;

    public static Function function1;
    public static Function function2;

    public static double x0, y0;

    public static final double eps = 0.001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.UK);

        expression1 = sc.nextLine();
        expression1X = sc.nextLine();
        expression2 = sc.nextLine();
        expression2Y = sc.nextLine();

        x0 = sc.nextDouble();
        y0 = sc.nextDouble();

        function1 = new Function(expression1X, "x");
        function2 = new Function(expression2Y, "y");


        List<Double> result = Relaxation.run(function1, function2, x0, y0, eps);

        double[] ans = new double[2];
        int t = 0;
        for (Double i : result) {
            ans[t] = i;
            t++;
        }

        function1 = new Function(expression1, "x");
        function2 = new Function(expression2, "y");

        System.out.println("X: " + ans[0]);
        System.out.println("Discrepancy: " + function1.getValueIn(ans[0], ans[1]));
        System.out.println("X: " + ans[1]);
        System.out.println("Discrepancy: " + function2.getValueIn(ans[0], ans[1]));


    }


}
