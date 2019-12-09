package com.mycompany.pointsofinterest;

public enum PointsOfInterest {
    BILLBOARD("billboard", "The billboard can be used to show a photo", "Your photo is now being viewed on the billboard by many people, hopefully they change their minds now"),
    BOAT("boat", "The boats engine is leaking into the water and contaminating it" , "You used the boots to get out and fix the leaking boat engine.", "Funfact:\nOne liter of oil can contaminate approx 947000 liters of water, making it undrinkable and unusable."),
    BOY("boy", "“Oh no, I have been playing with the waterpump and the handle came off! My mom's going to kill me!“"),
    BRIDGE("bridge", "The bridge is falling apart, maybe there is something useful"),
    CONTAINER("container", "Maybe there is something useful in here", null, "Funfact:\nUnrecycled electronics often contain lead, barium, mercury and other heavy metals. Disposed of improperly, they eventually leak into the soil contaminating the groundwater."),
    FARMHOUSE("farmhouse", "It's an abandoned farmhouse, maybe there is something usefull in there"),
    GIRL("clair", "When you're done with your adventure come back to me and say finish"),
    IRRIGATION("irrigation", "The irrigation system is missing a pipe, water is spilling out on the ground", "You have fixed the irrigation system, water is not getting wasted anymore.", "Funfact:\nAs soon as a pipe starts leaking, from the first drip, about one litre water per minute is lost. That is about 40,000 litres a month."),
    LEAKINGPIPE("leakingpipe", "The pipeline is broken and is leaking chemicals on the ground and into the water.", "You have fixed the leaking pipe", "Funfact:\nSewage dumped into nature causes water bloom and bacteria growth. Raw sewage was dumped into popular beaches in Great Britain 1830 times in summer 2019."),
    LOCKEDDOOR("door", "A locked door leading into the factory", "The keycard unlocked the door!"),
    MAP("map", "The map is showing enormous water requirements for producing 1 liter of cola","You took a picture and exposed their water spendage"),
    OLDMAN("oldman", "“Hey! Can you please get me some water? I'm really thirsty“", "You helped the old man get water and in return he gave you a keycard", "Funfact:\nFilling up a liter of water into a reused bottle from a local waterpump , costs our planet 1 liter water. Producing a liter Cola in a new plastic bottle requires approx 9 liters of water."),
    PESTICIDES("pesticides", "The open box of pesticides is laying on the ground, maybe you can move it?", "The pesticides have been moved from the ground and they are no longer contaminating the ground", "Funfact:\nDrinking water with agricultural chemical runoff can cause chronic diseases. In 2017 more than 100 kinds of pesticides were detected in different waterways in European nations."),
    STORE("store", "A line of shoppingcarts at the front of the store, they require a coin"),
    STREET("street", "This street leads through the suburbs"),
    VENDINGMACHINE("vendingmachine", "A cola vending machine, it requires a coin"),
    WATERPUMP("waterpump", "The handle is missing on the water pump", "The missing handle has been replaced and the water pump is now fully functional", "Funfact:\nConsidering that a pump with a garden hose can emit 22 - 50 liters of water per minute, playing with water for 10 minutes costs 500 liters of drinkable water.");

    private String name;
    private String description;
    private String successDescription;
    private String funfact;

    private PointsOfInterest(String name, String description) {
        this.name = name;
        this.description = description;
        this.successDescription = null;
        this.funfact = null;
    }

    private PointsOfInterest(String name, String description, String successDescription) {
        this.name = name;
        this.description = description;
        this.successDescription = successDescription;
        this.funfact = null;
    }

    private PointsOfInterest(String name, String description, String successDescription, String funfact) {
        this.name = name;
        this.description = description;
        this.successDescription = successDescription;
        this.funfact = funfact;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getSuccessDescription() {
        return this.successDescription;
    }

    public Boolean isFixable() {
        return this.successDescription != null;
    }

    public Boolean hasFunfact() {
        return this.funfact != null;
    }
    
    public String funFact(){
        return this.funfact;
    }
}
