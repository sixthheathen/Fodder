/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core.cell;

import com.sixth.fodder.core.buildings.Building;
import com.sixth.fodder.graphics.atlasses.Buildings;

/**
 *
 * @author sixth
 */
public class BuildingCell extends Cell
{
    private Building building = null;

    public BuildingCell (int x, int y, Building building)
    {
        super(x, y);
        this.building = building;
        setTexture();
    }
    
    @Override
    public void setTexture ()
    {
        super.getActor().setTexture(Buildings.valueOf(building.getName()).getTexture());
    }
    
    public Boolean hasBuilding()
    {
        return (building != null);
    }
}
