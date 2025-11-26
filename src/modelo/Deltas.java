package model;

public class Deltas {
    private double deltaCaixa;
    private double deltaReceitaBase;
    private double deltaReputacao;
    private int deltaMoral;

    public Deltas(double deltaCaixa, double deltaReceitaBase, double deltaReputacao, int deltaMoral) {
        this.deltaCaixa = deltaCaixa;
        this.deltaReceitaBase = deltaReceitaBase;
        this.deltaReputacao = deltaReputacao;
        this.deltaMoral = deltaMoral;
    }

    public double getDeltaCaixa() { return deltaCaixa; }
    public double getDeltaReceitaBase() { return deltaReceitaBase; }
    public double getDeltaReputacao() { return deltaReputacao; }
    public int getDeltaMoral() { return deltaMoral; }
}
