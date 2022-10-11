package com.company.Saska.task3.Main;

import com.company.Saska.task3.Frame.DrawFrame;
import com.company.Saska.task3.methods.LeastSquare;
import com.company.Saska.task3.methods.LocalSmoothingOfData;
import com.company.Saska.task3.objects.Dot;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static double minX;
    public static double maxX;

    public static final int n = 20;

    private void input() throws FileNotFoundException {
        //System.out.println("Промежуток апроксимации функции");
        String path = Path.of("").toAbsolutePath() + "\\resources\\task3\\input1.txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.useLocale(Locale.UK);

        minX = sc.nextDouble();
        maxX = sc.nextDouble();
    }

    public void start() {
        try {
            input();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Dot[] dots = new Dot[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dots[i] = new Dot();
            dots[i].x = minX + ((maxX - minX) / n) * i;
            dots[i].y = Math.sin(dots[i].x);
        }

        double[] resultY = LocalSmoothingOfData.start(dots);

        DrawFrame.draw(dots, resultY);
    }
}
