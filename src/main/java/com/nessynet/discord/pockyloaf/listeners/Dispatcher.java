package com.nessynet.discord.pockyloaf.listeners;

import com.nessynet.discord.pockyloaf.events.DebugEvent;
import com.nessynet.discord.pockyloaf.events.JishoEvent;
import sx.blah.discord.api.EventSubscriber;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

/**
 * Created by nss on 6/3/2016.
 */
public class Dispatcher {

    @EventSubscriber
    public void onMessage(MessageReceivedEvent event) {
        String content = event.getMessage().getContent().toLowerCase();
        if (content.startsWith("!jisho")) {
            event.getClient().getDispatcher().dispatch(new JishoEvent(event.getMessage()));
        } else if (content.startsWith("!whoami")
                || content.startsWith("!channel")
                || content.startsWith("!server")
                || content.startsWith("!source")) {
            event.getClient().getDispatcher().dispatch(new DebugEvent(event.getMessage()));
        }
    }
}
