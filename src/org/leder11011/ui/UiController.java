package org.leder11011.ui;

import de.rhistel.logic.ConsoleReader;
import org.leder11011.logic.FileHandler;
import org.leder11011.model.Brand;
import org.leder11011.model.MobileRadioStandard;
import org.leder11011.model.OperatingSystem;
import org.leder11011.model.Smartphone;
import org.leder11011.settings.AppTexts;

import java.util.ArrayList;
import java.util.List;

import static org.leder11011.settings.AppCommands.*;

/**
 * Userinterface with console in- and output and runtime execution
 *
 */
public class UiController {

    public static List<Smartphone> smartphones = new ArrayList<>();

    private UiController() {
    }


    public static void runSmartphoneManagement() {

        printAppHeader();

        startMainLoop();
    }

    private static void startMainLoop() {

//        smartphones = TestData.generateTestData();

        //File read:
        smartphones = FileHandler.getInstance().readFromCsvFile();

        boolean continueApp = true;



        do {
            printMenu();

            switch (ConsoleReader.in.readPositivInt()) {

                case CREATE -> createSmartphone();
                case SHOW -> showSmartphones();
                case EDIT -> editSmartphones();
                case DELETE -> deleteSmartphones();

                case EXIT -> {continueApp = false;
                exitApp();}

                default -> System.out.println(AppTexts.MENU_INVALID_CHOICE);

            }


        } while (continueApp);

    }

    private static void exitApp() {
        System.out.println(AppTexts.TXT_PROGRAMM_EXITS);

        System.out.println(AppTexts.TXT_SAVE_SMARTPHONES);

        if (ConsoleReader.in.readMandatoryAnswerToBinaryQuestion()) {
            FileHandler.getInstance().writeToCsvFile(smartphones);
        }


    }

    private static void deleteSmartphones() {
        System.out.println("\nDELETE:\n");

        showSmartphones();

        System.out.println("Which number do you want to delete?");

        int userChoice = ConsoleReader.in.readPositivInt();

        if (userChoice >= smartphones.size()) return;


        System.out.println("Do you really want to delete? ");

        boolean delete = ConsoleReader.in.readMandatoryAnswerToBinaryQuestion();

        if (delete) {

            smartphones.remove(userChoice);

            System.out.println("Smartphone No. " + userChoice + " deleted!");

            //File write
            FileHandler.getInstance().writeToCsvFile(smartphones);

        } else {

            System.out.println("Delete canceled!");

        }


    }

    private static void editSmartphones() {


        Smartphone smartphone;

        String enterBrand;

        String enterModel;

        Brand brand = null;

        String model;

        int ram;
        int flash;

        String enterMobileRadioStandard;

        MobileRadioStandard mobileRadioStandard = null;

        String enterOperatingSystem;

        OperatingSystem operatingSystem = null;




        System.out.println("\nEDIT:\n");

        showSmartphones();

        System.out.println("Which number do you want to edit?");

        int userchoice = ConsoleReader.in.readPositivInt();

        if (userchoice >= smartphones.size()) return;


        UiInputHelper.createSmartphone result = UiInputHelper.getCreateSmartphone(brand, mobileRadioStandard, operatingSystem);
        if (result == null) return;


//        smartphone = new Smartphone(result.brand(), result.model(), result.ram(), result.flash(), result.mobileRadioStandard(), result.operatingSystem());

//        smartphones.set(userchoice, smartphone);


        Smartphone smartphoneToUpdate = smartphones.get(userchoice);

        smartphoneToUpdate.setBrandName(result.brand());
        smartphoneToUpdate.setModelName(result.model());
        smartphoneToUpdate.setAmountRAM(result.ram());
        smartphoneToUpdate.setAmountFlash(result.flash());
        smartphoneToUpdate.setMobileRadioStandard(result.mobileRadioStandard());
        smartphoneToUpdate.setOperatingSystem(result.operatingSystem());


        System.out.println("Smartphone replaced!");

        //File write
        FileHandler.getInstance().writeToCsvFile(smartphones);

    }

    private static void showSmartphones() {

        System.out.println("\nShow Smartphones:\n");

        System.out.printf(AppTexts.TEMPLATE_SMARTPHONE_LIST_HEADER,
                AppTexts.COLUMN_INDEX, AppTexts.COLUMN_BRAND, AppTexts.COLUMN_MODEL,
                AppTexts.COLUMN_MEMORY_SIZE, AppTexts.COLUMN_FLASH_SIZE, AppTexts.COLUMN_RADIO,
                AppTexts.COLUMN_OS);

        for (int i = 0; i < smartphones.size(); i++) {
            System.out.printf(AppTexts.TEMPLATE_SMARTPHONE_LIST_ENTRY,
                    i,
                    smartphones.get(i).getBrandName(), smartphones.get(i).getModelName(),
                    smartphones.get(i).getAmountRAM(), smartphones.get(i).getAmountFlash(),
                    smartphones.get(i).getMobileRadioStandard().getDisplayValue(),
                    smartphones.get(i).getOperatingSystem());
        }

    }

    private static void createSmartphone() {

        Smartphone smartphone;

        String enterBrand;

        String enterModel;

        Brand brand = null;

        String model;

        int ram;
        int flash;

        String enterMobileRadioStandard;

        MobileRadioStandard mobileRadioStandard = null;

        String enterOperatingSystem;

        OperatingSystem operatingSystem = null;


        UiInputHelper.createSmartphone result = UiInputHelper.getCreateSmartphone(brand, mobileRadioStandard, operatingSystem);
        if (result == null) return;


        smartphone = new Smartphone(result.brand(), result.model(), result.ram(), result.flash(), result.mobileRadioStandard(), result.operatingSystem());

        smartphones.add(smartphone);

        System.out.println("Smartphone created!");

        //File write:
        FileHandler.getInstance().writeToCsvFile(smartphones);

    }

    private static void printMenu() {

        System.out.printf(AppTexts.MENU_TEMPLATE, CREATE, LABEL_CREATE_SMARTPHONE, SHOW, LABEL_DISPLAY_ALL_SMARTPHONES, EDIT, LABEL_EDIT_SMARTPHONE, DELETE, LABEL_DELETE_SMARTPHONE, EXIT, LABEL_EXIT_PROGRAMM);

    }

    private static void printAppHeader() {

        System.out.println(AppTexts.HEADER_SMARTPHONE_MANAGEMENT);


    }
}
