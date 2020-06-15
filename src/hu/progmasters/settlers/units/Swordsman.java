package hu.progmasters.settlers.units;

public class Swordsman extends Unit {

    private int health;
    private int damage;
    private UnitType type = UnitType.SWORDSMAN;


    public Swordsman(int health, int damage) {
        this.health = Math.max(health, 0);
        this.damage = damage <= 0 ? 10 : damage;
    }

    public Swordsman() {
        this.health = 40;
        this.damage = 13;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public UnitType getUnitType() {
        return type;
    }


}
