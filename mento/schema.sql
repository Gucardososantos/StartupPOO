-- (Opcional, para testes/recriação)
DROP TABLE IF EXISTS decisao;
DROP TABLE IF EXISTS rodada;
DROP TABLE IF EXISTS startup;

CREATE TABLE IF NOT EXISTS startup (
    id IDENTITY PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    caixa DOUBLE,
    receita_base DOUBLE,
    reputacao INT,
    moral INT
);

CREATE TABLE IF NOT EXISTS rodada (
    id IDENTITY PRIMARY KEY,
    startup_id BIGINT NOT NULL,
    numero INT,
    receita DOUBLE,
    FOREIGN KEY (startup_id) REFERENCES startup(id)
);

CREATE TABLE IF NOT EXISTS decisao (
    id IDENTITY PRIMARY KEY,
    startup_id BIGINT NOT NULL,
    rodada INT,
    tipo VARCHAR(100),
    impacto VARCHAR(255),
    FOREIGN KEY (startup_id) REFERENCES startup(id)
);


/*Como rodar o SQL
Adicione esse script ao arquivo schema.sql dentro de src/main/resources/.

No Java, execute via JDBC/H2 assim:

java
try (Connection conn = DataSourceProvider.getConnection()) {
    String sql = new String(Files.readAllBytes(Paths.get("src/main/resources/schema.sql")));
    Statement stmt = conn.createStatement();
    stmt.execute(sql);
}