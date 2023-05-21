package net.therap.model;

import net.therap.annotation.Size;

/**
 * @author masud.rana
 * @since 28/03/2021
 */
public class Building {
    private int floorCount;

    public Building(int floorCount) {
        this.floorCount = floorCount;
    }

    public int getFloorCount() {
        return this.floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }
}
