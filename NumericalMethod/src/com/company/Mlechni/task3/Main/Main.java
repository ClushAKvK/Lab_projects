package com.company.Mlechni.task3.Main;

import com.company.Mlechni.task3.methods.Stefonsen;
import com.company.Mlechni.task3.objects.Function;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

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

        Set<Double> x = Stefonsen.run(A, B, function);

        Set<Double> discrepancy = Stefonsen.calcDiscrepancy(x, function);

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
