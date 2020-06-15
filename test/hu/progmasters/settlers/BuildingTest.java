package hu.progmasters.settlers;

import hu.progmasters.settlers.buildings.Archery;
import hu.progmasters.settlers.buildings.Barrack;
import hu.progmasters.settlers.buildings.Building;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BuildingTest {
    Building archery;
    Building barracks;

    @BeforeEach
    public void init() {
     archery = new Archery();
     barracks = new Barrack();
    }

    @Test
    public void archery_production_resource() {
        archery.produceResource();
        archery.setCanProduce();
        archery.setCanProduce();
        archery.produceResource();
        Assertions.assertEquals(5,archery.getResourceQuantity());

    }

    @Test
    public void barracks_production_resource() {
        barracks.produceResource();
        barracks.setCanProduce();
        barracks.setCanProduce();
        barracks.produceResource();
        Assertions.assertEquals(10,barracks.getResourceQuantity());
    }

    @Test
    public void barracks_production_unit() {
        barracks.setCanProduce();
        barracks.setCanProduce();
        barracks.produceUnit();
        Assertions.assertEquals(1,barracks.getUnits().size());
    }

    @Test
    public void archery_production_unit() {
        archery.setCanProduce();
        archery.setCanProduce();
        archery.produceUnit();
        archery.produceUnit();
        Assertions.assertEquals(2,archery.getUnits().size());
    }

}
