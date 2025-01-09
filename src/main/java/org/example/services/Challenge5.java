package org.example.services;

/**
 * Classe responsável por inverter a ordem dos caracteres em uma string.
 */
public class Challenge5 {

    /**
     * Inverte os caracteres de uma string fornecida.
     *
     * Este método usa a técnica de troca de caracteres nas posições opostas da string
     * até que a string esteja completamente invertida.
     *
     * @param text A string que será invertida.
     * @return A string com os caracteres invertidos.
     */
    public static String inverter(String text) {
        char[] characters = text.toCharArray();
        int left = 0;
        int right = characters.length - 1;

        while (left < right) {
            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;

            left++;
            right--;
        }

        return new String(characters);
    }
}
