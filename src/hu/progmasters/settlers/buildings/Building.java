package hu.progmasters.settlers.buildings;

import hu.progmasters.settlers.resources.TypeOfResources;
import hu.progmasters.settlers.units.Unit;

import java.util.List;


public abstract class Building {
    boolean canProduce;
    boolean produceAllowedByEngine;
    private int turnsCounter;
    private int allowProductionCounter;

    public abstract void produceUnit();
    public abstract void produceResource() ;
    public abstract TypeOfResources getResourceType();
    public abstract void turnOnProduction();
    public abstract int getTurnsToProductResource();
    public abstract void setTurnsToProductResource();
    public abstract int getTurnsToProductUnit();
    public abstract void setTurnsToProductUnit();
    public abstract int getResourceQuantity();
    public abstract List<Unit> getUnits();
    public abstract BuildingType getBuildingType();


    public abstract void decreaseTurnsLeftForProducing();

    public  void setCanProduce() {
        if(allowProductionCounter == 1) {
            canProduce = true;
            allowProductionCounter = 0;
        }
        allowProductionCounter++;
    }

    public boolean isCanProduce() {
        return canProduce;
    }

    public void increaseTurns() {
        turnsCounter++;
    }

    public int getTurnsCounter() {
        return turnsCounter;
    }

    @Override
    public String toString() {
        return "Building{" +
                "turns=" + turnsCounter +
                '}';
    }
}

