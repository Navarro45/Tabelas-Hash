package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


import javax.swing.*;
import java.awt.*;

public class Grafico {


    DefaultCategoryDataset NumColisao;
    DefaultCategoryDataset tempoExec;

    public Grafico(){
        NumColisao = new DefaultCategoryDataset();
        tempoExec = new DefaultCategoryDataset();
    }

    public void gerarGraficoTempo(DefaultCategoryDataset tempoExec,String tipo){

        JFreeChart chart = ChartFactory.createLineChart(
                "Desempenho do Hash"+tipo,
                "Tamanho do Vetor",
                "Tempo(ms)",
                tempoExec,
                PlotOrientation.VERTICAL,
                true, true, false);

        JFrame frame = new JFrame("Performance do Hash");
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void gerarGraficoColisoes(DefaultCategoryDataset numColisao, String tipo){

        JFreeChart chart = ChartFactory.createLineChart(
                "Desempenho do Hash"+tipo,
                "Tamanho do Vetor",
                "Numero de Colisoes",
                numColisao,
                PlotOrientation.VERTICAL,
                true, true, false);

        JFrame frame = new JFrame("Performance do Hash");
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}
