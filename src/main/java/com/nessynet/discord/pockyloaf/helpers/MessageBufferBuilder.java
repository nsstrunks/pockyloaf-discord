package com.nessynet.discord.pockyloaf.helpers;

import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MessageBuilder;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RequestBuffer;

/**
 * Created by nss on 6/3/2016.
 */
public class MessageBufferBuilder {

    public static MessageBufferBuilder instance = new MessageBufferBuilder();

    private MessageBufferBuilder() {}

    public MessageBufferBuilder getInstance() {
        return instance;
    }

    public static void sendMessage(IDiscordClient client, IChannel channel, String content) {
        RequestBuffer.request(() -> {
            try {
                new MessageBuilder(client).withChannel(channel).withContent(content).build();
            } catch (DiscordException | MissingPermissionsException e) {
                e.printStackTrace();
            }
            return null;
        });
    }
}
