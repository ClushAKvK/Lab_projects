package com.company.Saska.task4.Main;

import com.company.Vanish.task4.methods.Zeidel;
import com.company.Vanish.task4.objects.Function;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Program {

    private static final double roundValue = 10000.0;

    public static final int n = 20;

    public static String expression1;
    public static String expression1X;

    public static String expression2;
    public static String expression2Y;

    public static Function function1;
    public static Function function2;

    public static final double eps = 0.0001;

    private static void input() throws FileNotFoundException {
        String path = Path.of("").toAbsolutePath() + "\\resources\\task4\\input1.txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.useLocale(Locale.UK);

        expression1 = sc.nextLine();
        expression1X = sc.nextLine();
        expression2 = sc.nextLine();
        expression2Y = sc.nextLine();

        function1 = new Function(expression1X, "x");
        function2 = new Function(expression2Y, "y");
    }


    private static void output(Set<Double> x, Set<Double> discrepancy) {
        //System.out.println("Interval: (" + A + ", " + B + ")");
        System.out.println("Function 1: " + expression1);
        System.out.println("Function 2: " + expression2);
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


        Set<Double> result = Zeidel.run(function1, function2, eps);

        function1 = new Function(expression1, "x");
        function2 = new Function(expression2, "y");
        Set<Double> discrepancy = Zeidel.calcDiscrepancy(result, function1, function2);

        output(result, discrepancy);


        //output(x, discrepancy);
    }


}
