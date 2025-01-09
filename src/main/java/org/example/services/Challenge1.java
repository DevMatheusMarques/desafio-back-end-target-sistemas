package org.example.services;

/**
 * Classe responsável por calcular a soma dos números inteiros de 1 até 13.
 * A soma é realizada utilizando uma estrutura de repetição do tipo `while`.
 */
public class Challenge1 {

    private int soma = 0;
    private int k = 0;

    /**
     * Método que calcula a soma dos números de 1 até 13.
     * Ele utiliza um laço `while` para somar os números de 1 a 13 e imprime
     * o valor final da soma.
     */
    public void sumVariable() {
        int index = 13;

        while (k < index) {
            k++;
            soma += k;
        }

        System.out.println("O valor final da variável SOMA é: " + soma);
    }
}
