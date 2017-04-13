package um.edu.mt.cps2002;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


public class MapTest
{
    Map mapTest;

    @Before
    public void setUp()
    {
        mapTest = new Map();
    }
    @Test
    public void testSetMapSize()
    {
        Assert.assertEquals(false, mapTest.setMapSize(4, 4));
        Assert.assertEquals(true, mapTest.setMapSize(5,2));
        Assert.assertEquals(true, mapTest.setMapSize(5,4));
        Assert.assertEquals(false, mapTest.setMapSize(5,5));
        Assert.assertEquals(true, mapTest.setMapSize(8,5));
        Assert.assertEquals(false, mapTest.setMapSize(51,5));
    }
    @Test
    public void testGetTileType()
    {
        mapTest.tileColours = new Colour[][]{
                {Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.YELLOW},
                {Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.BLUE, Colour.BLUE, Colour.BLUE},
                {Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN},
                {Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN},
                {Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN},
                {Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.BLUE},
        };
        Assert.assertTrue(mapTest.getTileType(0,0)==Colour.GREEN);
        Assert.assertTrue(mapTest.getTileType(mapTest.size-1,0)==Colour.GREEN);
        Assert.assertTrue(mapTest.getTileType(0, mapTest.size-1)==Colour.YELLOW);
        Assert.assertTrue(mapTest.getTileType(mapTest.size-1, mapTest.size-1)==Colour.BLUE);

    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB1()
    {
        mapTest.generate();
        mapTest.getTileType(mapTest.size, 0);

    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB2()
    {
        mapTest.generate();
        mapTest.getTileType(0, mapTest.size);
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB3()
    {
        mapTest.generate();
        mapTest.getTileType(mapTest.size, mapTest.size);
    }

}
