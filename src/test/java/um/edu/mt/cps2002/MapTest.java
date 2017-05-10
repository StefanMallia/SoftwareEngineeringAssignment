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
        mapTest = Map.getInstance();
    }

    @Test
    public void testGetInstance()
    {
        Assert.assertNotEquals(mapTest, null);
        Map mapTest2 = Map.getInstance();
        Assert.assertEquals(mapTest2, null);
    }


    @Test
    public void testSetMapSize()
    {

            Assert.assertEquals(false, mapTest.setMapSize(4, 4));
            Assert.assertEquals(true, mapTest.setMapSize(5, 2));
            Assert.assertEquals(true, mapTest.setMapSize(5, 4));
            Assert.assertEquals(false, mapTest.setMapSize(5, 5));
            Assert.assertEquals(true, mapTest.setMapSize(8, 5));
            Assert.assertEquals(false, mapTest.setMapSize(51, 5));


    }

    @Test
    public void testGenerate()
    {
        mapTest.setMapSize(50, 5);
        mapTest.generate();
        int countTreasure = 0;
        for (int i = 0; i < mapTest.size; i++) {
            for (int j = 0; j < mapTest.size; j++) {
                if (mapTest.tileColours[i][j] == Colour.YELLOW)
                    countTreasure++;
            }
        }
        Assert.assertEquals(1, countTreasure);

        //make sure no neighboring water tiles are present
        for (int i = 0; i < mapTest.size; i++) {
            for (int j = 0; j < mapTest.size; j++) {
                if (mapTest.tileColours[i][j] == Colour.BLUE) {
                    boolean one_neighboring_blue = false;
                    for (int n = i - 1; n <= i + 1; n++) {
                        for (int m = j - 1; m <= j + 1; m++) {
                            //skip when out of bounds index and when (n, m) == (i, j)
                            if (n != -1 && n != mapTest.size && m != -1 && m != mapTest.size && n != i && m != j) {
                                if (mapTest.tileColours[n][m] == Colour.BLUE) {
                                    one_neighboring_blue = true;
                                }
                            }
                        }
                    }
                    Assert.assertFalse(one_neighboring_blue);

                }
            }

        }
    }

    @Test
    public void testGetTileType()
    {
        mapTest.setMapSize(6,3);
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
        mapTest.setMapSize(6,3);
        mapTest.generate();
        mapTest.getTileType(mapTest.size, 0);

    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB2()
    {
        mapTest.setMapSize(6,3);
        mapTest.generate();
        mapTest.getTileType(0, mapTest.size);
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB3()
    {
        mapTest.setMapSize(6,3);
        mapTest.generate();
        mapTest.getTileType(mapTest.size, mapTest.size);
    }



    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB4()
    {
        mapTest.setMapSize(6,3);
        mapTest.generate();
        mapTest.getTileType(new Position(mapTest.size, 0));

    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB5()
    {
        mapTest.setMapSize(6,3);
        mapTest.generate();
        mapTest.getTileType(new Position(0, mapTest.size));
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB6()
    {
        mapTest.setMapSize(6,3);
        mapTest.generate();
        mapTest.getTileType(new Position(mapTest.size, mapTest.size));
    }

}
