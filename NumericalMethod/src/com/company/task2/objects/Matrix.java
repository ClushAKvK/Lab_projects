package com.company.task2.objects;

import com.company.task1.Main.Program;

import java.util.Random;

public class Matrix {
    public static final int minValue = -10;
    public static final int maxValue = 10;

    private int rank;

    private double [][] matrix;


    public Matrix(int rank, double[][] matrix) {
        this.rank = rank;
        this.matrix = matrix;
    }

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


    public static double[][] transposition(double[][] matrix) {
        double[][] result = new double[matrix.length][];
        for (int i = 0; i < matrix.length; i++)
            result[i] = matrix[i].clone();

        for (int i = 0; i < result.length; i++) {
            for (int j = i+1; j < result.length; j++) {
                double temp = result[i][j];
                result[i][j] = result[j][i];
                result[j][i] = temp;
            }
        }
        return result;
    }


    public static double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }


    public static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = multiplyMatricesCell(firstMatrix, secondMatrix, i, j);
            }
        }
        return result;
    }

    public static double[] multiplyMatrices(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return result;
    }


    private void joinVector(double [][] A, double [] b) {
        for (int i = 0; i < rank; i++) {
            for (int j = 0; j < rank; j++) {
                matrix[i][j] = A[i][j];
            }
            matrix[i][rank] = b[i];
        }
    }


    public void toNormalView() {
        for(int i = 0; i < rank; i++) {
            for (int j = 0; j < rank; j++) {
                if (i == j) continue;
                matrix[i][j] /= matrix[i][i] * (-1);
            }
            matrix[i][rank] /= matrix[i][i];
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
