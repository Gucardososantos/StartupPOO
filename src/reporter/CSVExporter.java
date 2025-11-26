package report;

import model.Startup;
import engine.ScoreService;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CSVExporter {
    public static void exportRanking(List<Startup> startups, String filePath) {
        ScoreService scoreService = new ScoreService();
        try (PrintWriter pw = new PrintWriter(filePath, StandardCharsets.UTF_8)) {
            pw.println("Startup,Caixa,ReceitaBase,Reputacao,Moral,Score");
            for (Startup s : startups) {
                double score = scoreService.calcularScore(s);
                pw.println(s.getNome() + "," +
                        s.getCaixa().getValor() + "," +
                        s.getReceitaBase().getValor() + "," +
                        s.getReputacao().getValor() + "," +
                        s.getMoral().getValor() + "," +
                        score);
            }
        } catch (Exception e) {
            System.out.println("Erro ao exportar CSV: " + e.getMessage());
        }
    }
}
