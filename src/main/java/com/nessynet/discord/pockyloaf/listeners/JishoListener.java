package com.nessynet.discord.pockyloaf.listeners;

import com.nessynet.discord.pockyloaf.Pockyloaf;
import com.nessynet.discord.pockyloaf.events.JishoEvent;
import com.nessynet.discord.pockyloaf.helpers.CommandHelper;
import com.nessynet.discord.pockyloaf.helpers.MessageBufferBuilder;
import com.nessynet.discord.pockyloaf.model.JishoData;
import com.nessynet.discord.pockyloaf.model.JishoWord;
import com.nessynet.discord.pockyloaf.services.JishoDictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.blah.discord.api.EventSubscriber;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * Created by nss on 6/3/2016.
 */
public class JishoListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(JishoListener.class);

    @EventSubscriber
    public void messageReceived(JishoEvent event) throws UnsupportedEncodingException {
        LOGGER.info("{} triggered a jisho event: {}", event.getMessage().getAuthor().getName(), event.getMessage().getContent());
        String command = event.getMessage().getContent();
        JishoDictionary dictionary = JishoDictionary.getInstance();
        if (event.getMessage().getContent().startsWith("!jisho")) {
            String commandQuery = CommandHelper.getInstance().stripCommand(command);
            LOGGER.debug("Making external call to Jisho.org for: {}", commandQuery);
            JishoWord word = dictionary.search(commandQuery);
            StringBuilder response = new StringBuilder();
            if (word != null && word.getData().length > 0) {
                JishoData data = word.getData()[0];
                if (data.getJapanese() != null && data.getJapanese().length > 0 && data.getSenses() != null && data.getSenses().length > 0) {
                    String partsofspeech = Arrays.toString(data.getSenses()[0].getParts_of_speech());
                    if (data.getJapanese()[0].getWord() == null || data.getJapanese()[0].getWord().length() == 0) {
                        response.append("**" + data.getJapanese()[0].getReading() + "** - " + partsofspeech.substring(1, partsofspeech.length() - 1) + "\n");
                    } else {
                        response.append("**" + data.getJapanese()[0].getWord() + "** [" + data.getJapanese()[0].getReading() + "] - " + partsofspeech.substring(1, partsofspeech.length() - 1) + "\n");
                    }
                    response.append("```");
                    for (int i = 1; i <= data.getSenses().length; i++) {
                        String definitions = Arrays.toString(data.getSenses()[i - 1].getEnglish_definitions());
                        response.append("  " + i + ") " + definitions.substring(1, definitions.length() - 1) + "\n");
                    }
                    response.append("```\n");
                    response.append("Learn more: <http://jisho.org/search/" + URLEncoder.encode(commandQuery, "UTF-8") + ">");
                }
            } else {
                response.append("Sorry, '" + commandQuery + "' was not be found in Jisho.org");
            }
            MessageBufferBuilder.sendMessage(Pockyloaf.client, event.getMessage().getChannel(), response.toString());
        }
    }

}
