package ui;

import model.Startup;
import engine.GameEngine;
import engine.ScoreService;
import report.CSVExporter;
import java.util.*;

public class ConsoleApp {

    public void start(List<Startup> startups, boolean modoBot) {
        Scanner sc = new Scanner(System.in);
        GameEngine engine = new GameEngine();
        ScoreService scoreService = new ScoreService();
        String[] opcoes = {"MARKETING", "EQUIPE", "PRODUTO", "INVESTIDORES", "CORTARCUSTOS"};

        Random random = new Random(42); // Seed para resultados fixos

        for (Startup s : startups) {
            for (int rodada = 1; rodada <= 8; rodada++) { // ou pegue do Config
                s.setRodadaAtual(rodada);
                System.out.println("\nRodada " + rodada + " - " + s.getNome());
                System.out.println(s);

                int decisions = 0;
                while (decisions < 3) { // ou pegue do Config
                    String escolha;
                    if (modoBot) {
                        escolha = opcoes[random.nextInt(opcoes.length)];
                        System.out.println("BOT escolheu: " + escolha);
                    } else {
                        System.out.print("Sua escolha (ou NONE): ");
                        escolha = sc.nextLine().trim();
                    }
                    if (escolha.equalsIgnoreCase("NONE") || escolha.isEmpty()) break;
                    try {
                        engine.aplicarDecisao(s, escolha);
                        System.out.println("Decisão aplicada.");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    decisions++;
                }
                double receita = s.getReceitaBase().getValor() * (1.0 + s.getBonusPercentReceitaProx().getValor());
                s.setCaixa(new Dinheiro(s.getCaixa().getValor() + receita));
                s.setBonusPercentReceitaProx(new Percentual(0.0));
                System.out.println("Receita aplicada: R$" + String.format("%.2f", receita));
            }
        }
        // Exportação de CSV
        CSVExporter.exportRanking(startups, "relatorio_ranking.csv");
        sc.close();
    }
}
