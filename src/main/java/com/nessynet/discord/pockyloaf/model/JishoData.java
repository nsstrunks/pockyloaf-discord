package com.nessynet.discord.pockyloaf.model;

import java.util.Arrays;

/**
 * Created by nss on 6/3/2016.
 */
public class JishoData {
    private boolean is_common;
    private String[] tags;
    private JishoJapanese[] japanese;
    private JishoSenses[] senses;
    private JishoAttribution attribution;

    public boolean is_common() {
        return is_common;
    }

    public void setIs_common(boolean is_common) {
        this.is_common = is_common;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public JishoJapanese[] getJapanese() {
        return japanese;
    }

    public void setJapanese(JishoJapanese[] japanese) {
        this.japanese = japanese;
    }

    public JishoSenses[] getSenses() {
        return senses;
    }

    public void setSenses(JishoSenses[] senses) {
        this.senses = senses;
    }

    public JishoAttribution getAttribution() {
        return attribution;
    }

    public void setAttribution(JishoAttribution attribution) {
        this.attribution = attribution;
    }

    @Override
    public String toString() {
        return "{" + Arrays.toString(japanese) + ", " + Arrays.toString(senses) + "}";
    }

}
