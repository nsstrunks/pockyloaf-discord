package com.nessynet.discord.pockyloaf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.blah.discord.util.DiscordException;

/**
 * Created by nss on 6/3/2016.
 */
public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        Pockyloaf pockyloaf = new Pockyloaf();
        try {
            logger.info("Starting Pockyloaf...");
            pockyloaf.run();
        } catch (DiscordException e) {
            logger.error("Discord is unhappy: ",e);
        }
    }
}
