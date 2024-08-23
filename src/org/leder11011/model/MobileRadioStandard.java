package org.leder11011.model;

public enum MobileRadioStandard {

    //region Enumeration
    Five_G ("5G"),
    Four_G ("4G");
    //endregion

    //region Constants
    //endregion

    //region Attributs

    private String displayValue;

    //endregion

    //region Constructors
    MobileRadioStandard() {}

    MobileRadioStandard(String displayValue) {
        this.displayValue = displayValue;
    }

    //endregion

    //region Methods

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    @Override
    public String toString() {
        return displayValue; //"MobileRadioStandard{" +
//                "displayValue='" + displayValue + '\'' +
//                '}';
    }

    //endregion

}
