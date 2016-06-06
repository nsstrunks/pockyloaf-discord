package com.nessynet.discord.pockyloaf.listeners;

import com.nessynet.discord.pockyloaf.Pockyloaf;
import com.nessynet.discord.pockyloaf.events.DebugEvent;
import com.nessynet.discord.pockyloaf.helpers.MessageBufferBuilder;
import com.nessynet.discord.pockyloaf.helpers.PropertyHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.blah.discord.api.EventSubscriber;

/**
 * Created by nss on 6/3/2016.
 */
public class DebugListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(DebugListener.class);

    @EventSubscriber
    public void messageReceived(DebugEvent event) {
        if (event.getMessage().getContent().startsWith("!channel")) {
            LOGGER.info("{} triggered a debug event: !channel",event.getMessage().getAuthor().getName());
            MessageBufferBuilder.sendMessage(Pockyloaf.client, event.getMessage().getChannel(),event.getMessage().getChannel().getName() + " [ " + event.getMessage().getChannel().getID() + " ]");
        } else if(event.getMessage().getContent().startsWith("!whoami")) {
            LOGGER.info("{} triggered a debug event: !whoami",event.getMessage().getAuthor().getName());
            MessageBufferBuilder.sendMessage(Pockyloaf.client, event.getMessage().getChannel(), event.getMessage().getAuthor().getName() + " [ " + event.getMessage().getAuthor().getID() + " ]");
        } else if(event.getMessage().getContent().startsWith("!server")) {
            LOGGER.info("{} triggered a debug event: !server",event.getMessage().getAuthor().getName());
            MessageBufferBuilder.sendMessage(Pockyloaf.client, event.getMessage().getChannel(), event.getMessage().getGuild().getName() + " [ " + event.getMessage().getGuild().getID() + " ]");
        } else if(event.getMessage().getContent().startsWith("!source")) {
            LOGGER.info("{} triggered a debug event: !source",event.getMessage().getAuthor().getName());
            MessageBufferBuilder.sendMessage(Pockyloaf.client, event.getMessage().getChannel(), PropertyHelper.getInstance().getProperty("github.source"));
        }
    }
}
