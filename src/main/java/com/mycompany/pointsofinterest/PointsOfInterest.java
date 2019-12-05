package com.mycompany.pointsofinterest;

public enum PointsOfInterest {
    BILLBOARD("billboard", "A billboard, can be used to show a photo", "Your photo is now being viewed by many people, hopefully they change their minds now"),
    BOAT("boat", "You see a boat in the sea. The boats engine is leaking into the water and the water surrounding the boat is contaminated", "you used the boots to get out and fix the leaking boat engine.", "One liter of oil can contaminate ca. 947000 litters of water, making both undrinkable and unusable."),
    BOY("boy", "Oh no, I have been playing with the waterpump and the handle came off! My mom's going to kill me!"),
    BRIDGE("bridge", "A small bridge is falling apart, maybe there is something useful?"),
    CONTAINER("container", "Garbage container, maybe there is something useful"),
    FARMHOUSE("farmhouse", "An abandoned farmhouse, maybe something usefull"),
    GIRL("clair", "When you are done with your adventure come back to me and say finish"),
    IRRIGATION("irrigation", "The irrigation system is missing a pipe, water is running out on the ground", "You have fixed the irrigation system, water is not getting wasted anymore.", "As soon as a pipe starts leaking, from the first drip, about one litre water per minute is lost. That is about 40,000 litres a month."),
    LEAKINGPIPE("leakingpipe", "A pipeline is broken and leaking chemicals on the ground and into the water.", "You have fixed the leaking pipe", "Sewage dumped into nature causes water bloom and bacteria growth. Raw sewage was dumped into popular beaches in Great Britain 1830 times in summer 2019."),
    LOCKEDDOOR("door", "A locked door leading into the factory", "You have used the keycard to unlock the door"),
    MAP("map", "map showing enormus water requirements for producing 1 liter of cola", "you took a picture and exposed the water spendage"),
    OLDMAN("oldman", "Oldman: Hey can you please get me some water im really thirsty", "you helped the old man get water in return he gave you a keycard", "Filling up a liter of water from a local waterpump into a reused bottle, costs our planet 1 liter water. Producing a liter Cola in a new plastic bottle requires ca. 9 liters of water."),
    PESTICIDES("pesticides", "an open box of pesticides is laying on the ground, if on you could move it", "You have moved the pesticides from the ground they are no longer contaminating the ground", "Drinking water with agricultural chemical runoff can cause chronic diseases. In 2017 more than 100 kinds of pesticides were detected in different waterways in European nations."),
    STORE("store", "A grocery store, there is a line of shoppingcarts at the front they require a coin"),
    STREET("street", "You are standing at the street leading through the suburbs"),
    VENDINGMACHINE("vendingmachine", "A cola vending machine, it requires a coin"),
    WATERPUMP("waterpump", "A handle is missing on the water pump", "You have replaced the missing handle, the water pump is now fully functional", "Considering that a pump with a garden hose can emit 22 - 50 liters of water per minute, playing with water for 10 minutes costs 500 liters of drinkable water.");

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
