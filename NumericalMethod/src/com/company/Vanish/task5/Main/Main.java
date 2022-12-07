package com.company.Vanish.task5.Main;

import com.company.Vanish.task5.methods.Simpson;
import com.company.Vanish.task5.objects.Function;

import java.io.*;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static double A;
    public static double B;

    public static String expression;

    public static Function function;

    public static final double eps = 1E-8;

    public static void main(String[] args) throws FileNotFoundException {
        String path = Path.of("").toAbsolutePath() + "\\input.txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.useLocale(Locale.UK);

        A = sc.nextDouble();
        B = sc.nextDouble();

        sc.nextLine();
        expression = sc.nextLine();
        Function function = new Function(expression);

        double ans = Simpson.run(A, B, eps, function);


        try {
            Writer fw = new FileWriter("output.txt");
            String temp = "Answer: " + ans;
            fw.write(temp);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
