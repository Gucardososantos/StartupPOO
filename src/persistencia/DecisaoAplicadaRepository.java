package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DecisaoAplicadaRepository {
    public void salvarDecisao(int rodada, String startupNome, String decisao) {
        try (Connection conn = DataSourceProvider.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO DECISAO_APLICADA (num_rodada, startup_nome, decisao) VALUES (?, ?, ?)");
            ps.setInt(1, rodada);
            ps.setString(2, startupNome);
            ps.setString(3, decisao);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
