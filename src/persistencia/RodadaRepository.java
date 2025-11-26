package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RodadaRepository {
    public void salvarRodada(int rodada, String startupNome) {
        try (Connection conn = DataSourceProvider.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO RODADA (num_rodada, startup_nome) VALUES (?, ?)");
            ps.setInt(1, rodada);
            ps.setString(2, startupNome);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    // Outros métodos de persistência conforme seu schema.
}
