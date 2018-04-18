package com.aqr;

import com.aqr.model.FillOrder;
import com.aqr.model.PriceUpdate;

import java.io.*;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

public class PNLApplication {

    public static void main(String[] args) throws IOException {
        FileInputStream inputStreamFills = null;
        GZIPInputStream gzipInputStreamFills = null;
        Scanner scFills = null;

        FileInputStream inputStreamPrices = null;
        GZIPInputStream gzipInputStreamPrices = null;
        Scanner scPrices = null;

        try {
            File fills = new File(args[0]);
            inputStreamFills = new FileInputStream(fills);
            gzipInputStreamFills = new GZIPInputStream(inputStreamFills);
            scFills = new Scanner(gzipInputStreamFills, "UTF-8");

            File prices = new File(args[1]);
            inputStreamPrices = new FileInputStream(prices);
            gzipInputStreamPrices = new GZIPInputStream(inputStreamPrices);
            scPrices = new Scanner(gzipInputStreamPrices, "UTF-8");

            parseFills(scFills);
            parsePrices(scPrices);
        } finally {
            if (inputStreamFills != null) inputStreamFills.close();
            if (inputStreamPrices != null) inputStreamPrices.close();

            if (gzipInputStreamFills != null) gzipInputStreamFills.close();
            if (gzipInputStreamPrices != null) gzipInputStreamPrices.close();

            if (scFills != null) scFills.close();
            if (scPrices != null) scPrices.close();
        }
    }

    private static void parseFills(Scanner scFills) throws IOException {
        while (scFills.hasNextLine()) {
            String fill = scFills.nextLine();
            FillOrder fillOrder = new FillOrder(fill);
        }

        if (scFills.ioException() != null) {
            throw scFills.ioException();
        }
    }

    private static void parsePrices(Scanner scPrices) throws IOException {
        while (scPrices.hasNextLine()) {
            String price = scPrices.nextLine();
            PriceUpdate priceUpdate = new PriceUpdate(price);
        }

        if (scPrices.ioException() != null) {
            throw scPrices.ioException();
        }
    }
}
