package com.nessynet.discord.pockyloaf.helpers;

import java.util.Arrays;

/**
 * Created by nss on 6/3/2016.
 */
public class CommandHelper {

    private static final CommandHelper instance = new CommandHelper();

    private CommandHelper() {}

    public static CommandHelper getInstance() {
        return instance;
    }


    public String stripCommand(String command) {
        String[] messageParts = command.split(" ");
        String[] searchKeywordParts = Arrays.copyOfRange(messageParts,1,messageParts.length);
        return Arrays.toString(searchKeywordParts).substring(1,Arrays.toString(searchKeywordParts).length()-1);
    }
}
