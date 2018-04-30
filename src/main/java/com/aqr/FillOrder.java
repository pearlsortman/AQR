package com.aqr;

import com.google.common.base.Splitter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @sampleInput F 1388534400000 MSFT 42.43 300
 * <p>
 * 1. Message type: This is always F for this file
 * 2. Milliseconds from the unix epoch
 * 3. Symbol name
 * 4. Fill Price
 * 5. Fill size
 * 6. Side indicator (B for buy and S for sell)
 */
public class FillOrder {

    private static final Splitter SPACE_SPLITTER = Splitter.on(' ');
    private long timestamp;
    private String symbol;
    private BigDecimal fillPrice;
    private int fillSize;
    private boolean isBuy; // 1=Buy/0=Sell

    /**
     *
     * @constructor
     * @param fill
     */
    FillOrder(String fill) {
        List<String> splitStr = SPACE_SPLITTER.splitToList(fill);

        this.timestamp = Long.parseLong(splitStr.get(1));
        this.symbol = splitStr.get(2);
        this.fillPrice = new BigDecimal(splitStr.get(3));
        this.fillSize = Integer.parseInt(splitStr.get(4));
        this.isBuy = splitStr.get(5).equals("B");
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getFillPrice() {
        return fillPrice;
    }

    public int getFillSize() {
        return fillSize;
    }

    public boolean isBuy() {
        return isBuy;
    }
}
