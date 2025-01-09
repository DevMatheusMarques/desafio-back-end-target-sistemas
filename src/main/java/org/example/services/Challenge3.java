package org.example.services;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

/**
 * Classe responsável por carregar e processar os dados de faturamento diário de um arquivo JSON.
 * A classe calcula o faturamento mínimo, máximo, a média mensal e o número de dias com faturamento acima da média.
 */
public class Challenge3 {

    private double[] dailyRevenue;

    /**
     * Construtor da classe.
     * Inicializa o array de faturamento diário carregando os dados de um arquivo JSON.
     *
     * @param jsonFilePath o caminho do arquivo JSON contendo os dados de faturamento.
     */
    public Challenge3(String jsonFilePath) {
        this.dailyRevenue = loadRevenueDataFromJson(jsonFilePath);
    }

    /**
     * Carrega os dados de faturamento diário de um arquivo JSON.
     * O arquivo JSON deve estar localizado no diretório de recursos.
     *
     * @param filePath o caminho do arquivo JSON a ser lido.
     * @return um array contendo os valores de faturamento diário.
     */
    private double[] loadRevenueDataFromJson(String filePath) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            if (inputStream == null) {
                throw new IOException("Arquivo não encontrado: " + filePath);
            }

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

            JSONArray revenueArray = new JSONArray(stringBuilder.toString());

            double[] revenues = new double[revenueArray.length()];
            for (int i = 0; i < revenueArray.length(); i++) {
                JSONObject dayData = revenueArray.getJSONObject(i);
                revenues[i] = dayData.getDouble("valor");
            }
            return revenues;

        } catch (IOException e) {
            e.printStackTrace();
            return new double[0];
        }
    }

    /**
     * Calcula o faturamento mínimo diário, considerando apenas os valores positivos.
     *
     * @return o valor do faturamento mínimo diário, ou 0 se não houver faturamento positivo.
     */
    public double calculateMinRevenue() {
        double min = Double.MAX_VALUE;
        for (double revenue : dailyRevenue) {
            if (revenue > 0) {
                min = Math.min(min, revenue);
            }
        }
        return min == Double.MAX_VALUE ? 0 : min;
    }

    /**
     * Calcula o faturamento máximo diário, considerando apenas os valores positivos.
     *
     * @return o valor do faturamento máximo diário, ou 0 se não houver faturamento positivo.
     */
    public double calculateMaxRevenue() {
        double max = Double.MIN_VALUE;
        for (double revenue : dailyRevenue) {
            if (revenue > 0) {
                max = Math.max(max, revenue);
            }
        }
        return max == Double.MIN_VALUE ? 0 : max;
    }

    /**
     * Calcula a média mensal de faturamento, considerando apenas os valores positivos.
     *
     * @return a média mensal de faturamento, ou 0 se não houver faturamento positivo.
     */
    public double calculateMonthlyAverage() {
        double sum = 0;
        int count = 0;
        for (double revenue : dailyRevenue) {
            if (revenue > 0) {
                sum += revenue;
                count++;
            }
        }
        return count > 0 ? sum / count : 0;
    }

    /**
     * Conta o número de dias com faturamento acima da média mensal.
     *
     * @return o número de dias com faturamento superior à média mensal.
     */
    public int countDaysAboveAverage() {
        double average = calculateMonthlyAverage();
        int count = 0;
        for (double revenue : dailyRevenue) {
            if (revenue > average) {
                count++;
            }
        }
        return count;
    }

    /**
     * Exibe os resultados do processamento de faturamento.
     * Exibe o faturamento mínimo, máximo e o número de dias com faturamento acima da média.
     */
    public void printResults() {
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Faturamento mínimo diário: " + df.format(calculateMinRevenue()));
        System.out.println("Faturamento máximo diário: " + df.format(calculateMaxRevenue()));
        System.out.println("Número de dias com faturamento acima da média: " + countDaysAboveAverage());
    }
}
