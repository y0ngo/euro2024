package com.example.euros_new;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private java.sql.Connection connection;
    private Statement statement;

    public DBConnection() {
        String dbName = "euro_2024";
        String username = "root";
        String password = "password";
        String server = "127.0.0.1";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://" + server + "/" + dbName, username, password);
            this.statement = this.connection.createStatement();
        } catch (Exception var6) {
            var6.printStackTrace();
        }
    }
    public ResultSet selectQuery(String query) {
        ResultSet result = null;
        if (this.connection != null) {
            try {
                result = this.statement.executeQuery(query);
            } catch (SQLException var4) {
                var4.printStackTrace();
            }
        }

        return result;
    }
    public ResultSet selectQuery2(String query) {
        ResultSet result = null;
        if (this.connection != null) {
            try {
                result = this.statement.executeQuery(query);
            } catch (SQLException var4) {
                var4.printStackTrace();
            }
        }

        return result;
    }

    public int nonQuery(String nonQuery) {
        int result = 0;
        if (this.connection != null) {
            try {
                result = this.statement.executeUpdate(nonQuery);
            } catch (SQLException var4) {
                var4.printStackTrace();
            }
        }

        return result;
    }
}