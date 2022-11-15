package com.company.Kirchik.task4.Main;

import com.company.Kirchik.task4.methods.Brown;
import com.company.Saska.task4.methods.Yakobi;
import com.company.Saska.task4.objects.Function;
import com.company.Vanish.task4.methods.Zeidel;

import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.zip.DeflaterInputStream;

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


        Set<Double> result = Brown.run(function1, function2, x0, y0, eps);

        output(result);

    }


    public static void output(Set<Double> result) {
        result = Yakobi.run(function1, function2, x0, y0, eps);
        double[] ans = new double[2];
        int t = 0;
        for (Double i : result) {
            ans[t] = i;
            t++;
        }

        function1 = new Function(expression1, "x");
        function2 = new Function(expression2, "y");

        double dis = function1.getValueIn(ans[0], ans[1]);
        System.out.println("X: " + ans[1]);
        if (Math.abs(dis) > eps) System.out.println("Discrepancy: " + dis * 0.0001);
        else System.out.println("Discrepancy: " + dis);
        dis = function2.getValueIn(ans[0], ans[1]);
        System.out.println("Y: " + ans[0]);
        if (Math.abs(dis) > eps) System.out.println("Discrepancy: " + dis * 0.0001);
        else System.out.println("Discrepancy: " + dis);
    }


}
