package com.nessynet.discord.pockyloaf.services;

import com.nessynet.discord.pockyloaf.helpers.PropertyHelper;
import com.nessynet.discord.pockyloaf.model.JishoWord;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nss on 6/3/2016.
 */
public class JishoDictionary {

    private static JishoDictionary instance = new JishoDictionary();

    private static PropertyHelper propertyHelper = PropertyHelper.getInstance();

    private static final Logger logger = LoggerFactory.getLogger(JishoDictionary.class);

    private JishoDictionary() {}

    public static JishoDictionary getInstance() {
        return instance;
    }

    public JishoWord search(String searchString) {
        String baseUrl = propertyHelper.getProperty("jisho.url");

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getClasses().add(JacksonJsonProvider.class);
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);

        String url = baseUrl+"search/words";
        WebResource webResource = client.resource(url).queryParam("keyword",searchString);
        logger.info("Querying external: {}", webResource.getURI().toString());
        ClientResponse response = webResource.get(ClientResponse.class);
        JishoWord jishoWord = response.getEntity(JishoWord.class);

        logger.info("Matched {} to {}",searchString,jishoWord);

        return jishoWord;
    }
}
