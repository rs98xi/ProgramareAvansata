package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Database {
    private static Database singleton = null;
    public static Connection connection = null;

    public static Database getInstance() {
        if (singleton == null) {
            singleton = new Database();
            try {
                connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dba_temp","sql");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return singleton;
    }

    public void insert(String command)
    {
        try {
            Statement connectionStatement = connection.createStatement();
            connectionStatement.executeUpdate(command);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet get(String command)
    {
        try {
            Statement connectionStatement = connection.createStatement();
            return connectionStatement.executeQuery(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Database() {
    }
}
