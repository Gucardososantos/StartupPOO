package engine;

import model.Startup;
import java.util.*;

public class ScoreService {

    // Calcula o score final para uma startup
    public int calcularScoreFinal(Startup s) {
        // Exemplo: peso em cada indicador — ajuste a fórmula conforme sua definição!
        int score = 
            (int) (s.getCaixa().getValor() * 0.1 +
                   s.getReceitaBase().getValor() * 0.3 +
                   s.getReputacao().getValor() * 2  +
                   s.getMoral().getValor() * 1.5);
        return score;
    }

    // Gera o ranking final, ordenado por score decrescente
    public List<Startup> ordenarPorScore(List<Startup> startups) {
        startups.sort((a, b) -> Integer.compare(calcularScoreFinal(b), calcularScoreFinal(a)));
        return startups;
    }
}
