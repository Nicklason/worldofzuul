package com.mycompany.rooms;

public enum Rooms {
    BIGCITY("bigcity", "in the bigcity"),
    FACTORY("factory", "At the factory"),
    FIELD("field", "At the field"),
    LAKE("lake", "At the lake"),
    LOBBY("lobby", "In the Lobby Start/End"),
    STREET("street", "In the street"),
    SUBURBS("suburbs", "In the suburban neighbourhood");

    private String name;
    private String description;

    private Rooms (String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName () {
        return this.name;
    }

    public String getDescription () {
        return this.description;
    }
}
