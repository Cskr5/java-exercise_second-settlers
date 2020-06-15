package hu.progmasters.settlers;

import hu.progmasters.settlers.units.Archer;
import hu.progmasters.settlers.units.Swordsman;
import hu.progmasters.settlers.units.Unit;
import hu.progmasters.settlers.units.UnitType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitsTest {

    @Test
    public void create_archer() {
        Unit archer = new Archer();
        Assertions.assertEquals(UnitType.ARCHER,archer.getUnitType());
    }

    @Test
    public void create_swordsman() {
        Unit swordsman = new Swordsman();
        Assertions.assertEquals(UnitType.SWORDSMAN,swordsman.getUnitType());
    }

    @Test
    public void create_swordsman_with_negative_values() {
        Unit swordsmen = new Swordsman(-5,-4);
        Swordsman swordsman= ((Swordsman)swordsmen);
        Assertions.assertEquals(10,swordsman.getDamage());
        Assertions.assertEquals(10,swordsman.getDamage());
    }

    @Test
    public void create_archer_with_negative_values() {
        Unit archers = new Archer(-5,-4);
        Archer archer= ((Archer)archers);
        Assertions.assertEquals(10,archer.getDamage());
        Assertions.assertEquals(10,archer.getDamage());

    }
}
