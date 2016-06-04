package com.nessynet.discord.pockyloaf.model;

/**
 * Created by nss on 6/3/2016.
 */
public class JishoJapanese {
    private String word;
    private String reading;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    @Override
    public String toString() {
        return "{"+word+", "+reading+"}";
    }
}

