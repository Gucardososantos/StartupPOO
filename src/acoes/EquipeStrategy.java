package actions;

import model.Startup;

public class EquipeStrategy implements DecisaoStrategy {
    @Override
    public void aplicar(Startup startup) {
        // Exemplo: melhora moral e um pouco reputação
        startup.getMoral().incrementar(10);
        startup.getReputacao().incrementar(2);
    }
    @Override
    public String getNome() { return "Equipe"; }
}
