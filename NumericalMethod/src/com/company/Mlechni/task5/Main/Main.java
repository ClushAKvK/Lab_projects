package com.company.Mlechni.task5.Main;

import com.company.Mlechni.task5.methods.Monte_Carlo;
import com.company.Mlechni.task5.objects.Function;

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

        double ans = Monte_Carlo.run(A, B, function);

//        Monte_Carlo.run(0, 10, function);

        System.out.println("Answer: " + ans);
    }
}
