package com.nessynet.discord.pockyloaf.events;

import sx.blah.discord.api.Event;
import sx.blah.discord.handle.obj.IMessage;

/**
 * Created by nss on 6/3/2016.
 */
public class DebugEvent extends Event {
    private final IMessage message;

    public DebugEvent(IMessage message) {
        this.message = message;
    }

    public IMessage getMessage() {
        return this.message;
    }
}