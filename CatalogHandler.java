package com.company;

import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class CatalogHandler {
    Catalog catalog;
    Desktop desktop;

    public CatalogHandler(Catalog catalog) {
        this.catalog = catalog;
        desktop =  Desktop.getDesktop();
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String save()
    {
        String filename = new String("backup.ser");
        try
        {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(catalog);

            out.close();
            file.close();

            System.out.println("Succes! - Backup Object");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return filename;
    }

    public void load(String path) {
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);

            catalog = (Catalog) in.readObject();

            in.close();
            file.close();
            System.out.println("Succes! Loading Object");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void open(int index){
        Document doc = catalog.GetDocument(index);

        String type = doc.getType();
        String key;

        key = doc.getTag(type);

        if(type.equals("path"))
        {
            File file = new File(key);
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else
        {
            try {
                desktop.browse(new URL(key).toURI());
            }
             catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }
        }

    }
}
