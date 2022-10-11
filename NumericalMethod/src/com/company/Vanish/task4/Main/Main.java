package com.company.Vanish.task4.Main;


import com.company.Vanish.task4.methods.HalfDivision;
import com.company.Vanish.task4.methods.Newton;
import com.company.Vanish.task4.objects.Function;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static double A;

    public static double B;

    public static String expression;

    public static Function function;

    public static final double eps = 0.0001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.UK);

        A = sc.nextInt();
        B = sc.nextInt();

        sc.nextLine();
        expression = sc.nextLine();

        function = new Function(expression);


        double x = Newton.run(A, B, eps, function);

        System.out.println(x + " " + A);
    }
}
