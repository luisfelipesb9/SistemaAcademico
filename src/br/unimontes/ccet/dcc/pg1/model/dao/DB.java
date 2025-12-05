package br.unimontes.ccet.dcc.pg1.model.dao;

import java.sql.*;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DB {
    private static Properties props = new Properties();
    private static String url;
    private Connection db;
    private static DB instancia;

    private DB() throws SQLException {
        try (InputStream input = DB.class.getResourceAsStream("/db.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
                url = "jdbc:mariadb://localhost/sistema_academico";
            } else {
                props.load(input);
                url = props.getProperty("db.url");
            }
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        String user = props.getProperty("db.user", "root");
        String password = props.getProperty("db.password", "");

        db = DriverManager.getConnection(url, user, password);
    }

    public static DB getInstancia() throws SQLException {
        if (instancia == null)
            instancia = new DB();
        return instancia;
    }

    public Connection getConnection() {
        try {
            if (db == null || db.isClosed()) {
                String user = props.getProperty("db.user", "root");
                String password = props.getProperty("db.password", "");
                db = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return db;
    }
}
