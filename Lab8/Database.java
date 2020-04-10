package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Database {
    private static Database singleton = null;
    public static Connection con;

    public static Database getInstance() {
        if (singleton == null) {
            singleton = new Database();
            try {
                con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dba_temp","sql");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return singleton;
    }

    public void insert(String command)
    {
        try {
            Statement myStmt = con.createStatement();
            myStmt.executeUpdate(command);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet get(String command)
    {
        try {
            Statement myStmt = con.createStatement();
            return myStmt.executeQuery(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Database() {
    }
}
