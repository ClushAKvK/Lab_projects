package com.company.Saska.task5.Main;

import com.company.Saska.task5.methods.Hord;
import com.company.Saska.task5.methods.Trapezium;
import com.company.Saska.task5.objects.Function;
import com.company.Saska.task5.methods.Newton;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Program {

    public static double A;
    public static double B;

    public static String expression;

    public static Function function;

    public static final double eps = 0.0001;

    private static void input() throws FileNotFoundException {
        String path = Path.of("").toAbsolutePath() + "\\resources\\task5\\input5.txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.useLocale(Locale.UK);

        A = sc.nextDouble();
        B = sc.nextDouble();

        sc.nextLine();
        expression = sc.nextLine();
    }


    private static void output(double x, double discrepancy) {
        System.out.println("x\n" + "∫(" + expression + ")dx = " + B + "\n" + A);
        System.out.println("Result x: " + x);
        if (Math.abs(discrepancy) < eps) System.out.println("Discrepancy x: " + discrepancy);
        else System.out.println("Discrepancy x: " + discrepancy * eps);
    }


    private static void print(Set<Double> x) {
        System.out.print("(");
        for (Iterator<Double> it = x.iterator(); it.hasNext(); ) {
            System.out.print(it.next());
            if (it.hasNext()) System.out.print(", ");
        }
        System.out.print(")");
        System.out.println();
    }


    public static void start() {
        try {
            input();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        String expressed = Trapezium.parseExpression(expression);

        function = new Function(expressed);

        double x = Newton.run(A, eps, function);

        //Set<Double> ans = Hord.run(Math.abs(B), -Math.abs(B), function);

        output(x, function.getValueIn(x));
    }

}
