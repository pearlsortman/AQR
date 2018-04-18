package com.aqr.model;

import com.google.common.base.Splitter;

import java.math.BigDecimal;
import java.util.List;

/*
 * Example: P 1388534400000 MSFT 42.43
 *
 * 1. Message type: This is always P for this file
 * 2. Milliseconds from the unix timestamp
 * 3. Symbol name
 * 4. Current price
 *
 * */
public class PriceUpdate {

    private static final Splitter SPACE_SPLITTER = Splitter.on(' ');

    private static final String MSG_TYPE_P = "P";
    private long milliseconds;
    private String symbol;
    private BigDecimal currentPrice;

    public PriceUpdate(String priceUpdate) {
        List<String> splitStr = SPACE_SPLITTER.splitToList(priceUpdate);

        this.milliseconds = Long.parseLong(splitStr.get(1));
        this.symbol = splitStr.get(2);
        this.currentPrice = new BigDecimal(splitStr.get(3));
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }
}
