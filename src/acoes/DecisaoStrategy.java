package actions;

import model.Startup;

public interface DecisaoStrategy {
    void aplicar(Startup startup);
    String getNome();
}