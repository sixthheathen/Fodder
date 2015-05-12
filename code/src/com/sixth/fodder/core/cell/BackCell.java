 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core.cell;

import com.sixth.fodder.graphics.atlasses.BackCells;

/**
 *
 * @author sixth
 */
public class BackCell extends Cell
{
    public BackCell (int x, int y)
    {
        super(x, y);
        setTexture();
    }
    
    @Override
    public void setTexture ()
    {
        super.getActor().setTexture(BackCells.valueOf("voidCell").getTexture());
    }
}
