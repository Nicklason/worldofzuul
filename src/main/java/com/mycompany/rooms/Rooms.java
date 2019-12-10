package com.mycompany.rooms;

public enum Rooms {
    BIGCITY("bigcity", true),
    FACTORY("factory", false),
    FIELD("field", true),
    LAKE("lake", true),
    LOBBY("lobby", false),
    STREET("street", false),
    SUBURBS("suburbs", true);

    private String name;
    private boolean hasEndPicture;

    private Rooms (String name, boolean hasEndPicture) {
        this.name = name;
        this.hasEndPicture = hasEndPicture;
    }

    public String getName () {
        return this.name;
    }

    public boolean hasEndPicture () {
        return this.hasEndPicture;
    }
}
