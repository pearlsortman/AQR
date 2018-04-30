package com.aqr;

import com.google.common.base.Splitter;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @sampleInput P 1388534400000 MSFT 42.43
 * <p>
 * 1. Message type: This is always P for this file
 * 2. Milliseconds from the unix timestamp
 * 3. Symbol name
 * 4. Current price
 */
public class PriceUpdate {

    private static final Splitter SPACE_SPLITTER = Splitter.on(' ');
    private long timestamp;
    private String symbol;
    private BigDecimal currentPrice;

    /**
     *
     * @constructor
     * @param priceUpdate
     */
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
}
