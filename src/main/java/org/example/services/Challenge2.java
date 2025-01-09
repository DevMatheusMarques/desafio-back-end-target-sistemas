package org.example.services;

/**
 * Classe para verificar se um número pertence à sequência de Fibonacci.
 */
public class Challenge2 {
    private int a = 0;
    private int b = 1;
    private final int number;

    /**
     * Construtor da classe.
     *
     * @param number o número a ser verificado.
     */
    public Challenge2(int number) {
        this.number = number;
    }

    /**
     * Verifica se o número pertence à sequência de Fibonacci.
     *
     * @return true se o número pertence, false caso contrário.
     */
    public boolean fibonacciChecker() {
        if (number == a || number == b) {
            return true;
        }

        while (b < number) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b == number;
    }

    /**
     * Exibe o resultado da verificação no console.
     */
    public void printResult() {
        if (fibonacciChecker()) {
            System.out.println("O número " + number + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + number + " não pertence à sequência de Fibonacci.");
        }
    }
}

