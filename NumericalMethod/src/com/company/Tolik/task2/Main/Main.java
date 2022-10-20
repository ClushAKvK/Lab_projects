package com.company.Tolik.task2.Main;

import com.company.Tolik.task2.Frame.DrawFrame;
import com.company.Tolik.task2.objects.Dot;

import java.io.File;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static double minX;
    public static double maxX;

    public static int n = 20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.UK);

        minX = sc.nextDouble();
        maxX = sc.nextDouble();

        Dot[] dots = new Dot[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dots[i] = new Dot();
            dots[i].x = minX + ((maxX - minX) / n) * i;
//            dots[i].y = Math.abs(dots[i].x * dots[i].x - 2 * dots[i].x);
            dots[i].y = Math.sin(dots[i].x);
//            dots[i].y = Math.sin(dots[i].x * dots[i].x);
        }

        DrawFrame.draw(dots);
    }
}
