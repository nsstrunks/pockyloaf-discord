package com.nessynet.discord.pockyloaf.model;

import java.util.Arrays;

/**
 * Created by nss on 6/3/2016.
 */
public class JishoWord {

    private JishoMeta meta;
    private JishoData[] data;

    public JishoMeta getMeta() {
        return meta;
    }

    public void setMeta(JishoMeta meta) {
        this.meta = meta;
    }

    public JishoData[] getData() {
        return data;
    }

    public void setData(JishoData[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Jishoword " + Arrays.toString(data) + "";
    }

}
