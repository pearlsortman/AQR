package com.aqr;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

    @Test
    void getMarkToMarketPL() {
        Position position = new Position();
        assertEquals(new BigDecimal(0), position.getMarkToMarketPL());
    }

    @Test
    void executeOrder() {
        Position position = new Position();
        FillOrder fillOrder = new FillOrder("F 1388534400000 MSFT 42.43 300 B");

        assertEquals(0, position.getQuantity(), "Quantity is zero prior to filling buy order");

        position.executeOrder(fillOrder);
        assertEquals(300, position.getQuantity(), "Quantity is now 300 after buy is filled");
    }
}