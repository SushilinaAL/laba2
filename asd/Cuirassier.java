package asd;
import asd.Unit;

public class Cuirassier extends Unit {
    private final int cost = 23;
    private final String name = "Кирасир";
    private final Character index = '8';
    private int[] coords = new int[2];
    private static final int attack = 2;
    private static final int attackLength = 1;
    private static final int movementLength = 5;
    private int health = 50;
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
