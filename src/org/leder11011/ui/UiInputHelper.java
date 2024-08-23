package org.leder11011.ui;

import de.rhistel.logic.ConsoleReader;
import org.leder11011.model.Brand;
import org.leder11011.model.MobileRadioStandard;
import org.leder11011.model.OperatingSystem;

import java.util.Arrays;

public class UiInputHelper {
    //region Constants
    //endregion

    //region Attributs
    //endregion

    //region Constructors
    public UiInputHelper() {
    }

    static createSmartphone getCreateSmartphone(Brand brand, MobileRadioStandard mobileRadioStandard, OperatingSystem operatingSystem) {
        int flash;
        String enterMobileRadioStandard;
        int ram;
        String enterBrand;
        String enterOperatingSystem;
        String model;
        System.out.println("\nCREATE:\n");

        System.out.println("Brand:");

        System.out.println(Arrays.toString(Brand.values()));

        boolean continueLoop = true;

        do {

            enterBrand = ConsoleReader.in.readMandatoryString();

            try {
                brand = Brand.valueOf(enterBrand);
            } catch (IllegalArgumentException exception) {

                System.out.println("Illegal Brand Name!");

                continue;
            }

            continueLoop = false;

        } while (continueLoop);

        System.out.println();


        //Modell mittels Auswahl einlesen
        System.out.println("Model:");

        System.out.println(Arrays.toString(brand.getVariants()));

        for (int i = 0; i < brand.getVariants().length; i++) {
            System.out.printf("%s - %s\n", i, brand.getVariants()[i]);
        }
        int userChoice = ConsoleReader.in.readPositivInt();
        if (userChoice >= brand.getVariants().length) return null;
        model = brand.getVariants()[userChoice];

        System.out.println();

        System.out.println("RAM:");

        ram = ConsoleReader.in.readPositivInt();

        System.out.println();

        System.out.println("Flash:");

        flash = ConsoleReader.in.readPositivInt();

        System.out.println();

        System.out.println("Mobile radio standard:");

        System.out.println(Arrays.toString(MobileRadioStandard.values()));


        continueLoop = true;

        do {

            enterMobileRadioStandard = ConsoleReader.in.readMandatoryString();

            if (enterMobileRadioStandard.equals("5G")){
                mobileRadioStandard=MobileRadioStandard.Five_G;
            } else if (enterMobileRadioStandard.equals("4G")) {
                mobileRadioStandard = MobileRadioStandard.Four_G;
            } else {

                System.out.println("Illegal Radio Name!");
                continue;
            }


            continueLoop = false;

        } while (continueLoop);

        System.out.println();


        System.out.println();

        System.out.println("Operating System:");

        System.out.println(Arrays.toString(OperatingSystem.values()));


        continueLoop = true;

        do {

            enterOperatingSystem = ConsoleReader.in.readMandatoryString();

            try {
                operatingSystem = OperatingSystem.valueOf(enterOperatingSystem);
            } catch (IllegalArgumentException exception) {

                System.out.println("Illegal OS Name!");

                continue;
            }

            continueLoop = false;

        } while (continueLoop);

        System.out.println();
        createSmartphone result = new createSmartphone(brand, model, ram, flash, mobileRadioStandard, operatingSystem);
        return result;
    }

    record createSmartphone(Brand brand, String model, int ram, int flash, MobileRadioStandard mobileRadioStandard, OperatingSystem operatingSystem) {
    }
    //endregion

    //region Methods
    //endregion


}
