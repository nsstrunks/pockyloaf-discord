package com.nessynet.discord.pockyloaf.model;

/**
 * Created by nss on 6/3/2016.
 */

public class JishoAttribution {
    private boolean jmdict;
    private boolean jmnedict;
    private String dbpedia;

    public boolean isJmdict() {
        return jmdict;
    }

    public void setJmdict(boolean jmdict) {
        this.jmdict = jmdict;
    }

    public boolean isJmnedict() {
        return jmnedict;
    }

    public void setJmnedict(boolean jmnedict) {
        this.jmnedict = jmnedict;
    }

    public String getDbpedia() {
        return dbpedia;
    }

    public void setDbpedia(String dbpedia) {
        this.dbpedia = dbpedia;
    }
}
