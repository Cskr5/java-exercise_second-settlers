package hu.progmasters.settlers.units;

public class Archer extends Unit {
    private int health;
    private int damage;
    private UnitType type = UnitType.ARCHER;

    public Archer(int health, int damage) {
        this.health = Math.max(health, 0);
        this.damage = damage <= 1 ? 10 : damage;
    }

    public Archer() {
        this.health = 25;
        this.damage = 7;
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
