package com.mycompany.items;

public enum Items {
    BOOTS("boots", "A pair of boots","Boots.png"),
    CAMERA("camera", "A digital camera","Camera.png"),
    COIN("coin", "A coin","Coin.png"),
    COLA("cola", "A can of cola","Cola.png"),
    EMPTYBOTTLE("emptybottle", "An empty bottle","EmptyBottle.png"),
    FILLEDBOTTLE("filledbottle", "A full bottle","FilledBottle.png"),
    KEYCARD("keycard", "A keycard","Keycard.png"),
    METALPATCH("metalpatch", "A metalpatch","MetalPatch.png"),
    PHOTO("photo", "A photo of the secret behind the production of cola","Photo.png"),
    PIPE("pipe", "A pipe","Pipe.png"),
    PUMPHANDLE("pumphandle", "A pumphandle","PumpHandle.png"),
    SHOPPINGCART("shoppingcart", "A shopping cart","ShoppingCart.png");

    private String name;
    private String description;
    private String imgPath;

    private Items (String name, String description, String imgPath) {
        this.name = name;
        this.description = description;
        this.imgPath = imgPath;
    }

    public String getName () {
        return this.name;
    }

    public String getDescription () {
        return this.description;
    }
    public String getImagePath () {
        return this.imgPath;
    }
}
