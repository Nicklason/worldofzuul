package worldofzuul;

public enum CommandWord {
    GO("go"), INVESTIGATE("see"), PICKUP("pickup"), INVENTORY("inv"), DROP("drop"), USE("use"), QUIT("quit"), HELP("help"), UNKNOWN("?");
    
    private String commandString;
    
    CommandWord (String commandString) {
        this.commandString = commandString;
    }
    
    public String toString () {
        return commandString;
    }
}
