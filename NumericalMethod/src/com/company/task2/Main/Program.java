package com.company.task2.Main;

import com.company.task2.methods.Zeidel;
import com.company.task2.objects.Matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import static com.company.task2.objects.Matrix.maxValue;
import static com.company.task2.objects.Matrix.minValue;

public class Program {

    private static final double roundValue = 10000.0;

    public int rank;

    public double [][] A;

    public double [] b;

    public double eps = 0.0001;

    public Program() {}

    private void input() throws FileNotFoundException {
        String path = Path.of("").toAbsolutePath() + "\\resources\\task2\\input5.txt";
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
        System.out.print("(");
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) System.out.print(a[i]);
            else System.out.print(a[i] + ", ");
        }
        System.out.print(")");
        System.out.println("\n");
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
        System.out.print("(");
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) System.out.print(Math.round(a[i] * roundValue) / roundValue);
            else System.out.print(Math.round(a[i] * roundValue) / roundValue + ", ");
        }
        System.out.print(")");
        System.out.println("\n");
    }


    public void start() {

        try {
            input();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Matrix matrix = new Matrix(
                rank,
                Matrix.multiplyMatrices(Matrix.transposition(A), A),
                Matrix.multiplyMatrices(Matrix.transposition(A), b)
        );

//        matrix.print();



        double[] x = Zeidel.run(matrix, eps);

        System.out.println("Matrix A:");
        print(A);

        System.out.println("Vector b:");
        print(b);

        System.out.println("Result vector x:");
        printWithRound(x);


    }
}
