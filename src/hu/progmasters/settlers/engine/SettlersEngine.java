/*
 * Copyright © Progmasters (QTC Kft.), 2016-2018.
 * All rights reserved. No part or the whole of this Teaching Material (TM) may be reproduced, copied, distributed, 
 * publicly performed, disseminated to the public, adapted or transmitted in any form or by any means, including 
 * photocopying, recording, or other electronic or mechanical methods, without the prior written permission of QTC Kft. 
 * This TM may only be used for the purposes of teaching exclusively by QTC Kft. and studying exclusively by QTC Kft.’s 
 * students and for no other purposes by any parties other than QTC Kft.
 * This TM shall be kept confidential and shall not be made public or made available or disclosed to any unauthorized person.
 * Any dispute or claim arising out of the breach of these provisions shall be governed by and construed in accordance with the laws of Hungary.
 */

package hu.progmasters.settlers.engine;

import hu.progmasters.settlers.buildings.Archery;
import hu.progmasters.settlers.buildings.Barrack;
import hu.progmasters.settlers.buildings.Building;
import hu.progmasters.settlers.buildings.BuildingType;
import hu.progmasters.settlers.resources.Resource;
import hu.progmasters.settlers.resources.TypeOfResources;
import hu.progmasters.settlers.units.Unit;
import hu.progmasters.settlers.units.UnitType;

import java.util.ArrayList;
import java.util.List;


public class SettlersEngine {
    private List<Building> buildings = new ArrayList<>();
    private List<Unit> units = new ArrayList<>();
    private List<Resource> resources = new ArrayList<>();
    private int goldQuantity;
    private int steelQuantity;
    private int archerQuantity;
    private int swordsmanQuantity;


    public void build(String typeOfBuilding) {
        BuildingType buildingType = convertStringToEnum(typeOfBuilding);
        if(buildingType != null) {
            switch (buildingType) {
                case ARCHERY:
                    buildings.add(new Archery());
                    break;
                case BARRACK:
                    buildings.add(new Barrack());
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("No such a building");
        }
        buildingHandler();
    }

    public void skip() {
        buildingHandler();
    }

    public void status() {
        buildingHandler();
        printStatus();

    }

    private void buildingHandler() {
        for (Building building : buildings) {
            if(building.isCanProduce()) {
                if(building.getTurnsToProductUnit() == 0) {
                    building.produceUnit();
                    building.setTurnsToProductUnit();

                }
                if(building.getTurnsToProductResource() == 0) {
                    building.produceResource();
                }
                building.increaseTurns();
                building.decreaseTurnsLeftForProducing();
            } else {
                building.setCanProduce();
            }
        }
    }

    private void printStatus() {
        goldQuantity = 0;
        steelQuantity = 0;
        archerQuantity = 0;
        swordsmanQuantity = 0;
        for (Building building : buildings) {
            setResourceQuantity(building);
            System.out.println(building);
            setUnitQuantity(building);
        }

        System.out.println("Gold: " + goldQuantity);
        System.out.println("Steel: " + steelQuantity);
        System.out.println("Archers: " + archerQuantity);
        System.out.println("Swordsman: " + swordsmanQuantity);
    }

    private void setResourceQuantity(Building building) {
        if(building.getResourceType().equals(TypeOfResources.GOLD)) {
            goldQuantity += building.getResourceQuantity();
        } else if (building.getResourceType().equals(TypeOfResources.STEEL)) {
            steelQuantity += building.getResourceQuantity();
        }
    }

    private void setUnitQuantity(Building building) {
        if(building.getUnits().get(0).getUnitType().equals(UnitType.ARCHER)) {
            archerQuantity += building.getResourceQuantity();
        } else if (building.getUnits().get(0).getUnitType().equals(UnitType.SWORDSMAN)) {
            swordsmanQuantity += building.getResourceQuantity();
        }
    }

    private BuildingType convertStringToEnum(String typeOfHome) {
        for (BuildingType value : BuildingType.values()) {
            if (value.getStringValue().equals(typeOfHome)) {
                return value;
            }
        }
        return null;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public List<Resource> getResources() {
        return resources;
    }
}