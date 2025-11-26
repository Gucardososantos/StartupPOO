package actions;

import model.Startup;

public class InvestidoresStrategy implements DecisaoStrategy {
    @Override
    public void aplicar(Startup startup) {
        // Exemplo: recebe dinheiro (caixa) e reputação
        startup.getCaixa().incrementar(2000);
        startup.getReputacao().incrementar(1);
    }
    @Override
    public String getNome() { return "Investidores"; }
}
