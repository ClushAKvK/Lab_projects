package com.company.Vanish.task2.objects;

import java.util.Random;

public class Matrix {

    private int rank;

    private double [][] matrix;


    public Matrix(int rank) {
        this.rank = rank;
        matrix = new double[rank][rank + 1];
    }


    public Matrix(int rank, double [][] A, double [] b) {
        this.rank = rank;
        this.matrix = new double[rank][rank + 1];
        joinVector(A, b);
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


    public void calcP(int k, Matrix originMatrix)  {
        double p = originMatrix.get(k, k);
        double sum = 0.0;
        for (int i = k; i < originMatrix.getRank(); i++) {
            sum += Math.pow(originMatrix.get(i, k), 2);
        }
        p += Math.sqrt(sum);

        for (int i = 0; i < rank; i++) {
            for (int j = 0; j < rank + 1; j++) {
                if (i < k || j < k)
                    matrix[i][j] = 0.0;
            }
        }

        matrix[k][k] = p;
        for (int i = k + 1; i < rank; i++) {
            matrix[i][k] = originMatrix.get(i, k);
        }
    }


    public double calcS(int k) {
        double s = 0.0;
        for (int i = k; i < rank; i++) {
            s += Math.pow(matrix[i][k], 2);
        }
        return s;
    }


    public double calcR(int k, int a, Matrix originMatrix) {
        double r = 0.0;
        for (int i = 0; i < rank; i++) {
            r += matrix[i][k] * originMatrix.get(i, a);
        }
        return r;
    }


    public void subtractMatrix(Matrix subMatrix) {
        for (int i = 0; i < rank; i++) {
            for (int j = 0; j < rank + 1; j++) {
                matrix[i][j] -= subMatrix.get(i, j);
            }
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
