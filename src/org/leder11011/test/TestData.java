package org.leder11011.test;

import org.leder11011.model.Brand;
import org.leder11011.model.MobileRadioStandard;
import org.leder11011.model.OperatingSystem;
import org.leder11011.model.Smartphone;

import java.util.ArrayList;

public class TestData {
    //region Constants
    public static final int TEST_DATA_AMOUNT = 5;
    //endregion

    //region Attributs
    //endregion

    //region Constructors
    private TestData() {
    }
    //endregion

    //region Methods
    public static ArrayList<Smartphone> generateTestData() {
        ArrayList<Smartphone> smartphones = new ArrayList<>();

//        for (int i = 0; i < TEST_DATA_AMOUNT; i++) {
//            smartphones.add(new Smartphone(Brand.Apple, "Model " + (i+1), (i+1)*4, (i+1)*64, MobileRadioStandard.Five_G, OperatingSystem.valueOf("iOS")));
//        }

        smartphones.add(new Smartphone(Brand.Apple, "iPhone SE", 8, 128, MobileRadioStandard.Five_G, OperatingSystem.valueOf("iOS")));
        smartphones.add(new Smartphone(Brand.Nothing, "Nothing Phone (1)", 8, 128, MobileRadioStandard.Five_G, OperatingSystem.valueOf("Android")));
        smartphones.add(new Smartphone(Brand.Nothing, "Nothing Phone (2)", 12, 512, MobileRadioStandard.Five_G, OperatingSystem.valueOf("Android")));
        smartphones.add(new Smartphone(Brand.Poco, "M6", 6, 64, MobileRadioStandard.Five_G, OperatingSystem.valueOf("Android")));
        smartphones.add(new Smartphone(Brand.Poco, "M6 Pro", 12, 256, MobileRadioStandard.Five_G, OperatingSystem.valueOf("Android")));



        return smartphones;

    }
    //endregion


}
