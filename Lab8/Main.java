package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Database db = Database.getInstance();

        AlbumController albums = new AlbumController();
        ArtistController artists = new ArtistController();

        artists.create("Pitbull", "Mr Worldwide");
        artists.create("Nicu de la Cazanesti", "Cazanesti");
        artists.create("Adrian Minune", "Heaven");

        albums.create("England is my city", 14, 2019);
        albums.create("Melodie pe 2 voci", 15, 2018);
        albums.create("Hora in sat", 15, 2017);

        artists.findByName("Nicu de la Cazanesti");
        albums.findByArtist(15);
    }
}
