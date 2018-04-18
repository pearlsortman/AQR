package com.aqr.model;

import java.util.Objects;

public class Fill {

    private char msgType;
    private long ms;
    private String symbol;
    private float price;
    private long size;
    private char fillType;

    public Fill(long ms, String symbol, float price, long size, char fillType) {
        this.msgType = 'F';
        this.ms = ms;
        this.symbol = symbol;
        this.price = price;
        this.size = size;
        this.fillType = fillType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fill)) return false;
        Fill fill = (Fill) o;
        return msgType == fill.msgType &&
                ms == fill.ms &&
                Float.compare(fill.price, price) == 0 &&
                size == fill.size &&
                fillType == fill.fillType &&
                Objects.equals(symbol, fill.symbol);
    }

    @Override
    public int hashCode() {

        return Objects.hash(msgType, ms, symbol, price, size, fillType);
    }

    @Override
    public String toString() {
        return "Fill{" +
                "msgType=" + msgType +
                ", ms=" + ms +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", fillType=" + fillType +
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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public char getFillType() {
        return fillType;
    }

    public void setFillType(char fillType) {
        this.fillType = fillType;
    }
}
