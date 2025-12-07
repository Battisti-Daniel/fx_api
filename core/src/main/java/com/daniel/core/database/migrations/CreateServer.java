package com.daniel.core.database.migrations;

import java.util.ArrayList;
import java.util.List;

public class CreateServer {

    private List<Object> insertServer(String tableName) {
        List<Object> args = new ArrayList<>();

        int id = 1;
        String ip = "192.168.0.1";
        String name = "Helioboros";
        String status = "active";

        String sql = "INSERT INTO " + tableName + " (" +
                "id, " +
                "name, " +
                "ip," +
                "status) " +
                "VALUES (?, ?, ?, ?);";

        args.add(sql);
        args.add(id);
        args.add(name);
        args.add(ip);
        args.add(status);

        return args;

    }

        private List<Object> insertServer2(String tableName) {
        List<Object> args = new ArrayList<>();

        int id = 2;
        String ip = "192.168.0.0";
        String name = "Server_Test";
        String status = "offline";

        String sql = "INSERT INTO " + tableName + " (" +
                "id, " +
                "name, " +
                "ip," +
                "status) " +
                "VALUES (?, ?, ?, ?);";

        args.add(sql);
        args.add(id);
        args.add(name);
        args.add(ip);
        args.add(status);

        return args;

    }

    public boolean executeAll() {

        try {

            ExecuteInsert.execute("Criar servidor de teste", insertServer("servers"), 4);
            ExecuteInsert.execute("Criar servidor de teste", insertServer2("servers"), 4);
            System.out.println("Tabela de servidores populada com sucesso!");
            return true;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao popular tabela de servidores: " + e.getMessage());
        }

    }

}
