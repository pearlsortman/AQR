package com.aqr;

import java.util.*;

public class Portfolio {

    private static List<FillOrder> fillOrderList = new LinkedList<>();
    private static Map<String, Position> positions = new HashMap<>();

    /**
     *
     * @param priceUpdate
     */
    public static void processPriceUpdate(PriceUpdate priceUpdate) {
        String symbol = priceUpdate.getSymbol();
        Position currentPosition;

        if (positions.containsKey(symbol)) {
            currentPosition = positions.get(symbol);
        } else {
            currentPosition = new Position();
            positions.put(symbol, currentPosition);
        }

        currentPosition.setCurrentPrice(priceUpdate.getCurrentPrice());

        executeFills(priceUpdate.getTimestamp(), priceUpdate.getSymbol());
        printPnlMessage(priceUpdate, currentPosition);
    }

    /**
     *
     * @param timestamp
     * @param symbol
     */
    private static void executeFills(long timestamp, String symbol) {
        Iterator<FillOrder> fillOrderListIterator = fillOrderList.listIterator();

        FillOrder currentFillOrder;
        Position currentPosition = positions.get(symbol);
        while (fillOrderListIterator.hasNext()) {
            currentFillOrder = fillOrderListIterator.next();

            if (currentFillOrder.getTimestamp() > timestamp) break;

            if (currentFillOrder.getSymbol().equals(symbol)) {
                currentPosition.executeOrder(currentFillOrder);
                fillOrderListIterator.remove();
            }
        }
    }

    /**
     *
     * @param priceUpdate
     * @param position
     */
    private static void printPnlMessage(PriceUpdate priceUpdate, Position position) {
        String pnlMessage = "PNL " + priceUpdate.getTimestamp()
                + " "  + priceUpdate.getSymbol()
                + " " + position.getQuantity()
                + " " + position.getMarkToMarketPL();
        System.out.println(pnlMessage);
    }

    /**
     *
     * @param fillOrder
     */
    public static void addFillOrderToQueue(FillOrder fillOrder) {
        fillOrderList.add(fillOrder);
    }
}
