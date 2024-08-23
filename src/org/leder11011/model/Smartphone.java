package org.leder11011.model;

import org.leder11011.settings.AppTexts;

/**
 * Speichert ein Smartphone samt seiner Eigenschaften:
 * Marke, Modell, RAM, Flashspeicher, Funkstandard, iOS/Android.
 */
public class Smartphone {

    //region Constants:
    public static final int INITIAL_VALUE = -1;
    public static final String NOT_SET = "> not set <";
    private static final String DELIMITER = ",";
    private static final int INDEX_BRAND = 0;
    private static final int INDEX_MODEL = 1;
    private static final int INDEX_RAM = 2;
    private static final int INDEX_FLASH = 3;
    private static final int INDEX_RADIO = 4;

    private static final int INDEX_OS = 5;

    //endregion

    //region Variables:
    private Brand brandName;

    private String modelName;

    private int amountRAM;

    private int amountFlash;

    private MobileRadioStandard mobileRadioStandard;

    private OperatingSystem operatingSystem;


    //endregion

    //region Constructors:


    public Smartphone() {
        brandName = null;
        modelName = NOT_SET;
        amountRAM = INITIAL_VALUE;
        amountFlash = INITIAL_VALUE;
        mobileRadioStandard = null;
        operatingSystem = null;

    }

    public Smartphone(Brand brandName, String modelName, int amountRAM, int amountFlash,
                      MobileRadioStandard mobileRadioStandard, OperatingSystem operatingSystem) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.amountRAM = amountRAM;
        this.amountFlash = amountFlash;
        this.mobileRadioStandard = mobileRadioStandard;
        this.operatingSystem = operatingSystem;
    }
    public Smartphone(String csvLine) {
        setPropertiesFromCsvLine(csvLine);
    }

    //endregion

    //region Getter and Setter:
    public Brand getBrandName() {
        return brandName;
    }

    public void setBrandName(Brand brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getAmountRAM() {
        return amountRAM;
    }

    public void setAmountRAM(int amountRAM) {
        this.amountRAM = amountRAM;
    }

    public int getAmountFlash() {
        return amountFlash;
    }

    public void setAmountFlash(int amountFlash) {
        this.amountFlash = amountFlash;
    }

    public MobileRadioStandard getMobileRadioStandard() {
        return mobileRadioStandard;
    }

    public void setMobileRadioStandard(MobileRadioStandard mobileRadioStandard) {
        this.mobileRadioStandard = mobileRadioStandard;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }



    //endregion

    //region methods:


    @Override
    public String toString() {
        return " Smartphone{" +
                "brandName=" + brandName +
                ", modelName='" + modelName + '\'' +
                ", amountRAM=" + amountRAM +
                ", amountFlash=" + amountFlash +
                ", mobileRadioStandard=" + mobileRadioStandard.getDisplayValue() +
                ", operatingSystem=" + operatingSystem +
                "} ";// + super.toString();
    }

    public String getPropertiesAsCsvLine() {
        return brandName + DELIMITER + modelName + DELIMITER + amountRAM + DELIMITER + amountFlash + DELIMITER + mobileRadioStandard.name() + DELIMITER + operatingSystem + "\n";

    }

    private void setPropertiesFromCsvLine(String csvLine) {
        //String anhand des Trennzeichens zerschneiden
        String[] properties = csvLine.split(DELIMITER);

        try {
            brandName = Brand.valueOf(properties[INDEX_BRAND]);
            modelName = properties[INDEX_MODEL];
            amountRAM = Integer.parseInt(properties[INDEX_RAM]);
            amountFlash = Integer.parseInt(properties[INDEX_FLASH]);
            mobileRadioStandard = MobileRadioStandard.valueOf(properties[INDEX_RADIO]);
            operatingSystem = OperatingSystem.valueOf(properties[INDEX_OS]);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(AppTexts.TXT_CSV_CAST_ERROR);
        }
        //Werte anhand des Arrays befüllen (mit Umwandlung)

    }
    //endregion

}
