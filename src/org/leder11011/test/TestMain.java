package org.leder11011.test;

import de.rhistel.logic.ConsoleReader;
import org.leder11011.logic.FileHandler;
import org.leder11011.model.Brand;
import org.leder11011.model.OperatingSystem;
import org.leder11011.model.Smartphone;
import org.leder11011.settings.AppCommands;
import org.leder11011.settings.AppTexts;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class TestMain {
//region Constants
//endregion

//region Attributs
//endregion

    //region Constructors
    private TestMain() {
    }
//endregion

//region Methods
    public static void main(String[] args){

        List<Smartphone> smartphoneList = FileHandler.getInstance().readFromCsvFile();
        for (Smartphone smartphone : smartphoneList) {
            System.out.println(smartphone);
        }

//        JFrame mainWindow = new JFrame("Test");
//
//        mainWindow.setLocation(400,  300);
//        mainWindow.setSize(400, 300);
//
//        JTextField inputField = new JTextField ("Hallo Welt");
//
//        JButton button = new JButton("Übernehmen");
//
//        JLabel label = new JLabel("Ausgabe");
//
//        JPanel container = new JPanel();
//
//
//        container.setLayout(new FlowLayout());
//
//        container.add(inputField);
//
//        container.add(button);
//        container.add(label);
//
//        mainWindow.add(container);
//
//        mainWindow.setVisible(true);
//

        //Schreiben
//        List<Smartphone> smartphoneList = TestData.generateTestData();
//        FileHandler.getInstance().writeToCsvFile(smartphoneList);


        //Smartphone über Konsole einlesen
        //Marke mittels String einlesen
//        System.out.println("Marke:");
//        String brandInput = ConsoleReader.in.readMandatoryString();
//        Brand brand = Brand.valueOf(brandInput);
//
//        //Modell mittels Auswahl einlesen
//        System.out.println("Modell:");
//        for (int i = 0; i < brand.getVariants().length; i++) {
//            System.out.printf("%s - %s\n", i, brand.getVariants()[i]);
//        }
//        int userChoice = ConsoleReader.in.readPositivInt();
//        if (userChoice >= brand.getVariants().length) return;
//        String model = brand.getVariants()[userChoice];
//
//        System.out.println("Speichergröße:");
//        int memorySize = ConsoleReader.in.readPositivInt();
//
//        System.out.println("Flashspeicher:");
//        int flash = ConsoleReader.in.readPositivInt();
//
//        System.out.println("Mobile Radio Standard:");
//        String mobileRadioStandard = ConsoleReader.in.readMandatoryString();
//
//
//        System.out.println("Operating System:");
//        String operatingSystem = ConsoleReader.in.readMandatoryString();
//        OperatingSystem myOperatingSystem = OperatingSystem.valueOf(operatingSystem);
//
//
//
//        Smartphone phone = new Smartphone(brand, model, memorySize, flash, mobileRadioStandard, myOperatingSystem);
//        System.out.println("Erzeugtes Smartphone: " + phone);
////
////
////
//        //Testen des Brand-Enums
//        Smartphone smartphone = new Smartphone();
//        smartphone.setBrandName(Brand.Nothing);
//
//        System.out.println(smartphone);
//
//        //Alle Objekte des Enums als Array beschaffen: Brand.values()
//        System.out.println(Arrays.toString(Brand.values()));
//
//        //Objekt des Enums mit einem bestimmten Namen (String) beschaffen
//        brand = Brand.valueOf("Apple");
//        System.out.println(brand);
//
//        //Name und Ordinalzahl (Arrayindex) eines Enum-Objektes
//        System.out.println(brand.name());
//        System.out.println(brand.ordinal());
//
//        //Modelle einer Marke beschaffen
//        System.out.println("Modelle von " + brand + ":");
//        System.out.println(Arrays.toString(brand.getVariants()));



        //test:
//        Smartphone smartphone = new Smartphone("Nothing", "Nothing Phone 2", 16, 512, "5G", "Android");
//        System.out.println(smartphone);
//        System.out.println(smartphone.getAmountFlash());


    }

//endregion


}
