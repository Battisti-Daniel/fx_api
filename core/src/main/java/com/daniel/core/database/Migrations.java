package com.daniel.core.database;

import com.daniel.core.database.migrations.CreateAccount;
import com.daniel.core.database.migrations.CreateServer;
import com.daniel.core.database.migrations.CreateTables;

public class Migrations {

    private CreateServer createServer = new CreateServer();
    private CreateTables createTables = new CreateTables();
    private CreateAccount createAccount = new CreateAccount();

    static Database db = new Database();

    private static void createDatabase(boolean delete) {

        if (delete) {
            String sqlDrop = "DROP DATABASE IF EXISTS " + "db_teste" + ";";
            try {
                Execute.run(sqlDrop, "database");
                System.out.println("Database deletado com sucesso!");
            } catch (Exception e) {
                throw new RuntimeException("Erro ao deletar database: " + e.getMessage());
            }

            try {
                String sql = "CREATE DATABASE " + "db_teste" + ";";

                Execute.run(sql , "database");

                System.out.println("Database criado com sucesso!");
            } catch (Exception e) {
                throw new RuntimeException("Erro ao criar database: " + e.getMessage());
            }
        }

    }

    public boolean makeMigration() {

        try {
            createDatabase(false);
            createTables.executeAll(true);
            createServer.executeAll();
            createAccount.executeAll();
            return true;
        } catch (Exception e) {
            System.out.println("Erro na migração: " + e.getMessage());
            return false;
        }

    }

}
