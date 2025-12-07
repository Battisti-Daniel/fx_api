package com.daniel.core.database.migrations;

import java.util.ArrayList;
import java.util.List;

public class CreateAccount {

    private List<Object> insertServer(String tableName) {
        List<Object> args = new ArrayList<>();

        int id = 1;
        String user = "admin";
        String password = "admin##";
        String email = "admin@example.com";

        String sql = "INSERT INTO " + tableName + " (" +
                "id, " +
                "account, " +
                "password," +
                "email) " +
                "VALUES (?, ?, ?, ?);";

        args.add(sql);
        args.add(id);
        args.add(user);
        args.add(password);
        args.add(email);

        return args;

    }

    public boolean executeAll() {

        try {

            ExecuteInsert.execute("Criar conta de teste", insertServer("account"), 4);
            System.out.println("Tabela de contas populada com sucesso!");
            return true;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao popular tabela de contas: " + e.getMessage());
        }

    }
    
}
