~ GlSmartphoneManager ~
~~~~~~~~~~~~~~~~~~~~~~~

Please open project with IntelliJ IDEA

add lib/ConsoleReaderLib.jar to File - Project Settings - Libraries

open folder:
src/org/leder11011/main
open file:
Main.java

press shift + F10 to run app in terminal

create artifact JAR:
- File - Project Settings - Artifacts
- press +
- select JAR - from modules with dependencies
- select Main Class: Main
- press OK

Build - Build Artifacts - Build: out/artifacts/GlSmartphoneVerwaltung_jar/GlSmartphoneVerwaltung.jar

cd out/artifacts/GlSmartphoneVerwaltung_jar

cp ../../../lib . -R

java -jar GlDutyRosterManagement.jar
