package com.company.Vanish.task2.Main;

import com.company.Vanish.task2.Frame.DrawFrame;
import com.company.Vanish.task2.methods.LeastSquare;
import com.company.Vanish.task2.objects.Dot;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

import static com.company.Saska.task1.Main.Program.print;

public class Program {

    public static double minX;
    public static double maxX;

    public static final int k = 30;

    private void input() throws FileNotFoundException {
        //System.out.println("Промежуток апроксимации функции");
        String path = Path.of("").toAbsolutePath() + "\\resources\\task3\\input2.txt";
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

        Dot[] dots = new Dot[k + 1];
        for (int i = 0; i < k + 1; i++) {
            dots[i] = new Dot();
            dots[i].x = minX + ((maxX - minX) / (k)) * i;
            dots[i].y = Math.sin(dots[i].x);
        }

        double[] A = new double[k / 2 - 1];
        double[] B = new double[k / 2 - 1];

        for (int i = 0; i < k / 2 - 1;i++) {
            A[i] = LeastSquare.calculateA(dots, i);
            B[i] = LeastSquare.calculateB(dots, i);
        }


        DrawFrame.draw(dots, A, B);
    }
}
