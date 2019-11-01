package worldofzuul;

public enum CommandWord {
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), INVESTIGATE("see");
    
    private String commandString;
    
    CommandWord (String commandString) {
        this.commandString = commandString;
    }
    
    public String toString () {
        return commandString;
    }
}
