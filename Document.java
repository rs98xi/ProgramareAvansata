package com.company;
import java.util.HashMap;
import java.util.Map;

public class Document implements java.io.Serializable{
    String type;
    Map<String, String>  map;

    public Document(String nume, int ID, String type, String value) {
        if(!type.equals("link") && !type.equals("path"))
            throw new IllegalArgumentException(
                    "Invalid argument");

        this.type = type;

        map = new HashMap<>();
        map.put("name", nume);
        map.put("ID", Integer.toString(ID));
        map.put(type, value);
    }

    public String getType() {
        return type;
    }

    void addTag(String key, String value)
    {
        map.put(key, value);
    }

    String getTag(String key)
    {
        return map.get(key);
    }

}
