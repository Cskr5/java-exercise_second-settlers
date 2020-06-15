package hu.progmasters.settlers.buildings;

import hu.progmasters.settlers.resources.Resource;
import hu.progmasters.settlers.resources.TypeOfResources;
import hu.progmasters.settlers.units.Archer;

import java.util.ArrayList;
import java.util.List;


public class Archery extends Building {
    private int turnsToProductUnit = 3;
    private int turnsToProductGold = 2;
    private final BuildingType type = BuildingType.ARCHERY;
    private List<Archer> archers = new ArrayList<>();
    private Resource gold = new Resource(TypeOfResources.GOLD);

    public void produceUnit() {
        if (canProduce) {
            archers.add(new Archer());
        }
    }

    public void produceResource() {
        if (canProduce) {
            gold.setQuantity(gold.getQuantity() + 5);
        }
    }

    public void decreaseTurnsLeftForProducing() {
        turnsToProductGold--;
        turnsToProductUnit--;
    }

    public void turnOnProduction() {
        canProduce = true;
    }

    public int getGoldQuantity() {
        return gold.getQuantity();
    }

    public int getTurnsToProductUnit() {
        return turnsToProductUnit;
    }

    public int getTurnsToProductResource() {
        return turnsToProductGold;
    }

    public List<Archer> getArchers() {
        return archers;
    }

    public BuildingType getType() {
        return type;
    }

    public TypeOfResources getResourceType() {
        return gold.getTypeOfResources();
    }

    public void setTurnsToProductUnit() {
        turnsToProductUnit = 3;
    }

    public void setTurnsToProductResource() {
        turnsToProductGold = 2;
    }
}
