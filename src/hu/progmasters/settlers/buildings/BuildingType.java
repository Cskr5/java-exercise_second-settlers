package hu.progmasters.settlers.buildings;

public enum BuildingType {
    ARCHERY("archery"),BARRACK("barrack");

    private final String stringValue;

    BuildingType(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
