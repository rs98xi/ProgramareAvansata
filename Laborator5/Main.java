package com.company;

public class Main {

    public static void main(String[] args) {

        Catalog catalog = new Catalog();

        Document fisier1 = null;
        Document fisier2 = null;
        Document link1 = null;
        try {
            fisier1 = new Document("fisier1", 1, "path", "C:\\Users\\simio\\Desktop\\fenrir.txt");

            fisier2 = new Document("fisier2", 2, "path", "C:\\Users\\simio\\Downloads\\engleza.pdf");

            link1 = new Document("link1", 3, "link", "https://www.google.com");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        catalog.addDocument(fisier1);
        catalog.addDocument(fisier2);
        catalog.addDocument(link1);

        CatalogHandler handler = new CatalogHandler(catalog);
        handler.open(2);

        String backup = handler.save();

        CatalogHandler handler2 = new CatalogHandler((new Catalog()));

        handler2.load(backup);

        handler2.open(1);
    }
}
