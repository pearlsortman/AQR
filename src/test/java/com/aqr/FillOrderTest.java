package com.aqr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FillOrderTest {

    @Test
    void inputStringShouldSplitAndParseCorrectly() {
        String str = "F 1388534400000 MSFT 42.43 300 B";
        FillOrder fillOrder = new FillOrder(str);

        assertEquals("MSFT", fillOrder.getSymbol());
        assertEquals(42.43, fillOrder.getFillPrice().doubleValue());
        assertEquals(300, fillOrder.getFillSize());
        assertEquals(true, fillOrder.isBuy());
    }
}