package asd;
import asd.Unit;

public class Axeman extends Unit {
    private static final int cost = 20;
    private static final String name = "Топорщик";
    private static final Character index = '3';
    private int[] coords = new int[2];
    private static final int attack = 9;
    private static final int attackLength = 1;
    private static final int movementLength = 4;
    private int health = 45;
    private int protection = 3;
    private boolean playerSide = true;

    public void setEnemySide() {
        this.playerSide = false;
    }

    public boolean getSide() {
        return playerSide;
    }

    public void setCoords(int x, int y) {
        coords[0] = x;
        coords[1] = y;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int health) {
        this.health -= health;
    }

    public void reduceProtection(int protection) {
        this.protection -= protection;
    }

    public int getAttack() {
        return attack;
    }

    public int getAttackLength() {
        return attackLength;
    }

    public int getProtection() {
        return protection;
    }


    public int getMovementLength() {
        return movementLength;
    }

    public int[] getCoords() {
        return coords;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public Character getID() {
        return index;
    }
}