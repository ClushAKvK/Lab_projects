package com.company.Saska.task3.Main;

import com.company.Saska.task3.methods.Hord;
import com.company.Saska.task3.objects.Function;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.*;

public class Program {

    private static final double roundValue = 10000.0;

    public static final int n = 20;

    public static double A;

    public static double B;

    public static String expression;

    public static Function function;

    public static final double eps = 0.0001;

    private static void input() throws FileNotFoundException {
        //System.out.println("Промежуток апроксимации функции");
        String path = Path.of("").toAbsolutePath() + "\\resources\\task3\\input3.txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.useLocale(Locale.UK);

        A = sc.nextDouble();
        B = sc.nextDouble();

        sc.nextLine();
        expression = sc.nextLine();

        function = new Function(expression);
//        System.out.println(function.getSecondDifferentiateIn(5));
    }


    private static void output(Set<Double> x, Set<Double> discrepancy) {
        System.out.println("Interval: (" + A + ", " + B + ")");
        System.out.println("Function: " + expression);
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

        Set<Double> x = Hord.run(A, B, function);

        Set<Double> discrepancy = Hord.calcDiscrepancy(x, function);

        output(x, discrepancy);
    }


}
