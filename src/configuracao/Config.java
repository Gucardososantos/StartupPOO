package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private int totalRodadas;
    private int maxDecisoesPorRodada;

    public static Config loadFromProperties(String path) {
        Config config = new Config();
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream(path)) {
            props.load(in);
            config.totalRodadas = Integer.parseInt(props.getProperty("total.rodadas"));
            config.maxDecisoesPorRodada = Integer.parseInt(props.getProperty("max.decisoes.por.rodada"));
        } catch (IOException e) {
            throw new RuntimeException("Falha ao ler configurações", e);
        }
        return config;
    }

    public int getTotalRodadas() { return totalRodadas; }
    public int getMaxDecisoesPorRodada() { return maxDecisoesPorRodada; }
}