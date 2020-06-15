package hu.progmasters.settlers.buildings;

import hu.progmasters.settlers.resources.Resource;
import hu.progmasters.settlers.resources.TypeOfResources;
import hu.progmasters.settlers.units.Swordsman;

import java.util.ArrayList;
import java.util.List;

public class Barrack extends Building {
    private int turnsToProductUnit = 4;
    private int turnsToProductSteel = 3;
    private BuildingType type = BuildingType.BARRACK;
    private List<Swordsman> swordsmen = new ArrayList<>();
    private Resource steel = new Resource(TypeOfResources.STEEL);

    public void produceUnit() {
        if (canProduce) {
            swordsmen.add(new Swordsman());
        }
    }

    public void produceResource() {
        if (canProduce) {
            steel.setQuantity(steel.getQuantity() + 10);
        }
    }

    public void turnOnProduction() {
        canProduce = true;
    }

    public void decreaseTurnsLeftForProducing() {
        turnsToProductSteel--;
        turnsToProductUnit--;
    }

    public int getSteelQuantity() {
        return steel.getQuantity();
    }



    public int getTurnsToProductUnit() {
        return turnsToProductUnit;
    }

    public int getTurnsToProductResource() {
        return turnsToProductSteel;
    }

    public BuildingType getType() {
        return type;
    }

    public List<Swordsman> getSwordsmen() {
        return swordsmen;
    }

    public TypeOfResources getResourceType() {
        return steel.getTypeOfResources();
    }

    public void setTurnsToProductUnit() {
        turnsToProductUnit = 4;
    }

    public void setTurnsToProductResource() {
        turnsToProductSteel = 3;
    }

}
