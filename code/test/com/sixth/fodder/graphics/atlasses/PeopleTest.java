/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.graphics.atlasses;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sixth
 */
public class PeopleTest
{
    
    public PeopleTest()
    {
    }

    @Test
    public void testValues()
    {
        System.out.println("values");
        People[] expResult = null;
        People[] result = People.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testValueOf()
    {
        System.out.println("valueOf");
        String name = "";
        People expResult = null;
        People result = People.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetTexture()
    {
        System.out.println("getTexture");
        People instance = null;
        TextureRegion expResult = null;
        TextureRegion result = instance.getTexture();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
