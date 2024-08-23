package org.leder11011.logic;

import org.leder11011.model.Smartphone;
import org.leder11011.settings.AppTexts;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements logic for writing and reading files
 *
 */
public class FileHandler {

    //region Konstanten
    public static final String CSV_FILE_PATH = "resources/smartphones.csv";
    //endregion

    //region Attribute
    private static FileHandler instance;
    //endregion

    //region Konstruktoren
    private FileHandler() {

    }
    //endregion

    //region Methoden
    public static synchronized FileHandler getInstance() {
        if (instance == null) instance = new FileHandler();
        return instance;
    }

    public synchronized void writeToCsvFile(List<Smartphone> smartphoneList) {
        //Dateiobjekt erzeugen
        File csvFile = new File(CSV_FILE_PATH);

        //Schreiben
        try (
                FileOutputStream fos = new FileOutputStream(csvFile); //Brücke zur Datei, schreibt Bytes
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8); //Schreibt String mit Zeichensatz
                BufferedWriter out = new BufferedWriter(osw); // Schreibt performant mit einem Zwischenspeicher
        ) {

            for (Smartphone smartphone : smartphoneList) {
                out.write(smartphone.getPropertiesAsCsvLine());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(AppTexts.TXT_FILE_NOT_FOUND);
        }
    }

    public synchronized List<Smartphone> readFromCsvFile() {

        //Leere Liste erzeugen
        List<Smartphone> smartphoneList = new ArrayList<>();

        //Datei-Objekt erzeugen
        File csvFile = new File(CSV_FILE_PATH);

        //Lesen
        try (
                FileInputStream fis = new FileInputStream(csvFile);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader in = new BufferedReader(isr);
        ) {

            boolean eof = false;
            while (!eof) {

                String csvLine = in.readLine();

                if (csvLine != null) {
                    Smartphone smartphone = new Smartphone(csvLine);
                    smartphoneList.add(smartphone);
                    continue;
                }

                eof = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(AppTexts.TXT_FILE_NOT_FOUND);
        }

        //Liste zurückgeben
        return smartphoneList;
    }
    //endregion
}
