package engine;

import config.Config;
import model.Startup;
import ui.ConsoleApp;
import persistence.StartupRepository;
import report.CSVExporter;

import java.util.List;

public class GameEngine {
    private final Config config;
    private final List<Startup> startups;
    private final StartupRepository repo = new StartupRepository();

    public GameEngine(Config config, List<Startup> startups) {
        this.config = config;
        this.startups = startups;
    }

    public void run() {
        // Loop principal de rodadas (simulação simplificada)
        for (int rodada = 1; rodada <= config.getTotalRodadas(); rodada++) {
            ConsoleApp.mostrarIndicadores(startups, rodada);
            // Ações fictícias para simulação
        }
        System.out.println("Jogo finalizado!");
    }

    public void gerarRelatorio() {
        CSVExporter.exportRanking(startups, "relatorio_ranking.csv");
        System.out.println("(Ranking salvo em relatorio_ranking.csv!)");
    }
}