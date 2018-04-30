package com.aqr;

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
    private long timestamp;
    private String symbol;
    private BigDecimal currentPrice;

    PriceUpdate(String priceUpdate) {
        List<String> splitStr = SPACE_SPLITTER.splitToList(priceUpdate);

        this.timestamp = Long.parseLong(splitStr.get(1));
        this.symbol = splitStr.get(2);
        this.currentPrice = new BigDecimal(splitStr.get(3));
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    @Override
    public String toString() {
        return "PriceUpdate{" +
                "timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                ", currentPrice=" + currentPrice +
                '}';
    }
}
