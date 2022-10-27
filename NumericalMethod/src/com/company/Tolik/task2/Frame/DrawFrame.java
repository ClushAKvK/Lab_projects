package com.company.Tolik.task2.Frame;


import com.company.Tolik.task2.methods.Newton;
import com.company.Tolik.task2.objects.Dot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawFrame {

    public static void draw(Dot[] dots) {
        XYSeries series = new XYSeries("Interpolation");
        XYSeries series2 = new XYSeries("Function - original");

        for (double i = dots[0].x; i <= dots[dots.length - 1].x; i+=0.01) {
            series.add(
                    i,
                    Newton.run(i, dots)
            );
        }

        for (Dot i : dots) {
            series2.add(i.x, i.y);
        }

        XYSeriesCollection xyDataset = new XYSeriesCollection(series);
        xyDataset.addSeries(series2);

        JFreeChart chart = ChartFactory
                .createXYLineChart("Interpolation", "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);



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
