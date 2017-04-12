package SoftwareEngineeringAssignment;


import org.junit.Assert;
import org.junit.BeforeEach;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


public class MapTest
{
    Map mapTest;

    @BeforeEach
    public void setUp()
    {
        mapTest = new Map();
    }
    @Test
    public void testSetMapSize()
    {
        Assert.assertEquals(false, mapTest.setMapSize(4,4));
        Assert.assertEquals(true, mapTest.setNumPlayers(5,2));
        Assert.assertEquals(true, mapTest.setNumPlayers(5,4));
        Assert.assertEquals(false, mapTest.setNumPlayers(5,5));
        Assert.assertEquals(true, mapTest.setNumPlayers(8,5));
        Assert.assertEquals(false, mapTest.setNumPlayers(51,5));
    }
    @Test
    public void testGetTileType()
    {
        mapTest.generate()
        Assert.assertTrue(map.getTileType(0,0)=="green"
                || map.getTileType(0,0)=="blue"
                || map.getTileType(0,0)=="treasure");
        Assert.assertTrue(map.getTileType(map.size-1,0)=="green"
                || map.getTileType(map.size-1,0)=="blue"
                || map.getTileType(map.size-1,0)=="treasure");
        Assert.assertTrue(map.getTileType(0, map.size-1)=="green"
                || map.getTileType(0, map.size-1)=="blue"
                || map.getTileType(0, map.size-1)=="treasure");
        Assert.assertTrue(map.getTileType(map.size-1, map.size-1)=="green"
                || map.getTileType(map.size-1, map.size-1)=="blue"
                || map.getTileType(map.size-1, map.size-1)=="treasure");

    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB1()
    {
        mapTest.generate()
        map.getTileType(map.size,0);

    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB1()
    {
        mapTest.generate()
        map.getTileType(0,map.size);
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB1()
    {
        mapTest.generate()
        map.getTileType(map.size,map.size);
    }

}
