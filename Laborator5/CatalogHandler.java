package com.company;

import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class CatalogHandler {
    private Catalog catalog;
    private Desktop desktop;

    public CatalogHandler(Catalog catalog) {
        this.catalog = catalog;
        desktop = Desktop.getDesktop();
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String save() {
        String fisier = "backup.ser";
        try {
            FileOutputStream fileHandler = new FileOutputStream(fisier);
            ObjectOutputStream outputHandler = new ObjectOutputStream(fileHandler);

            outputHandler.writeObject(catalog);

            outputHandler.close();
            fileHandler.close();

            System.out.println("Succes! - Backup Object");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fisier;
    }

    public void load(String path) {
        try {
            FileInputStream fileHandler = new FileInputStream(path);
            ObjectInputStream inputHandler = new ObjectInputStream(fileHandler);

            catalog = (Catalog) inputHandler.readObject();

            inputHandler.close();
            fileHandler.close();
            System.out.println("Succes! Loading Object");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void open(int index) {
        Document doc = catalog.getDocument(index);

        String type = doc.getType();
        String key;

        key = doc.getTag(type);

        if (type.equals("path")) {
            File file = new File(key);
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                desktop.browse(new URL(key).toURI());
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }
        }

    }
}
