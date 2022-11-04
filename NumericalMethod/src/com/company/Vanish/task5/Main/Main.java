package com.company.Vanish.task5.Main;

import com.company.Vanish.task5.methods.Simpson;
import com.company.Vanish.task5.objects.Function;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
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

        double ans = Simpson.run(A, B, eps, function);

        System.out.println("Answer: " + ans);
        System.out.println("Discrepancy: " + Simpson.calcDiscrepancy(ans, A, B, function));
    }
}
