package org.example.services;

/**
 * Classe responsável por calcular a porcentagem de representação de diferentes estados
 * em relação a um total de receita.
 */
public class Challenge4 {

    private double sp;
    private double rj;
    private double mg;
    private double es;
    private double outros;

    /**
     * Construtor da classe.
     * Inicializa os valores de receita de cada estado.
     *
     * @param sp a receita de São Paulo (SP).
     * @param rj a receita do Rio de Janeiro (RJ).
     * @param mg a receita de Minas Gerais (MG).
     * @param es a receita do Espírito Santo (ES).
     * @param outros a receita de outros estados.
     */
    public Challenge4(double sp, double rj, double mg, double es, double outros) {
        this.sp = sp;
        this.rj = rj;
        this.mg = mg;
        this.es = es;
        this.outros = outros;
    }

    /**
     * Calcula a receita total somando as receitas de todos os estados.
     *
     * @return a receita total.
     */
    public double calculateTotalRevenue() {
        return sp + rj + mg + es + outros;
    }

    /**
     * Calcula a porcentagem de um estado em relação à receita total.
     *
     * @param valueState o valor de receita de um estado específico.
     * @param totalRevenue a receita total.
     * @return a porcentagem da receita do estado em relação à receita total.
     */
    public double CalculatePercentage(double valueState, double totalRevenue) {
        return (valueState / totalRevenue) * 100;
    }

    /**
     * Exibe no console os percentuais de representação de cada estado em relação à receita total.
     */
    public void imprimirPercentuais() {
        double totalRevenue = calculateTotalRevenue();

        double percentageSP = CalculatePercentage(sp, totalRevenue);
        double percentageRJ = CalculatePercentage(rj, totalRevenue);
        double percentageMG = CalculatePercentage(mg, totalRevenue);
        double percentageES = CalculatePercentage(es, totalRevenue);
        double percentageOthers = CalculatePercentage(outros, totalRevenue);

        System.out.println("Percentual de representação de cada estado:");
        System.out.println("SP: " + String.format("%.2f", percentageSP) + "%");
        System.out.println("RJ: " + String.format("%.2f", percentageRJ) + "%");
        System.out.println("MG: " + String.format("%.2f", percentageMG) + "%");
        System.out.println("ES: " + String.format("%.2f", percentageES) + "%");
        System.out.println("Others: " + String.format("%.2f", percentageOthers) + "%");
    }
}
