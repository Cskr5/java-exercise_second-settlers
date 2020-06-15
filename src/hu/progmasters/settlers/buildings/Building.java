package hu.progmasters.settlers.buildings;

import hu.progmasters.settlers.resources.TypeOfResources;


public abstract class Building {
    boolean canProduce;

    public abstract void produceUnit();

    public abstract void produceResource() ;
    public abstract TypeOfResources getResourceType();
    public abstract void turnOnProduction();
    public abstract int getTurnsToProductResource();
    public abstract void setTurnsToProductResource();
    public abstract int getTurnsToProductUnit();
    public abstract void setTurnsToProductUnit();


    public abstract void decreaseTurnsLeftForProducing();

    public  void setCanProduce() {
        canProduce = true;
    }

    public boolean isCanProduce() {
        return canProduce;
    }

}

