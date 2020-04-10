package com.company;

import java.sql.ResultSet;

public class ArtistController extends Controller{

    public void create(String name, String country) {
        Database db = Database.getInstance();
        int id = -1;


        String command = "SELECT MAX(id) FROM artists";
        ResultSet res = db.get(command);

        try {
            while (res.next()) {
                id = Integer.parseInt(res.getString(1));
            }
        } catch (Exception ignored) {
        }


        command = "INSERT INTO artists VALUES (" + Integer.toString(id + 1) + ", '" + name + "', '" + country + "')";
        System.out.println(command);
        db.insert(command);
    }

    public void findByName(String name) {
        Database db = Database.getInstance();
        String command = "SELECT * from artists WHERE name = '" + name + "'";
        System.out.println(command);
        ResultSet res = db.get(command);

        if (res != null) {
            try {
                while (res.next()) {
                    System.out.println(res.getString(1) + " " + res.getString(2) + " " + res.getString(3));
                }
            } catch (Exception ignored) {
            }

        }
    }
}
