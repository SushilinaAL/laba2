package asd;

import asd.Unit;
import asd.Axeman;
import asd.BowmanLong;
import asd.BowmanShort;
import asd.Crossbowman;
import asd.Cuirassier;
import asd.HorseArcher;
import asd.Knight;
import asd.Spearman;
import asd.Swordsman;

public class Purchase {
    private static Unit determineUnit(int index) {
        switch (index) {
            case 1:
                return new Swordsman();
            case 2:
                return new Spearman();
            case 3:
                return new Axeman();
            case 4:
                return new BowmanLong();
            case 5:
                return new BowmanShort();
            case 6:
                return new Crossbowman();
            case 7:
                return new Knight();
            case 8:
                return new Cuirassier();
            default:
                return new HorseArcher();
        }
    }


    public static void buyUnit(int index) {
        if (Menu.shownBalance >= 10) {
            Menu.shownBalance = UnitCreation.createUnit(determineUnit(index));
        }

        Menu.initMainMenu();
    }


    public static void returnUnit(int index) {
        if (!UnitCreation.getUnits().isEmpty()) {
            Menu.shownBalance = UnitCreation.cancelCreation(determineUnit(index));
        }

        Menu.initMainMenu();
    }
}
