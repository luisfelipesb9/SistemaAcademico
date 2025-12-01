package br.unimontes.ccet.dcc.pg1.model.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseSeeder {
    public static void main(String[] args) {
        seed();
    }

    public static void seed() {
        String sqlFile = "database_schema.sql";
        try (Connection conn = DB.getInstancia().getConnection();
                Statement stmt = conn.createStatement();
                BufferedReader br = new BufferedReader(new FileReader(sqlFile))) {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                // Remove full line comments
                if (line.trim().startsWith("--"))
                    continue;

                // Remove trailing comments
                int commentIndex = line.indexOf("--");
                if (commentIndex != -1) {
                    line = line.substring(0, commentIndex);
                }

                if (line.trim().isEmpty()) {
                    continue;
                }

                sb.append(line);
                if (line.trim().endsWith(";")) {
                    try {
                        stmt.execute(sb.toString());
                        System.out
                                .println("Executed: " + sb.toString().substring(0, Math.min(sb.length(), 50)) + "...");
                    } catch (SQLException e) {
                        System.err.println("Error executing: " + sb.toString() + "\n" + e.getMessage());
                    }
                    sb = new StringBuilder();
                } else {
                    sb.append("\n");
                }
            }
            System.out.println("Database seeded successfully!");

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
