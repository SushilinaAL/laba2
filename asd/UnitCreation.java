package asd;

import asd.Map;
import asd.Unit;

import java.util.ArrayList;
import java.util.Objects;

public class UnitCreation {
    private static ArrayList<Unit> units = new ArrayList<>();
    private static int balance = 90;

    public static ArrayList<Unit> getUnits() {
        return units;
    }

    public static int createUnit(Unit unit) {
        int cost = unit.getCost();

        if (balance >= cost) {
            balance -= cost;

            units.add(unit);
            unit.setCoords(units.size() - 1, 0);
            Map.addToMap(units.size() - 1, 0, unit.getID());
        }

            return balance;
    }

    public static int cancelCreation(Unit unit) {
        balance += unit.getCost();
        for (int i = 0; i < units.size(); i++) {
            if (Objects.equals(units.get(i).getName(), unit.getName())) {
                Map.removeFromMap(i, 0);
                units.remove(i);
                break;
            }
        }

        return balance;
    }
}
