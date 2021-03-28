package net.therap.model;

/**
 * @author masud.rana
 * @since 28/03/2021
 */
public interface SizeAnnotationValueProvider<Building> {
    int getSize(Building building);
}
