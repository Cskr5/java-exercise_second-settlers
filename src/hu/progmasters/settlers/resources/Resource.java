package hu.progmasters.settlers.resources;

public class Resource {
    private TypeOfResources typeOfResources;
    private int quantity;

    public Resource(TypeOfResources typeOfResources) {
        this.typeOfResources = typeOfResources;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TypeOfResources getTypeOfResources() {
        return typeOfResources;
    }
}
