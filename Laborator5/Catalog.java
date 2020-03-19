package com.company;

import java.util.ArrayList;
import java.util.List;

public class Catalog implements java.io.Serializable {
    private List<Document> listOfDocuments;


    public Catalog() {
        this.listOfDocuments = new ArrayList<>();
    }

    void addDocument(Document doc) {
        if (doc == null) {
            return;
        }
        listOfDocuments.add(doc);
    }

    Document getDocument(int index) {
        return listOfDocuments.get(index);
    }
}
