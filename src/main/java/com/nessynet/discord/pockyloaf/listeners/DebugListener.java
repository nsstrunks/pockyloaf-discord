package com.nessynet.discord.pockyloaf.listeners;

import com.nessynet.discord.pockyloaf.Pockyloaf;
import com.nessynet.discord.pockyloaf.events.DebugEvent;
import com.nessynet.discord.pockyloaf.helpers.MessageBufferBuilder;
import com.nessynet.discord.pockyloaf.helpers.PropertyHelper;
import sx.blah.discord.api.EventSubscriber;

/**
 * Created by nss on 6/3/2016.
 */
public class DebugListener {

    @EventSubscriber
    public void messageReceived(DebugEvent event) {
        if (event.getMessage().getContent().startsWith("!channel")) {
            MessageBufferBuilder.sendMessage(Pockyloaf.client, event.getMessage().getChannel(),event.getMessage().getChannel().getName() + " [ " + event.getMessage().getChannel().getID() + " ]");
        } else if(event.getMessage().getContent().startsWith("!whoami")) {
            MessageBufferBuilder.sendMessage(Pockyloaf.client, event.getMessage().getChannel(), event.getMessage().getAuthor().getName() + " [ " + event.getMessage().getAuthor().getID() + " ]");
        } else if(event.getMessage().getContent().startsWith("!server")) {
            MessageBufferBuilder.sendMessage(Pockyloaf.client, event.getMessage().getChannel(), event.getMessage().getGuild().getName() + " [ " + event.getMessage().getGuild().getID() + " ]");
        } else if(event.getMessage().getContent().startsWith("!source")) {
            MessageBufferBuilder.sendMessage(Pockyloaf.client, event.getMessage().getChannel(), PropertyHelper.getInstance().getProperty("github.source"));
        }
    }
}
