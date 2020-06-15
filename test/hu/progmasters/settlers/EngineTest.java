package hu.progmasters.settlers;

import hu.progmasters.settlers.buildings.Archery;
import hu.progmasters.settlers.buildings.Barrack;
import hu.progmasters.settlers.engine.SettlersEngine;
import hu.progmasters.settlers.resources.TypeOfResources;
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
        engine.build("barrack");
        engine.build("barrack");
        engine.build("archery");

        Assertions.assertEquals(3, engine.getBuildings().size());
        Assertions.assertEquals(TypeOfResources.STEEL, engine.getBuildings().get(0).getResourceType());
        Assertions.assertEquals(TypeOfResources.GOLD, engine.getBuildings().get(2).getResourceType());
    }
}
