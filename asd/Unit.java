package asd;

public abstract class Unit {

    public abstract void setEnemySide();

    public abstract boolean getSide();

    public abstract int getHealth();

    public abstract void reduceHealth(int health);

    public abstract int getAttack();

    public abstract int getAttackLength();

    public abstract int getProtection();

    public abstract void reduceProtection(int protection);

    public abstract int getMovementLength();

    public abstract void setCoords(int x, int y);

    public abstract int[] getCoords();

    public abstract int getCost();

    public abstract String getName();

    public abstract Character getID();
}
