package com.company.Vanish.task1.methods;

import com.company.Vanish.task1.objects.Matrix;

public class Rotation_method {

    public static double[] start(Matrix matrix) {

        //приведение матриы к верхнетреугольному виду(под диагональю нули)
        Matrix calcMatrix = new Matrix(matrix.getRank());

        for (int k = 0; k < matrix.getRank() - 1; k++) {
            calcMatrix.calcP(k, matrix);
            double s = calcMatrix.calcS(k);
            for (int i = k + 1; i < calcMatrix.getRank() + 1; i++) {
                double r = calcMatrix.calcR(k, i, matrix);
                for (int j = k; j < calcMatrix.getRank(); j++) {
                    calcMatrix.set(j, i, ( 2 * r * calcMatrix.get(j, k) ) / s );
                }
            }
            //calcMatrix.print();
            matrix.subtractMatrix(calcMatrix);
            //matrix.print();
        }


        //обратный ход по верхнетреугольной матрице(как в Гауссе)
        for (int i = matrix.getRank() - 1; i > 0; i--) {
            //matrix.toNormalView(i);
            for (int j = i - 1; j >= 0; j--) {
                if (matrix.get(j, i) == 0.0) continue;
                matrix.divideLineBy(j, matrix.get(j, i));
                matrix.multipleLineBy(j, matrix.get(i, i));
                matrix.subtractLine(j, i);
            }
        }

        for (int i = 0; i < matrix.getRank(); i++) {
            matrix.divideLineBy(i, matrix.get(i, i));
        }

        //получаем искомый вектор
        double [] x = new double[matrix.getRank()];
        for (int i = 0; i < matrix.getRank(); i++) {
            x[i] = matrix.get(i, matrix.getRank());
        }

        return x;
    }
}
