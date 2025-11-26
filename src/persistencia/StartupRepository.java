package persistence;

import java.sql.*;
import model.Startup;

public class StartupRepository {
    public void salvar(Startup s) {
        try (Connection conn = DataSourceProvider.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO STARTUP (nome, caixa, receita_base, reputacao, moral) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, s.getNome());
            ps.setDouble(2, s.getCaixa().getValor());
            ps.setDouble(3, s.getReceitaBase().getValor());
            ps.setDouble(4, s.getReputacao().getValor());
            ps.setInt(5, s.getMoral().getValor());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
