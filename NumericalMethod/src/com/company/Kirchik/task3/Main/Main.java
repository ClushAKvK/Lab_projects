package com.company.Kirchik.task3.Main;

import com.company.Kirchik.task3.methods.Newton;
import com.company.Kirchik.task3.objects.Function;

import java.util.*;

public class Main {

    public static double A;

    public static double B;

    public static String expression;

    public static Function function;

    public static final double eps = 0.0001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.UK);

        A = sc.nextDouble();
        B = sc.nextDouble();

        sc.nextLine();
        expression = sc.nextLine();
        function = new Function(expression);

        Set<Double> x = Newton.run(A, B, function);

        ArrayList<Double> discrepancy = Newton.calcDiscrepancy(x, function);

        System.out.println("X: ");
        for (double i : x) {
            System.out.print(i + " ");
        }

        System.out.println();

        System.out.println("Discrepancy: ");
        for (double i : discrepancy) {
            System.out.print(i + " ");
        }
    }


}
