package com.aqr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

public class PNLApplication {

    public static void main(String[] args) {
        File fillsFile;
        File pricesFile;
        Scanner fillsFileScanner = null;
        Scanner priceFileScanner = null;

        try {
            fillsFile = new File(args[0]);
            pricesFile = new File(args[1]);

            FillOrder fillOrder;
            fillsFileScanner = fileToScanner(fillsFile);

            while (fillsFileScanner.hasNextLine()) {
                fillOrder = new FillOrder(fillsFileScanner.nextLine());
                Portfolio.addFillOrderToQueue(fillOrder);
            }

            PriceUpdate priceUpdate;
            priceFileScanner = fileToScanner(pricesFile);

            while (priceFileScanner.hasNextLine()) {
                priceUpdate = new PriceUpdate(priceFileScanner.nextLine());
                Portfolio.processPriceUpdate(priceUpdate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fillsFileScanner != null) fillsFileScanner.close();
            if (priceFileScanner != null) priceFileScanner.close();
        }
    }

    /**
     *
     * @param file
     * @return Scanner
     * @throws IOException
     */
    private static Scanner fileToScanner(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);

        return new Scanner(gzipInputStream, "UTF-8");
    }
}
