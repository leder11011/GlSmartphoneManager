package org.leder11011.settings;

/**
 * Constants for labels and texts
 *
*/
public class AppTexts {

    public static final String HEADER_SMARTPHONE_MANAGEMENT = """
                            
            $$$$$$$$$$$$$$$$$$$$$$$$$
            $ Smartphone Management $
            $$$$$$$$$$$$$$$$$$$$$$$$$
                            
            """;
    public static final String MENU_INVALID_CHOICE = "Invalid menu choice!";
    public static final String MENU_TEMPLATE = """
 
            MENU
            ====
            
            %s> %s
            %s> %s
            %s> %s
            %s> %s
            ------
            %s> %s
             
  
            """;
    public static final String TXT_PROGRAMM_EXITS = "Programm exits...";
    public static final String TXT_FILE_NOT_FOUND = "File not found!";
    public static final String TXT_CSV_CAST_ERROR = "Beim Einlesen der CSV Datei ist ein Fehler aufgetreten!";
    public static final String TXT_SAVE_SMARTPHONES = "Do you want to save smartphones to disk?";

    public static final String TEMPLATE_SMARTPHONE_LIST_HEADER = "\n%-10s %-30s %-30s %20s %20s %15s %20s\n\n";
    public static final String TEMPLATE_SMARTPHONE_LIST_ENTRY = "%-10s %-30s %-30s %20s %20s %15s %20s\n";
    public static final String COLUMN_INDEX = "ID";
    public static final String COLUMN_BRAND = "Brand";
    public static final String COLUMN_MODEL = "Model";
    public static final String COLUMN_MEMORY_SIZE = "Memory Size";

    public static final String COLUMN_FLASH_SIZE = "Flash Memory Size";

    public static final String COLUMN_RADIO = "Mobile Radio";
    public static final String COLUMN_OS = "Operating System";


    private AppTexts() {
    }
}
