package org.example;

import org.jfree.data.category.DefaultCategoryDataset;

public class Main {
    public static void main(String[] args) {
        int[] tamanho = {100, 1000, 10000};
        DefaultCategoryDataset NumColisaograficoM = new DefaultCategoryDataset();
        DefaultCategoryDataset tempoExecM = new DefaultCategoryDataset();
        DefaultCategoryDataset NumColisaograficoD = new DefaultCategoryDataset();
        DefaultCategoryDataset tempoExecD = new DefaultCategoryDataset();
        DefaultCategoryDataset NumColisaograficoR = new DefaultCategoryDataset();
        DefaultCategoryDataset tempoExecR = new DefaultCategoryDataset();

        Grafico grafico = new Grafico();
        int [] buscas = {602899438, 801059372, 912841690, 944105703, 951143335};

        for (int i = 0; i < tamanho.length; i++) {
            RestoDivisao r = new RestoDivisao(tamanho[i]);
            Multiplicacao m = new Multiplicacao(tamanho[i]);
            Dobramento d = new Dobramento(tamanho[i]);
            r.HashDivisao(tempoExecR, NumColisaograficoR);
            m.HashMultiplicacao(tempoExecM, NumColisaograficoM);
            d.HashDobramento(tempoExecD, NumColisaograficoD);
            if(i == (tamanho.length - 1)){
                for(int j = 0; j < 5;j++){
                    System.out.println(r.buscar(buscas[j]));
                    System.out.println(m.buscar(buscas[j]));
                    System.out.println(d.buscar(buscas[j]));
                }
            }
        }



        grafico.gerarGraficoColisoes(NumColisaograficoR, "Resto Da Divisao");
        grafico.gerarGraficoTempo(tempoExecR, "Resto Da Divisao");
        grafico.gerarGraficoColisoes(NumColisaograficoD, "Dobramento");
        grafico.gerarGraficoTempo(tempoExecD, "Dobramento");
        grafico.gerarGraficoColisoes(NumColisaograficoM, "Multiplicacao");
        grafico.gerarGraficoTempo(tempoExecM, "Multiplicacao");
    }


}