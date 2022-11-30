package com.company.Vanish.task4.Main;

import com.company.Vanish.task4.methods.Zeidel;
import com.company.Vanish.task4.objects.Function;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static String expression1;
    public static String expression1X;

    public static String expression2;
    public static String expression2Y;

    public static Function function1;
    public static Function function2;

    public static double x0, y0;

    public static final double eps = 1E-8;
//    public static final double eps = 0.00000001;

    public static void main(String[] args) throws IOException {
        String path = Path.of("").toAbsolutePath() + "\\input.txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.useLocale(Locale.UK);

        expression1 = sc.nextLine();
        expression1X = sc.nextLine();
        expression2 = sc.nextLine();
        expression2Y = sc.nextLine();

        x0 = sc.nextDouble();
        y0 = sc.nextDouble();

        function1 = new Function(expression1X, "x");
        function2 = new Function(expression2Y, "y");


        List<Double> result = Zeidel.run(function1, function2, x0, y0, eps);

        function1 = new Function(expression1, "x");
        function2 = new Function(expression2, "y");

        ArrayList<Double> discrepancy = Zeidel.calcDiscrepancy(result, function1, function2);

        output(result, discrepancy);

    }


    private static void output(List<Double> x, ArrayList<Double> discrepancy) {
        try {
            Writer fw = new FileWriter("output.txt");
            String temp = "Start convergence: (" + x0 + ", " + y0 + ")\n";
            fw.write(temp);
            fw.flush();

            temp = "Function 1: " + expression1 + "\n";
            fw.write(temp);
            fw.flush();

            temp = "Function 2: " + expression2 + "\n";
            fw.write(temp);
            fw.flush();

            temp = "Result x: " + print(x);
            fw.write(temp);
            fw.flush();

            temp = "Discrepancy x: " + print(discrepancy);
            fw.write(temp);
            fw.flush();

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String print(List<Double> x) {
        String str = "";
        str += "(";
        for (Iterator<Double> it = x.iterator(); it.hasNext(); ) {
            str += String.valueOf(it.next());
            if (it.hasNext())
                str += ", ";
        }
        str += ")\n";
        return str;
    }

    private static String print(ArrayList<Double> x) {
        String str = "";
        str += "(";
        for (Iterator<Double> it = x.iterator(); it.hasNext(); ) {
            str += String.valueOf(it.next() * 0.0001);
            if (it.hasNext())
                str += ", ";
        }
        str += ")\n";
        return str;
    }

}
