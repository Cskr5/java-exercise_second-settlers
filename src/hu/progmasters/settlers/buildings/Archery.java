package hu.progmasters.settlers.buildings;

import hu.progmasters.settlers.resources.Resource;
import hu.progmasters.settlers.resources.TypeOfResources;
import hu.progmasters.settlers.units.Archer;

import java.util.ArrayList;
import java.util.List;


public class Archery extends Building {
    private int turnsToProductUnit = 3;
    private int turnsToProductGold = 2;
    private List<Archer> archers = new ArrayList<>();
    private Resource gold = new Resource(TypeOfResources.GOLD);
    protected boolean canProduce = false;

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

    public void turnOnProduction() {
        canProduce = true;
    }

    public int getSteelQuantity() {
        return gold.getQuantity();
    }



    public int getTurnsToProductUnit() {
        return turnsToProductUnit;
    }

    public int getTurnsToProductGold() {
        return turnsToProductGold;
    }

    public List<Archer> getArchers() {
        return archers;
    }

    public Resource getGold() {
        return gold;
    }

}
