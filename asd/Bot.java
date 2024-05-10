
package asd;
import asd.Game;
import asd.UnitCreation;
import asd.Map;
import asd.Unit;
import asd.Actions;
import asd.Axeman;
import asd.BowmanLong;
import asd.BowmanShort;
import asd.Crossbowman;
import asd.Cuirassier;
import asd.HorseArcher;
import asd.Knight;
import asd.Spearman;
import asd.Swordsman;

import java.util.ArrayList;
import java.util.Random;

public class Bot {
    private static int balance = 90;
    private static ArrayList<Unit> units = new ArrayList<>();

    public static ArrayList<Unit> getUnits() {
        return units;
    }

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

    public static void initBot() {
        while (balance >= 10) {
            create(determineUnit(new Random().nextInt(9) + 1));
        }
    }

    private static void create(Unit unit) {
        units.add(unit);
        balance -= unit.getCost();
        Map.addToMap(units.size() - 1, 14, unit.getID());
        unit.setCoords(units.size() - 1, 14);
        unit.setEnemySide();
    }

    private static void move() {
        Unit unitToMove = units.get(new Random().nextInt(units.size()));

        int x = unitToMove.getCoords()[0];
        int y = unitToMove.getCoords()[1];
        int movementLength = unitToMove.getMovementLength();

        if (checkGivenPoint(x, y - movementLength)) {
            Map.addToMap(x, y, '*');
            Map.addToMap(x, y - movementLength, unitToMove.getID());
            unitToMove.setCoords(x, y - movementLength);
        } else {
            Map.addToMap(x, y, '*');
            Map.addToMap(x, y - movementLength + 1, unitToMove.getID());
            unitToMove.setCoords(x, y - movementLength + 1);
        }
    }

    private static boolean attack() {
        ArrayList<Unit> playerUnits = UnitCreation.getUnits();

        for (Unit unit : units) {
            for (Unit playerUnit : playerUnits) {
                if (Actions.attack(unit, unit.getCoords()[0], unit.getCoords()[1],
                        playerUnit.getCoords()[0], playerUnit.getCoords()[1],  playerUnits)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void makeAMove() {
        if (!attack()) {
            move();
        }

        Game.changeSide(true);
        Game.createOptions();
    }

    private static boolean checkGivenPoint(int x, int y) {
        char cellValue = Map.returnMap(x, y);

        if (x < 0 || x > 14 || y < 0 || y > 14) {
            return false;
        } else if (cellValue == '#' || cellValue == '@' || cellValue == '!') {
            return false;
        } else return cellValue == '*';
    }
}
