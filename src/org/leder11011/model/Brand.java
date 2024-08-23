package org.leder11011.model;

public enum Brand {

    //region Enumeration
    Apple(new String[] {"iPhone SE", "iPhone 14", "iPhone 15"}),
    Nothing(new String[] {"Nothing Phone (1)", "Nothing Phone (2)", "Nothing Phone (2a)"}),
    Poco(new String[] {"M6", "M6 Pro", "X6"});


    //endregion

    //region Constants
    //endregion

    //region Attributs

    private String[] variants;

    //endregion

    //region Constructors
    Brand() {}

    Brand(String[] variants) {
        this.variants = variants;

    }
    //endregion

    //region Methods

    public String[] getVariants() {
        return variants;
    }

    public void setVariants(String[] variants) {
        this.variants = variants;
    }


    //endregion

}
