package com.aqr.model;

import java.math.BigDecimal;

/*
* Example: PNL 1420063200000 MSFT 48100 -61888.51
*
* 1. Message type: This is always PNL for this file
* 2. Milliseconds from the unix timestamp
* 3. Symbol name
* 4. Signed Size Owned
* 5. Mark to Market P&L
*
* */
public class PNL {

    private static final String MSG_TYPE_PNL = "PNL";
    private long milliseconds;
    private String symbol;
    private int sizeOwned;
    private BigDecimal markToMarketPL;

    public PNL(long milliseconds, String symbol, int sizeOwned, BigDecimal markToMarketPL) {
        this.milliseconds = milliseconds;
        this.symbol = symbol;
        this.sizeOwned = sizeOwned;
        this.markToMarketPL = markToMarketPL;
    }

    @Override
    public String toString() {
        return "PNL " +
                milliseconds + " "
                + symbol + " "
                + sizeOwned + " "
                + markToMarketPL + " ";
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

    public int getSizeOwned() {
        return sizeOwned;
    }

    public void setSizeOwned(int sizeOwned) {
        this.sizeOwned = sizeOwned;
    }

    public BigDecimal getMarkToMarketPL() {
        return markToMarketPL;
    }

    public void setMarkToMarketPL(BigDecimal markToMarketPL) {
        this.markToMarketPL = markToMarketPL;
    }
}
