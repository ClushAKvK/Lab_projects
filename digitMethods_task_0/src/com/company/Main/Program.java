package com.company.Main;

import com.company.methods.Gauss;
import com.company.objects.Matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import static com.company.objects.Matrix.maxValue;
import static com.company.objects.Matrix.minValue;

public class Program {

    private static final double roundValue = 100.0;

    public int rank;

    public double [][] A;

    public double [] b;

    public Program() {}

    private void input() throws FileNotFoundException {
        String path = Path.of("").toAbsolutePath() + "\\input.txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.useLocale(Locale.UK);

        rank = sc.nextInt();
        A = new double[rank][rank];
        for (int i = 0; i < rank; i++) {
            for (int j = 0; j < rank; j++) {
                A[i][j] = sc.nextDouble();
                //System.out.print(A[i][j]);
            }
        }

        b = new double[rank];
        for (int i = 0; i < rank; i++)
            b[i] = sc.nextDouble();
    }


    private void input(boolean autoGen) throws FileNotFoundException {
        if (autoGen == false) {
            input();
            return;
        }
        rank = 5;
        A = Matrix.generationMatrix(rank);

        b = new double[rank];
        for (int i = 0; i < rank; i++) {
            Random random = new Random();
            b[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }

    }


    public static void print(double [][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void print(double [] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    public static void printWithRound(double [][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(Math.round(a[i][j] * roundValue) / roundValue + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void printWithRound(double [] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(Math.round(a[i] * roundValue) / roundValue + " ");
        }
        System.out.println();
    }


    public void start() {
        try {
            input();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Matrix matrix = new Matrix(rank, A, b);

        try {
            Gauss.straightRunning(matrix);
        }
        catch (Exception e) {
            System.out.println("This system is unrealisable");
            System.exit(0);
        }

        Gauss.reverseRunning(matrix);

        double [] x = Gauss.resultRunning(matrix);
        double [] discrepancy = Gauss.calcDiscrepancy(A, x, b);

        System.out.println("Matrix A:");
        print(A);

        System.out.println("Vector b:");
        print(b);

        System.out.println("Result vector x:");
        printWithRound(x);

        System.out.println("Discrepancy:");
        printWithRound(discrepancy);

    }
}
