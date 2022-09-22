package com.company.Vanish.task2.Main;

import com.company.Vanish.task2.methods.Rotation_method;
import com.company.Vanish.task2.objects.Matrix;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	// write your code here

        //ввод матрицы
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.UK);

        int rank = sc.nextInt();
        double[][] A = new double[rank][rank];
        for (int i = 0; i < rank; i++) {
            for (int j = 0; j < rank; j++) {
                A[i][j] = sc.nextDouble();
            }
        }

        double[] b = new double[rank];
        for (int i = 0; i < rank; i++) {
            b[i] = sc.nextDouble();
        }

        Matrix matrix = new Matrix(rank, A, b);

        //С помощью методо вращений получаем результирующий вектор
        double[] x = Rotation_method.start(matrix);

        for (int i = 0; i < x.length; i++)
            System.out.print(x[i] + " ");
    }
}
