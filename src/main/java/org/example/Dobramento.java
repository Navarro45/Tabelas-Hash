package org.example;

import org.jfree.data.category.DefaultCategoryDataset;

import java.util.Random;

public class Dobramento {


    public int tamanho;
    public Registro[][] TabelasRegistro;
    public Registro[] TabelaRegistro;
    public Node[] TabelaHash;
    public int NumColisao;
    Grafico grafico;


    public Dobramento(int tamanho){
        this.tamanho = tamanho;
        this.TabelaHash = new Node[tamanho];
        this.TabelasRegistro = GerarRegistro();
        grafico = new Grafico();
    }


    public int chave(int codigo) {
        String StrCodigo = ""+codigo;
        int soma = 0;
        String[] PartesCodigo = StrCodigo.split("(?<=\\\\G.{3})");
        for(int i = 0;i < PartesCodigo.length;i++){
            soma +=  Integer.parseInt(PartesCodigo[i]);
        }
        return (soma%tamanho);
    }


    public void inserir(DefaultCategoryDataset NumColisaografico){
        for(int j = 0;j < TabelasRegistro.length;j++){
            TabelaRegistro = TabelasRegistro[j];
            for (int i = 0; i < tamanho; i++) {
                int codigo = TabelaRegistro[i].getCodigo();
                int chave = chave(codigo);



                Node novoNo = new Node(TabelaRegistro[i]);


                if (TabelaHash[chave] == null) {
                    TabelaHash[chave] = novoNo;
                } else {
                    NumColisao++;
                    Node atual = TabelaHash[chave];
                    while (atual.getProximo() != null) {
                        atual = atual.getProximo();
                    }
                    atual.setProximo(novoNo);
                }
            }
        }
        NumColisaografico.addValue(NumColisao, "Tabela Hash com Encadeamento", Integer.toString(tamanho));
    }


    public Registro[][] GerarRegistro() {
        long seed = 52;
        Random random = new Random(seed);

        int[] tamanhos = {1000000, 5000000, 20000000};
        Registro[][] tabelasRegistro = new Registro[tamanhos.length][];


        for (int i = 0; i < tamanhos.length; i++) {
            Registro[] tabelaRegistro = new Registro[tamanhos[i]];


            for (int j = 0; j < tamanhos[i]; j++) {
                int codigo = 100_000_000 + random.nextInt(900_000_000);
                Registro registro = new Registro();
                registro.setCodigo(codigo);
                tabelaRegistro[j] = registro;
            }

            tabelasRegistro[i] = tabelaRegistro;
        }

        return tabelasRegistro;
    }


    public void HashDobramento(DefaultCategoryDataset tempoExec,DefaultCategoryDataset NumColisaografico) {
        long inicio = System.nanoTime();
        inserir(NumColisaografico);
        long fim = System.nanoTime();
        long tempo = (fim-inicio)/1000000;
        tempoExec.addValue(tempo, "Tempo de Execução", Integer.toString(tamanho));


    }


    public Registro buscar(int codigo) {
        long inicio = System.nanoTime();
        long fim = 0;
        int indice = chave(codigo);
        Node atual = TabelaHash[indice];


        while (atual != null) {
            if (atual.getRegistro().getCodigo() == codigo) {
                fim = System.nanoTime();
                long tempo = fim-inicio;
                return atual.getRegistro();

            }
            atual = atual.getProximo();
        }
        fim = System.nanoTime();
        long tempo = fim-inicio;
        System.out.println("Dobra Tempo da busca: " + (tempo));

        return null;
    }


    public double extrairParteFracionaria(double produto) {

        int parteInteira = (int) produto;

        double parteFracionaria = produto - parteInteira;

        return parteFracionaria;
    }
}






