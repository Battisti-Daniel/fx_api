package com.daniel.core.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute {
    
    public static void run(String sql, String action) {

        try (Connection conn = Database.connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar " + action + ": " + e.getMessage());
        }

    }

}
