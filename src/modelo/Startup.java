package model;

import model.vo.Dinheiro;
import model.vo.Percentual;
import model.vo.Humor;

public class Startup {
    private String nome;
    private Dinheiro caixa;
    private Dinheiro receitaBase;
    private Percentual reputacao;
    private Humor moral;
    private int rodadaAtual;

    public Startup(String nome, Dinheiro caixa, Dinheiro receitaBase, Percentual reputacao, Humor moral) {
        this.nome = nome;
        this.caixa = caixa;
        this.receitaBase = receitaBase;
        this.reputacao = reputacao;
        this.moral = moral;
        this.rodadaAtual = 1;
    }

    // Getters e setters
    public String getNome() { return nome; }
    public Dinheiro getCaixa() { return caixa; }
    public Dinheiro getReceitaBase() { return receitaBase; }
    public Percentual getReputacao() { return reputacao; }
    public Humor getMoral() { return moral; }
    public int getRodadaAtual() { return rodadaAtual; }

    public void avancarRodada() { this.rodadaAtual++; }

    // Métodos de negócio para atualizar indicadores
    public void aplicarDeltas(Deltas delta) {
        this.caixa = new Dinheiro(this.caixa.getValor() + delta.getDeltaCaixa());
        this.receitaBase = new Dinheiro(this.receitaBase.getValor() + delta.getDeltaReceitaBase());
        this.reputacao = new Percentual(this.reputacao.getValor() + delta.getDeltaReputacao());
        this.moral = new Humor(this.moral.getValor() + delta.getDeltaMoral());
    }
}
