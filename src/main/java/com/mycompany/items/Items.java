package com.mycompany.items;

public enum Items {
    BOOTS("boots", "A pair of boots"),
    CAMERA("camera", "A digital camera"),
    COIN("coin", "A coin"),
    COLA("cola", "A can of cola"),
    EMPTYBOTTLE("emptybottle", "An empty bottle"),
    FILLEDBOTTLE("filledbottle", "A full bottle"),
    KEYCARD("keycard", "A keycard"),
    METALPATCH("metalpatch", "A metalpatch"),
    PHOTO("photo", "A photo of the secret behind the production of cola"),
    PIPE("pipe", "A pipe"),
    PUMPHANDLE("pumphandle", "A pumphandle"),
    SHOPPINGCART("shoppingcart", "A shopping cart");

    private String name;
    private String description;

    private Items (String name, String description) {
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
