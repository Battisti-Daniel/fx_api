package com.daniel.core.database.migrations;

import java.util.List;
import com.daniel.core.database.Execute;

public class CreateTables {

    private static void createServer() {

        try {
            String sql = """
                    CREATE TABLE IF NOT EXISTS servers
                    (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        ip VARCHAR(15) NOT NULL,
                        status VARCHAR(10) NOT NULL
                    );""";

            Execute.run(sql, "table_servers");

            System.out.println("Tabela de servidores criada com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar tabela de servidores: " + e.getMessage());
        }

    }

    private static void createAccount() {

        try {
            String sql = """
                    CREATE TABLE IF NOT EXISTS account
                    (
                        id SERIAL PRIMARY KEY,
                        account VARCHAR(100) NOT NULL,
                        password VARCHAR(15) NOT NULL,
                        email VARCHAR(50) NOT NULL,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        validated BOOLEAN DEFAULT FALSE,
                        status VARCHAR(10) NOT NULL DEFAULT 'active'
                    );""";

            Execute.run(sql, "table_users");

            System.out.println("Tabela de usuários criada com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar tabela de usuários: " + e.getMessage());
        }

    }

    private static void dropTables(List<String> tableNames) {

        String sql = "";

        for (String tableName : tableNames) {
            sql = """
                    DROP TABLE IF EXISTS """
                    + " " + tableName +
                    ";";
            Execute.run(sql, "table_" + tableName);
            System.out.println("Tabela " + tableName + " deletada com sucesso!");
        }

    }

    private void createAllTables() {
        createServer();
        createAccount();
    }

    public void executeAll(boolean delete) {

        List<String> tableNames = List.of(
                "servers",
                "account"
            );

        try {
            if (delete) {
                dropTables(tableNames);
            }
            createAllTables();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao popular tabela de servidores: " + e.getMessage());
        }
    }

}
