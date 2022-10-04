package com.company.Vanish.task3.Frame;

import com.company.Vanish.task3.methods.LeastSquare;
import com.company.Vanish.task3.objects.Dot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.company.Vanish.task3.Main.Program.*;

public class DrawFrame {

    public static void draw(Dot [] dots, double[] A, double[] B) {
        XYSeries series = new XYSeries("sin(a)");
        XYSeries series2 = new XYSeries("sin(a) - original");

        for(int i = 0; i < k + 1; i++) {
            series.add(
                    dots[i].x,
                    LeastSquare.calculateT(dots[i].x, A, B)
            );
        }

        for (double i = minX; i < maxX; i+=0.1) {
            series2.add(i, Math.sin(i));
        }

        XYSeriesCollection xyDataset = new XYSeriesCollection(series);
        xyDataset.addSeries(series2);

        JFreeChart chart = ChartFactory
                .createXYLineChart("y = sin(x)", "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);

        chart.getXYPlot().getDomainAxis().setRange(minX, maxX);



        JFrame frame = new JFrame("MinimalStaticChart");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }

        });

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 27) {
                    frame.dispose();
                    System.exit(0);
                }
            }
        });

        // Помещаем график на фрейм
        frame.getContentPane().add(new ChartPanel(chart));
        frame.setSize(800,600);
        frame.show();

    }

}
