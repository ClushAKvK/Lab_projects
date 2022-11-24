package com.company.Kirchik.task5.Main;

import com.company.Kirchik.task5.methods.Newton_Kotes;
import com.company.Kirchik.task5.objects.Function;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static double A;
    public static double B;

    public static String expression;

    public static Function function;

    public static final double eps = 0.0001;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.UK);

        A = sc.nextDouble();
        B = sc.nextDouble();

        sc.nextLine();
        expression = sc.nextLine();
        Function function = new Function(expression);

        double ans = Newton_Kotes.run(A, B, eps, function);

        System.out.println("Answer: " + ans);
        //System.out.println("Discrepancy: " + Simpson.calcDiscrepancy(ans, A, B, function));
    }
}
