package com.company.Saska.task5.methods;

import com.company.Saska.task4.objects.Function;

public class Trapezium {

    public static int n = 5;

    public static String parseExpression(String expression) {
        String expressed;

        expressed = "((" + expression.replace("x", "(a)") + ") / 2 + ";

        for (int i = 1; i < n; i++) {
            String it = Integer.toString(i);
            String temp = expression.replace(
                    "x",
                    "((a * (n - " + it + ") + " + it + " * x) / n)"
            );
            expressed = expressed + temp + " + ";
        }

        expressed = expressed + expression + " / 2)";

        expressed = expressed + " * ((x - a) / n)";

        expressed = expressed + " - b";

        return expressed;
    }

}
