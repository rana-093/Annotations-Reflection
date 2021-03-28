package net.therap.model;

/**
 * @author masud.rana
 * @since 28/03/2021
 */
public class BuildingProvider implements SizeAnnotationValueProvider<Building> {
    public BuildingProvider() {
    }

    public int getSize(Building building) {
        return building.getFloorCount();
    }
}
