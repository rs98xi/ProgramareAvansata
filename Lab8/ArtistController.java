package com.company;

import java.sql.ResultSet;

public class ArtistController extends Controller{

    public void create(String name, String country) {
        Database database = Database.getInstance();
        int id = -1;


        String command = "SELECT MAX(id) FROM artists";
        ResultSet resultSet = database.get(command);

        try {
            while (resultSet.next()) {
                id = Integer.parseInt(resultSet.getString(1));
            }
        } catch (Exception ignored) {
        }


        command = "INSERT INTO artists VALUES (" + Integer.toString(id + 1) + ", '" + name + "', '" + country + "')";
        System.out.println(command);
        database.insert(command);
    }

    public void findByName(String name) {
        Database database = Database.getInstance();
        String command = "SELECT * from artists WHERE name = '" + name + "'";
        System.out.println(command);
        ResultSet resultSet = database.get(command);

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
