package org.example;
import org.example.arvores.AVLTree;
import org.example.arvores.RedBlackBST;
import org.example.arvores.Tree;

import java.util.Random;

public class Main {
    public static void main(String[] args) {xtxt
        // criando vetores
        int[] vetor30mil = gerarVetoresAleatorios(30000);
        int[] vetor60mil = gerarVetoresAleatorios(60000);
        int[] vetor100mil = gerarVetoresAleatorios(100000);

        // Testes de inserção e remoção nas respectivas árvores
        testeArvore(vetor30mil, new AVLTree());
        testeArvore(vetor30mil, new RedBlackBST());

        testeArvore(vetor60mil, new AVLTree());
        testeArvore(vetor60mil, new RedBlackBST());

        testeArvore(vetor100mil, new AVLTree());
        testeArvore(vetor100mil, new RedBlackBST());
    }

    public static int[] gerarVetoresAleatorios(int tamanho){
        Random geradorDeNumeros = new Random();

        int[] vetor = new int[tamanho];
        for(int i = 0; i < tamanho; i++){
            vetor[i] = geradorDeNumeros.nextInt(tamanho);
        }

        return vetor;
    }

    public static void testeArvore(int[] vetor, Tree arvore){
        testeInsercao(vetor, arvore);
        testeRemocao(vetor, arvore);
        System.out.println();
    }

    public static void testeInsercao(int[] vetor, Tree arvore){
        System.out.println("Arvore "+arvore.toString()+" de "+vetor.length+" elementos:");
        long antes = System.nanoTime();
        for(int i = 0; i < vetor.length; i++){
            arvore.insert(vetor[i]);
        }
        long depois = System.nanoTime();

        System.out.println("Tempo de inserção: "+(depois-antes)/1000000000.0);
    }

    public static void testeRemocao(int[] vetor, Tree arvore){
        long antes = System.nanoTime();
        for(int i = 0; i < vetor.length; i++){
            arvore.delete(vetor[i]);
        }
        long depois = System.nanoTime();

        System.out.println("Tempo de remoção: "+(depois-antes)/1000000000.0);
    }
}