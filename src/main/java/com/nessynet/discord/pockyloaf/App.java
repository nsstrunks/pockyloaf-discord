package com.nessynet.discord.pockyloaf;

import com.nessynet.discord.pockyloaf.helpers.PropertyHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.util.DiscordException;

/**
 * Created by nss on 6/3/2016.
 */
public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        Pockyloaf pockyloaf = new Pockyloaf();
        PropertyHelper propHelper = PropertyHelper.getInstance();
        ClientBuilder builder = new ClientBuilder().withToken(propHelper.getProperty("discord.token"));
        pockyloaf.run(builder);

        while(true) {
            if(!Pockyloaf.client.isReady()) {
                try {
                    logger.info("Starting Pockyloaf...");
                    pockyloaf.run(builder);
                } catch (Exception e) {
                    logger.error("Pockyloaf is unhappy: ", e);
                }
            }
            Thread.sleep(5000);
        }
    }
}
