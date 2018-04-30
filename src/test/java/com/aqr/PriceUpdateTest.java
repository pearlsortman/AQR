package com.aqr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceUpdateTest {

    @Test
    void inputStringShouldSplitAndParseCorrectly() {
        String str = "P 1388534400 MSFT 42.43";
        PriceUpdate priceUpdate = new PriceUpdate(str);

        assertEquals("MSFT", priceUpdate.getSymbol());
        assertEquals(1388534400, priceUpdate.getTimestamp());
        assertEquals(42.43, priceUpdate.getCurrentPrice().doubleValue());
    }
}
