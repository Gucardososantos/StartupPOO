package actions;

import model.Startup;

public class CortarCustosStrategy implements DecisaoStrategy {
    @Override
    public void aplicar(Startup startup) {
        // Exemplo: aumenta caixa, mas reduz moral
        startup.getCaixa().incrementar(500);
        startup.getMoral().incrementar(-15); // Reduz moral
    }
    @Override
    public String getNome() { return "Cortar Custos"; }
}
