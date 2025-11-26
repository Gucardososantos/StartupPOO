package actions;

import model.Startup;

public class ProdutoStrategy implements DecisaoStrategy {
    @Override
    public void aplicar(Startup startup) {
        // Exemplo: aumenta receita base e reputação
        startup.getReceitaBase().incrementar(250);
        startup.getReputacao().incrementar(3);
    }
    @Override
    public String getNome() { return "Produto"; }
}
