package com.company;

import java.sql.*;

public class AlbumController extends Controller{

    public void create(String name, int artistId, int releaseYear) {
        Database database = Database.getInstance();
        int id = -1;

        String command = "SELECT MAX(id) FROM albums";
        ResultSet resultSet = database.get(command);

        try {
            while (resultSet.next()) {
                id = Integer.parseInt(resultSet.getString(1));
            }
        } catch (Exception ignored) {
        }


        command = "INSERT INTO albums VALUES (" + Integer.toString(id + 1) + ", '" + name + "', " + artistId + ", " + releaseYear + ")";
        System.out.println(command);
        database.insert(command);
    }

    public void findByArtist(int artistId) {
        Database database = Database.getInstance();
        String command = "SELECT * FROM albums WHERE artist_id = " + artistId;
        System.out.println(command);
        ResultSet resultSet = database.get(command);
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
