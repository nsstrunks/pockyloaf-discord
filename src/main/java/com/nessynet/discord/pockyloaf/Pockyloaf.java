package com.nessynet.discord.pockyloaf;

import com.nessynet.discord.pockyloaf.helpers.PropertyHelper;
import com.nessynet.discord.pockyloaf.listeners.DebugListener;
import com.nessynet.discord.pockyloaf.listeners.Dispatcher;
import com.nessynet.discord.pockyloaf.listeners.JishoListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;

/**
 * Created by nss on 6/3/2016.
 */
public class Pockyloaf {

    private static final Logger logger = LoggerFactory.getLogger(Pockyloaf.class);

    public static IDiscordClient client;

    public void run(ClientBuilder builder) throws DiscordException {
        logger.info("Creating new Discord client...");
        client = builder.login();
        logger.info("Discord client connected.");
        logger.info("Registering listeners...");
        client.getDispatcher().registerListener(new Dispatcher());
        client.getDispatcher().registerListener(new DebugListener());
        client.getDispatcher().registerListener(new JishoListener());
        logger.info("Listeners successfully registered.");
    }
}
