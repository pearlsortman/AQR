package com.aqr.model;

import com.google.common.base.Splitter;

import java.math.BigDecimal;
import java.util.List;

/*
* Example: F 1388534400000 MSFT 42.43 300
*
* 1. Message type: This is always F for this file
* 2. Milliseconds from the unix epoch
* 3. Symbol name
* 4. Fill Price
* 5. Fill size
* 6. Side indicator (B for buy and S for sell)
*
* */
public class FillOrder {

    private static final Splitter SPACE_SPLITTER = Splitter.on(' ');

    private static final String MSG_TYPE_F = "F";
    private long milliseconds;
    private String symbol;
    private BigDecimal fillPrice;
    private int fillSize;
    private String fillType;

    public FillOrder(String fill) {
        List<String> splitStr = SPACE_SPLITTER.splitToList(fill);

        this.milliseconds = Long.parseLong(splitStr.get(1));
        this.symbol = splitStr.get(2);
        this.fillPrice = new BigDecimal(splitStr.get(3));
        this.fillSize = Integer.parseInt(splitStr.get(4));
        this.fillType = splitStr.get(5);
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

    public BigDecimal getFillPrice() {
        return fillPrice;
    }

    public void setFillPrice(BigDecimal fillPrice) {
        this.fillPrice = fillPrice;
    }

    public int getFillSize() {
        return fillSize;
    }

    public void setFillSize(int fillSize) {
        this.fillSize = fillSize;
    }

    public String getFillType() {
        return fillType;
    }

    public void setFillType(String fillType) {
        this.fillType = fillType;
    }
}
