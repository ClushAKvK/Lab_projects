package com.company.Saska.task1.objects;

import java.util.Random;

public class Matrix {
    public static final int minValue = -10;
    public static final int maxValue = 10;

    private int rank;

    private double [][] matrix;

    public Matrix(int rank, double [][] A, double [] b) {
        this.rank = rank;
        this.matrix = new double[rank][rank + 1];
        joinVector(A, b);
    }


    public static double[][] generationMatrix(int rank) {
        double [][] matrix = new double[rank][rank];
        for (int i = 0; i < rank; i++) {
            for (int j = 0; j < rank; j++) {
                Random random = new Random();
                matrix[i][j] = random.nextInt(maxValue - minValue + 1) + minValue;
            }
        }
        return matrix;
    }


    private void joinVector(double [][] A, double [] b) {
        for (int i = 0; i < rank; i++) {
            for (int j = 0; j < rank; j++) {
                matrix[i][j] = A[i][j];
            }
            matrix[i][rank] = b[i];
        }
    }


    public double get(int i, int j) { return matrix[i][j]; }

    public void set(int i, int j, double value) { matrix[i][j] = value; }

    public int getRank() { return rank; }

    public double[][] getMatrix() { return matrix; }


    public void print() {
        for (int i = 0; i < rank; i++) {
            for (int j = 0; j < rank + 1; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public void swapLine(int line, int sLine) {
        for (int i = 0; i < rank + 1; i++) {
            double temp = matrix[line][i];
            matrix[line][i] = matrix[sLine][i];
            matrix[sLine][i] = temp;
        }
    }


    public void toNormalView(int line) throws ArrayIndexOutOfBoundsException {
        for (int i = line + 1; matrix[line][line] == 0; i++) {
            if (matrix[i][line] != 0)
                swapLine(line, i);
        }
    }


    public void multipleLineBy(int line, double value) {
        for (int j = 0; j < rank + 1; j++) {
            matrix[line][j] *= value;
        }
    }


    public void divideLineBy(int line, double value) {
        for (int j = 0; j < rank + 1; j++) {
            matrix[line][j] /= value;
        }
    }


    public void subtractLine(int line, int subLine) {
        for (int j = 0; j < rank + 1; j++) {
            matrix[line][j] -= matrix[subLine][j];
        }
    }

}
