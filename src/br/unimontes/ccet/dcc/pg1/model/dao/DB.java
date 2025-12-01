package br.unimontes.ccet.dcc.pg1.model.dao;

import java.sql.*;

public class DB {
    private String url = "jdbc:mariadb://localhost/sistema_academico";
    private Connection db;
    private static DB instancia;

    private DB() throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        db = DriverManager.getConnection(url, "root", "");
    }

    public static DB getInstancia() throws SQLException {
        if (instancia == null)
            instancia = new DB();
        return instancia;
    }

    public Connection getConnection() {
        try {
            if (db == null || db.isClosed()) {
                db = DriverManager.getConnection(url, "root", "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return db;
    }
}
