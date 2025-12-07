package com.daniel.core.database.migrations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.daniel.core.database.Database;

public class Get {

    private List<Map<String, String>> run(String sql, List<String> args) {

        List<Map<String, String>> result = new ArrayList<>();

        try (Connection conn = Database.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Map<String, String> row = new HashMap<>();

                for (String arg : args) {
                    row.put(arg, rs.getString(arg));
                }

                result.add(row);

            }

            return result;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar tabela: " + e.getMessage());
        }

    }

    public List<Map<String, String>> getServer(String tablename) {

        List<String> getServer = List.of(
                "SELECT * FROM " + tablename + " ORDER BY id;",
                "id",
                "name",
                "ip",
                "status");

        return execute(tablename, getServer);

    }

    public Map<String, String> getAccount(String tablename, String account, String password) {

        String sql = "SELECT account, password FROM " + tablename +
                " WHERE account = ? AND password = ?";

        try (Connection conn = Database.connect();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, account);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {

                if (!rs.next()) {
                    return null;
                }

                Map<String, String> row = new HashMap<>();
                row.put("account", rs.getString("account"));
                row.put("password", rs.getString("password"));
                return row;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter conta: " + e.getMessage());
        }
    }

    public List<Map<String, String>> execute(String tablename, List<String> getData) {

        List<Map<String, String>> results = new ArrayList<Map<String, String>>();

        try {

            List<Map<String, String>> result = run(getData.get(0), getData.subList(1, getData.size()));

            results.addAll(result);

            return results;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter contas: " + e.getMessage());

        }

    }

}
