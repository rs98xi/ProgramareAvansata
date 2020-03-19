package com.company;

import java.util.ArrayList;
import java.util.List;

public class Catalog implements java.io.Serializable{
    List<Document> listOfDocuments;


    public Catalog()
    {
        this.listOfDocuments = new ArrayList<>();
    }

    void AddDocument(Document doc)
    {
        listOfDocuments.add(doc);
    }

    Document GetDocument(int index)
    {
        return listOfDocuments.get(index);
    }
}
