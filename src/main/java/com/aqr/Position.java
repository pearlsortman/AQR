package com.aqr;

import java.math.BigDecimal;

public class Position {

    private int quantity;
    private BigDecimal cash;
    private BigDecimal currentPrice;

    /**
     *
     * @constructor
     */
    Position() {
        this.quantity = 0;
        this.cash = BigDecimal.ZERO;
        this.currentPrice = BigDecimal.ZERO;
    }

    public void setCurrentPrice(BigDecimal price) {
        this.currentPrice = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getMarkToMarketPL() {
        return cash.add(currentPrice.multiply(new BigDecimal(quantity)));
    }

    public void executeOrder(FillOrder fillOrder) {
        int orderSize = fillOrder.getFillSize();
        BigDecimal orderTotal = fillOrder.getFillPrice().multiply(new BigDecimal(orderSize));

        if (fillOrder.isBuy()) {
            cash = cash.subtract(orderTotal);
            quantity += orderSize;
        } else {
            cash = cash.add(orderTotal);
            quantity -= orderSize;
        }
    }
}
