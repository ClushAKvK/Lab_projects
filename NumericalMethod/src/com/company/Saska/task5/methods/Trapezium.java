package com.company.Saska.task5.methods;

import com.company.Saska.task4.objects.Function;

public class Trapezium {

    public static int n = 3;

    public static String parseExpression(String expression) {
        String expressed;

        String A = "A", B = "B";

        expressed = "((" + expression.replace("x", "(a)");
        expressed = expressed + ") / 2 + ";

        //System.out.println(expressed);

        for (int i = 1; i < n; i++) {
            String it = Integer.toString(i);
//            String temp = expression.replace(
//                    "x", "(" + A + " * " + "(" + Integer.toString(n) + " - " + Integer.toString(i) + ") * "
//                            + Integer.toString(i) + " * n)" + " / " + Integer.toString(n)
//            );
            String temp = expression.replace(
                    "x",
                    "((a * (n - " + it + ") + " + it + " * x) / n)"
            );
            expressed = expressed + temp + " + ";
//            System.out.println("i: " + i + ": " + temp);
        }

        expressed = expressed + expression + " / 2)";

        expressed = expressed + " * ((x - a) / n)";

        expressed = expressed + " - b";

        return expressed;
    }

}
