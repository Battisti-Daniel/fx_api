package database.migrations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import database.Database;

public class ExecuteInsert {
    public static boolean execute(String objective, List<Object> sql, int argsQuantity) {

        try (Connection conn = Database.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql.get(0).toString())) {

            for (int i = 1; i <= argsQuantity; i++) {
                System.out.println(sql.get(i));
                pstmt.setObject(i, sql.get(i));
            }

            int insertInfo = pstmt.executeUpdate();

            System.out.println(objective + " executado, " + insertInfo + " linhas afetadas.");

            return true;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao executar " + objective + ": " + e.getMessage());
        }

    }


}
