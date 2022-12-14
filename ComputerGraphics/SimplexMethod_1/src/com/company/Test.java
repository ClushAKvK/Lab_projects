package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.Simplex1.*;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();

        JTextField rowsText = new JTextField("2");
        JTextField colsText = new JTextField("3");
        JButton enterSize = new JButton("Enter");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4;

        enterSize.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int rows = Integer.parseInt(rowsText.getText());
                    int cols = Integer.parseInt(colsText.getText());

                    panel1.setLayout(new GridLayout(rows, cols));
                    JTextField [][] matrixText = new JTextField[rows][cols];
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            matrixText[i][j] = new JTextField("0");
//                            matrixText[i][j].setColumns(7);
                            panel1.add(matrixText[i][j]);
                        }
                    }

                    JLabel cLabel = new JLabel("Vector C ");
                    panel2.add(cLabel);
                    JTextField [] cText = new JTextField[cols];
                    for (int i = 0; i < cols; i++) {
                        cText[i] = new JTextField("0");
                        panel2.add(cText[i]);
                    }

                    JLabel bLabel = new JLabel("Vector B ");
                    panel3.add(bLabel);
                    JTextField [] bText = new JTextField[rows];
                    for (int i = 0; i < rows; i++) {
                        bText[i] = new JTextField("0");
                        panel3.add(bText[i]);
                    }



                    JButton go = new JButton("Simplex method");
                    go.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JPanel panel5 = getMatrix(matrixText, cText, bText, rows, cols);
                            frame.getContentPane().add(BorderLayout.AFTER_LINE_ENDS, panel5);
                        }
                    });

                    panel.add(go);

                }
            }
        );


        panel.add(rowsText);
        panel.add(colsText);
        panel.add(enterSize);

        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.BEFORE_LINE_BEGINS, panel2);
        frame.getContentPane().add(BorderLayout.CENTER, panel3);
//       frame.getContentPane().add(BorderLayout.AFTER_LINE_ENDS, panel4);
        //frame.getContentPane().add(BorderLayout.AFTER_LINE_ENDS, panel3);

        frame.getContentPane().add(BorderLayout.SOUTH, panel1);

        frame.setVisible(true);

    }

    public static JPanel getMatrix(JTextField [][] matrixText, JTextField[] cText, JTextField[] bText, int rows, int cols) {
        double[][] A = new double[rows][cols];
        double[] c = new double[cols];
        double[] b = new double[rows];
        double[] x_0 = new double[cols];
        for (int i = 0; i < rows; i++) {
            b[i] = Double.parseDouble(bText[i].getText());
            for (int j = 0; j < cols; j++) {
                A[i][j] = Double.parseDouble(matrixText[i][j].getText());
            }
        }

        for (int i = 0; i < cols; i++) {
            c[i] = Double.parseDouble(cText[i].getText());
            if (i < cols - rows) x_0[i] = 0;
            else x_0[i] = b[i - rows + 1];
        }


        System.out.println("\nA: \n" + printMatrix(A));
        System.out.println("c: \n" + printVector(c));
        System.out.println("\nb: \n" + printVector(b));
        System.out.println("\nx_0: \n" + printVector(x_0));
        System.out.println();

        Result answer = solve(A, c, b, x_0, false);
        if (answer.flag != 0)
            System.out.println("Flag: " + answer.flag);
        if (answer.flag == 1) {
            System.out.println("Optimal solution: " + printVector(answer.optimal_sol));
            System.out.println("Optimal value: " + answer.optimal_val + "\n");
        }

        double [] res = answer.optimal_sol;

        JPanel panel = new JPanel();
        JLabel resLabel = new JLabel("Result value: " + answer.optimal_val + "    Result vector: ");
        panel.add(resLabel);
        JTextField [] resText = new JTextField[res.length];
        for (int i = 0; i < res.length; i++) {
            resText[i] = new JTextField(String.valueOf(res[i]));
            resText[i].setEditable(false);
            panel.add(resText[i]);
        }

        return panel;
    }
}
