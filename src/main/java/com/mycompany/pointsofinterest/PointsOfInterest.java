package com.mycompany.pointsofinterest;

public enum PointsOfInterest {
    BILLBOARD("billboard", "The billboard can be used to show a photo", "Your photo is now being viewed on the billboard by many people, hopefully they change their minds now"),
    BOAT("boat", "The boat's engine is leaking into the water and contaminating it", "You used the boots to get out and fix the leaking boat engine.", "Fun fact:\nOne liter of oil can contaminate approx 947000 liters of water, making it undrinkable and unusable."),
    BOY("boy", "“Oh no, I have been playing with the waterpump and the handle came off! My mom's going to kill me!“"),
    BRIDGE("bridge", "The bridge is falling apart, maybe there is something useful"),
    CONTAINER("container", "A garbage container - maybe there is something useful?", "You have removed recycable electronics from the household waste container", "Fun fact:\nUnrecycled electronics often contain lead, barium, mercury and other heavy metals. Disposed of improperly, they eventually leak into the soil contaminating the groundwater."),
    FARMHOUSE("farmhouse", "An abandoned farmhouse - maybe there is something useful?"),
    GIRL("clair", "When you're done with your adventure come back to me"),
    IRRIGATION("irrigation", "The irrigation system is missing a pipe and water is spilling out on the ground", "You have fixed the irrigation system, water is not getting wasted anymore.", "Fun fact:\nAs soon as a pipe starts leaking, from the first drip, about one litre water per minute is lost. That is about 40,000 litres a month."),
    LEAKINGPIPE("leakingpipe", "The pipeline is broken and is leaking chemicals onto the ground and into the water.", "You have fixed the leaking pipe", "Fun fact:\nSewage dumped into nature causes water bloom and bacteria growth. Raw sewage was dumped into popular beaches in Great Britain 1830 times in summer 2019."),
    LOCKEDDOOR("door", "A locked door leading into the cola factory", "The keycard unlocked the door!"),
    MAP("documents", "These documents contain the recipe for cola, showing that there are enormous water requirements for producing 1 liter of cola", "You took a picture and exposed their water spendage"),
    OLDMAN("oldman", "Oldman: Hey can you please get me some water im really thirsty", "you helped the old man get water", "Funfact:\nFilling up a liter of water from a local waterpump into a reused bottle, costs our planet 1 liter water. Producing a liter Cola in a new plastic bottle requires ca. 9 liters of water."),
    PESTICIDES("pesticides", "The open box of pesticides is laying on the ground, maybe you can move it?", "The pesticides have been moved from the ground and they are no longer contaminating the ground", "Funfact:\nDrinking water with agricultural chemical runoff can cause chronic diseases. In 2017 more than 100 kinds of pesticides were detected in different waterways in europe."),
    STORE("store", "A line of shopping carts"),
    STREET("street", "This street leads through the suburbs"),
    VENDINGMACHINE("vendingmachine", "A cola vending machine"),
    WATERPUMP("waterpump", "The handle is missing on the water pump", "The missing handle has been replaced and the water pump is now fully functional", "Fun fact:\nConsidering that a pump with a garden hose can emit 22 - 50 liters of water per minute, playing with water for 10 minutes wastes 500 liters of drinkable water.");

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
