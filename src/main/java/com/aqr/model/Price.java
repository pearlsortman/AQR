package com.aqr.model;

import java.util.Objects;

public class Price {

    private char msgType;
    private long ms;
    private String symbol;
    private float price;

    public Price(long ms, String symbol, float price) {
        this.msgType = 'P';
        this.ms = ms;
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price1 = (Price) o;
        return msgType == price1.msgType &&
                ms == price1.ms &&
                Float.compare(price1.price, price) == 0 &&
                Objects.equals(symbol, price1.symbol);
    }

    @Override
    public int hashCode() {

        return Objects.hash(msgType, ms, symbol, price);
    }

    @Override
    public String toString() {
        return "Price{" +
                "msgType=" + msgType +
                ", ms=" + ms +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }

    public char getMsgType() {
        return msgType;
    }

    public void setMsgType(char msgType) {
        this.msgType = msgType;
    }

    public long getMs() {
        return ms;
    }

    public void setMs(long ms) {
        this.ms = ms;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
