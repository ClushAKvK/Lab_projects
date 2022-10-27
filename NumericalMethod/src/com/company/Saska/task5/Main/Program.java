package com.company.Saska.task5.Main;

import com.company.Saska.task5.methods.Hord;
import com.company.Saska.task5.methods.Trapezium;
import com.company.Saska.task5.objects.Function;
import com.company.Saska.task5.methods.Newton_halfDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Program {

    private static final double roundValue = 10000.0;

//    public static final int n = 20;

    public static double A;
    public static double B;

    public static String expression;

    public static Function function;

    public static final double eps = 0.0001;

    private static void input() throws FileNotFoundException {
        String path = Path.of("").toAbsolutePath() + "\\resources\\task5\\input3    .txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.useLocale(Locale.UK);

        A = sc.nextDouble();
        B = sc.nextDouble();

        sc.nextLine();
        expression = sc.nextLine();

        //function = new Function(expression, "x");
    }


    private static void output(Set<Double> x, Set<Double> discrepancy) {
        //System.out.println("Interval: (" + A + ", " + B + ")");
        System.out.println("Function : " + expression);
        System.out.print("Result x: "); print(x);
        System.out.print("Discrepancy x: "); print(discrepancy);
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

    private static void printWithRound(Set<Double> x) {
        System.out.print("(");
        for (Iterator<Double> it = x.iterator(); it.hasNext(); ) {
            System.out.print(Math.round(it.next() * roundValue) / roundValue);
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

        //System.out.println(A + ", " + B + " \n" + expression);
        String expressed = Trapezium.parseExpression(expression);

        function = new Function(expressed);

//        System.out.println(expressed);

        System.out.println(expression);
        double ans = Newton_halfDivision.run(1000, eps, function);
        //System.out.println(function);

        System.out.println(ans);

//        for (Double i : ans)
//            System.out.println(i);

        //System.out.println(expressed);
        //output(x, discrepancy);
    }

}
