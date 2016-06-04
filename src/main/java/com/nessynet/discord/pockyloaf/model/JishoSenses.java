package com.nessynet.discord.pockyloaf.model;

import java.util.Arrays;

/**
 * Created by nss on 6/3/2016.
 */
public class JishoSenses {
    private String[] english_definitions;
    private String[] parts_of_speech;
    private JishoLink[] links;
    private String[] tags;
    private String[] restrictions;
    private String[] see_also;
    private String[] antonyms;
    private String[] source;
    private String[] info;
    private String[] sentences;

    public String[] getEnglish_definitions() {
        return english_definitions;
    }

    public void setEnglish_definitions(String[] english_definitions) {
        this.english_definitions = english_definitions;
    }

    public String[] getParts_of_speech() {
        return parts_of_speech;
    }

    public void setParts_of_speech(String[] parts_of_speech) {
        this.parts_of_speech = parts_of_speech;
    }

    public JishoLink[] getLinks() {
        return links;
    }

    public void setLinks(JishoLink[] links) {
        this.links = links;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String[] getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String[] restrictions) {
        this.restrictions = restrictions;
    }

    public String[] getSee_also() {
        return see_also;
    }

    public void setSee_also(String[] see_also) {
        this.see_also = see_also;
    }

    public String[] getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(String[] antonyms) {
        this.antonyms = antonyms;
    }

    public String[] getSource() {
        return source;
    }

    public void setSource(String[] source) {
        this.source = source;
    }

    public String[] getInfo() {
        return info;
    }

    public void setInfo(String[] info) {
        this.info = info;
    }

    public String[] getSentences() {
        return sentences;
    }

    public void setSentences(String[] sentences) {
        this.sentences = sentences;
    }

    @Override
    public String toString() {
        return "{" + Arrays.toString(english_definitions) + "}";
    }
}