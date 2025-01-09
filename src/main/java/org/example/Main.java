package org.example;

import org.example.services.Challenge1;
import org.example.services.Challenge2;
import org.example.services.Challenge3;
import org.example.services.Challenge4;

import java.util.Scanner;

import static org.example.services.Challenge5.inverter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Desafio 1:");
        Challenge1 challenge1 = new Challenge1();
        challenge1.sumVariable();

        System.out.println();

        System.out.println("Desafio 2:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int numberToCheck = Integer.parseInt(scanner.nextLine());
        Challenge2 challenge2 = new Challenge2(numberToCheck);
        challenge2.printResult();

        System.out.println();

        System.out.println("Desafio 3:");
        String jsonFilePath = "dados.json";
        Challenge3 revenueObj = new Challenge3(jsonFilePath);
        revenueObj.printResults();

        System.out.println();

        System.out.println("Desafio 4:");
        Challenge4 faturamento = new Challenge4(67836.43, 36678.66, 29229.88, 27165.48, 19849.53);
        faturamento.imprimirPercentuais();

        System.out.println();

        System.out.println("Desafio 5:");
        System.out.print("Informe a string: ");
        String input = scanner.nextLine();
        System.out.println();
        String resultado = inverter(input);
        System.out.println("String invertida: " + resultado);

        scanner.close();
    }
}