package com.company;

import java.sql.*;

public class AlbumController extends Controller{

    public void create(String name, int artistId, int releaseYear) {
        Database db = Database.getInstance();
        int id = -1;

        String command = "SELECT MAX(id) FROM albums";
        ResultSet res = db.get(command);

        try {
            while (res.next()) {
                id = Integer.parseInt(res.getString(1));
            }
        } catch (Exception ignored) {
        }


        command = "INSERT INTO albums VALUES (" + Integer.toString(id + 1) + ", '" + name + "', " + artistId + ", " + releaseYear + ")";
        System.out.println(command);
        db.insert(command);
    }

    public void findByArtist(int artistId) {
        Database db = Database.getInstance();
        String command = "SELECT * FROM albums WHERE artist_id = " + artistId;
        System.out.println(command);
        ResultSet res = db.get(command);
        if (res != null) {
            try {
                while (res.next()) {
                    System.out.println(res.getString(1) + " " + res.getString(2) + " " + res.getString(3) + " " + res.getString(4));
                }
            } catch (Exception ignored) {
            }

        }
    }
}
