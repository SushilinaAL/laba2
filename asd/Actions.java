package asd;

import asd.Game;
import asd.Map;
import asd.Unit;

import java.util.ArrayList;

public class Actions {
    public static boolean attack(Unit unit, int unitX, int unitY, int moveToX, int moveToY, ArrayList<Unit> units) {
        double distance = ShortestPath.findShortestPath(unitX, unitY, moveToX, moveToY);

        if (distance <= unit.getAttackLength()) {

            for (Unit enemy : units) {
                if (enemy.getCoords()[0] == moveToX && enemy.getCoords()[1] == moveToY) {
                    int attack = unit.getAttack();
                    int health = enemy.getHealth();
                    int protection = enemy.getProtection();

                    if (health + protection > attack) {
                        if (attack > protection) {
                            enemy.reduceProtection(protection);
                            enemy.reduceHealth(attack - protection);
                        } else
                            enemy.reduceProtection(attack);
                    } else {
                        units.remove(enemy);
                        Map.removeFromMap(moveToX, moveToY);
                    }

                    if (unit.getSide()) {
                        Game.changeSide(false);
                    }

                    break;
                }
            }
        } else {
            if (unit.getSide()) {
                Game.changeSide(false);
                returnFailMessage();
            } else {
                return false;
            }
        }
        return true;
    }

    public static void move(Unit unit, int unitX, int unitY, int moveToX, int moveToY) {
        double distance = ShortestPath.findShortestPath(unitX, unitY, moveToX, moveToY);

        if (Game.getSide())
            Game.changeSide(false);

        if (distance <= unit.getMovementLength()) {
            Map.addToMap(unitX, unitY, '*');
            Map.addToMap(moveToX, moveToY, unit.getID());
            unit.setCoords(moveToX, moveToY);
        } else {
            returnFailMessage();
        }
    }

    private static void returnFailMessage() {
        System.out.println("Слишком далеко");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Game.createOptions();
    }
}
