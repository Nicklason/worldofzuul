package com.mycompany.worldofzuul;

import java.util.Scanner;

public class Parser {
    private CommandWords commands;

    public Parser () {
        commands = new CommandWords();
    }

    public Command getCommand (String inputLine) {
        String word1 = null;
        String word2 = null;

        System.out.print("> "); 

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next(); 
            }
        }

        tokenizer.close();

        return new Command(commands.getCommandWord(word1), word2);
    }
}
