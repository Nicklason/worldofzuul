package worldofzuul;

public enum CommandWord {
    GO("go"), INVESTIGATE("see"), PICKUP("pickup"), QUIT("quit"), HELP("help"), UNKNOWN("?");
    
    private String commandString;
    
    CommandWord (String commandString) {
        this.commandString = commandString;
    }
    
    public String toString () {
        return commandString;
    }
}
