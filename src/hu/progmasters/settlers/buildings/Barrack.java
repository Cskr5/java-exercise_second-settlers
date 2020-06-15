package hu.progmasters.settlers.buildings;

import hu.progmasters.settlers.resources.Resource;
import hu.progmasters.settlers.resources.TypeOfResources;
import hu.progmasters.settlers.units.Swordsman;

import java.util.ArrayList;
import java.util.List;

public class Barrack extends Building {
    private int turnsToProductUnit = 4;
    private int turnsToProductSteel = 3;
    private List<Swordsman> swordsmen = new ArrayList<>();
    private Resource steel = new Resource(TypeOfResources.STEEL);
    protected boolean canProduce = false;


    public void produceUnit() {
        if(canProduce ) {
            swordsmen.add(new Swordsman());
        }
    }

    public void produceResource() {
        if(canProduce) {
            steel.setQuantity(steel.getQuantity() + 10);
        }
    }

    public void turnOnProduction() {
        canProduce = true;
    }

    public int getSteelQuantity() {
        return steel.getQuantity();
    }

    public int getTurnsToProductUnit() {
        return turnsToProductUnit;
    }

    public int getTurnsToProductSteel() {
        return turnsToProductSteel;
    }

    public List<Swordsman> getSwordsmen() {
        return swordsmen;
    }

    public Resource getSteel() {
        return steel;
    }
}
