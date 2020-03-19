package com.company;

public class Main {

    public static void main(String[] args) {

        Catalog catalog = new Catalog();

        Document fisier1 = new Document("fisier1", 1, "path", "C:\\Users\\simio\\Desktop\\fenrir.txt");

        Document fisier2 = new Document("fisier2", 2, "path", "C:\\Users\\simio\\Downloads\\engleza.pdf");

        Document link1 = new Document("link1", 3, "link", "https://www.google.com");

        catalog.AddDocument(fisier1);
        catalog.AddDocument(fisier2);
        catalog.AddDocument(link1);

        CatalogHandler handler = new CatalogHandler(catalog);
        handler.open(2);

        String backup = handler.save();

        CatalogHandler handler2 = new CatalogHandler((new Catalog()));

        handler2.load(backup);

        handler2.open(1);
    }
}
