package com.company.Tolik.task2.Main;

import com.company.Tolik.task2.Frame.DrawFrame;
import com.company.Tolik.task2.objects.Dot;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static int n = 20;

    public static void main(String[] args) throws FileNotFoundException {
        String path = Path.of("").toAbsolutePath() + "\\input5.txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.useLocale(Locale.UK);

        int n = sc.nextInt();
        Dot[] dots = new Dot[n];
        for (int i = 0; i < n; i++) {
            dots[i] = new Dot();
            dots[i].x = sc.nextDouble();
            dots[i].y = sc.nextDouble();
        }

        DrawFrame.draw(dots);
    }
}
