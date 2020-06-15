package hu.progmasters.settlers;

import hu.progmasters.settlers.buildings.Archery;
import hu.progmasters.settlers.buildings.Barrack;
import hu.progmasters.settlers.buildings.BuildingType;
import hu.progmasters.settlers.engine.SettlersEngine;
import hu.progmasters.settlers.resources.TypeOfResources;
import hu.progmasters.settlers.units.UnitType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ServiceConfigurationError;

public class EngineTest {
    SettlersEngine engine;

    @BeforeEach
    public void init() {
        engine = new SettlersEngine();
    }

    @Test
    public void build_archery_2barracks() {
        engine.build("barracks");
        engine.build("barracks");
        engine.build("archery");

        Assertions.assertEquals(3, engine.getBuildings().size());
        Assertions.assertEquals(TypeOfResources.STEEL, engine.getBuildings().get(0).getResourceType());
        Assertions.assertEquals(TypeOfResources.GOLD, engine.getBuildings().get(2).getResourceType());
    }

    @Test
    public void buildingType() {
        engine.build("barracks");
        engine.build("barracks");
        engine.build("archery");

        Assertions.assertEquals(BuildingType.BARRACK, engine.getBuildings().get(0).getBuildingType());
        Assertions.assertEquals(BuildingType.ARCHERY, engine.getBuildings().get(2).getBuildingType());
    }

    @Test
    public void unitType() {
        engine.build("barracks");
        engine.build("barracks");
        engine.build("archery");
        for (int i = 0; i < 6; i++) {
            engine.skip();
        }
        Assertions.assertEquals(UnitType.SWORDSMAN,engine.getBuildings().get(0).getUnits().get(0).getUnitType());
        Assertions.assertEquals(UnitType.ARCHER, engine.getBuildings().get(2).getUnits().get(2).getUnitType());
    }

    @Test
    public void barracks_execute_after_next_round() {
        engine.build("barracks");
        engine.build("barracks");
        engine.build("barracks");

        Assertions.assertEquals(1, engine.getBuildings().get(0).getTurnsCounter());
        Assertions.assertEquals(0, engine.getBuildings().get(1).getTurnsCounter());
        Assertions.assertEquals(0, engine.getBuildings().get(2).getTurnsCounter());
    }

    @Test
    public void archery_execute_after_next_round() {
        engine.build("archery");
        engine.build("barracks");
        engine.skip();

        Assertions.assertEquals(1, engine.getBuildings().get(0).getTurnsCounter());
        Assertions.assertEquals(0, engine.getBuildings().get(1).getTurnsCounter());
    }

    @Test
    public void skip_increaseUnits() {
        engine.build("barracks");
        engine.build("archery");

        for (int i = 0; i < 10; i++) {
            engine.skip();
        }
        Assertions.assertEquals(2, engine.getBuildings().get(0).getUnits().size());
        Assertions.assertEquals(3, engine.getBuildings().get(1).getUnits().size());
    }

    @Test
    public void status() {

    }

    @Test
    public void stringToEnum() {
        Assertions.assertEquals(BuildingType.ARCHERY, engine.convertStringToEnum("archery"));
        Assertions.assertEquals(BuildingType.BARRACK, engine.convertStringToEnum("barracks"));
    }
}
