package um.edu.mt.cps2002;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GameMapTest
{
    GameMap gameMapTest;


    @Before
    public void setUp()
    {
        GameMapSafe.getInstance();
        gameMapTest = GameMap.instance;
    }

    @Test
    public void testGetInstance()
    {
        Assert.assertNotNull(gameMapTest);
        GameMap gameMapTest2 = GameMapSafe.getInstance();
        Assert.assertNull(gameMapTest2);
    }


    @Test
    public void testSetMapSize()
    {
            Assert.assertEquals(false, gameMapTest.setMapSize(4, 4));
            Assert.assertEquals(true, gameMapTest.setMapSize(5, 2));
            Assert.assertEquals(true, gameMapTest.setMapSize(5, 4));
            Assert.assertEquals(false, gameMapTest.setMapSize(5, 5));
            Assert.assertEquals(true, gameMapTest.setMapSize(8, 5));
            Assert.assertEquals(false, gameMapTest.setMapSize(51, 5));


    }

    @Test
    public void testGenerate() {
        gameMapTest.setMapSize(50, 5);
        gameMapTest.generate();
        int countTreasure = 0;
        for (int i = 0; i < gameMapTest.size; i++) {
            for (int j = 0; j < gameMapTest.size; j++) {
                if (gameMapTest.tileColours[i][j] == Colour.YELLOW)
                    countTreasure++;
            }
        }
        Assert.assertEquals(1, countTreasure);

    }

    @Test
    public void testGetTileType()
    {
        gameMapTest.setMapSize(6,3);
        gameMapTest.tileColours = new Colour[][]{
                {Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.YELLOW},
                {Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.BLUE, Colour.BLUE, Colour.BLUE},
                {Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN},
                {Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN},
                {Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN},
                {Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.GREEN, Colour.BLUE},
        };
        Assert.assertTrue(gameMapTest.getTileType(0,0)==Colour.GREEN);
        Assert.assertTrue(gameMapTest.getTileType(gameMapTest.size-1,0)==Colour.GREEN);
        Assert.assertTrue(gameMapTest.getTileType(0, gameMapTest.size-1)==Colour.YELLOW);
        Assert.assertTrue(gameMapTest.getTileType(gameMapTest.size-1, gameMapTest.size-1)==Colour.BLUE);

    }





    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB1()
    {
        gameMapTest.setMapSize(6,3);
        gameMapTest.generate();
        gameMapTest.getTileType(gameMapTest.size, 0);

    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB2()
    {
        gameMapTest.setMapSize(6,3);
        gameMapTest.generate();
        gameMapTest.getTileType(0, gameMapTest.size);
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB3()
    {
        gameMapTest.setMapSize(6,3);
        gameMapTest.generate();
        gameMapTest.getTileType(gameMapTest.size, gameMapTest.size);
    }



    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB4()
    {
        gameMapTest.setMapSize(6,3);
        gameMapTest.generate();
        gameMapTest.getTileType(new Position(gameMapTest.size, 0));

    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB5()
    {
        gameMapTest.setMapSize(6,3);
        gameMapTest.generate();
        gameMapTest.getTileType(new Position(0, gameMapTest.size));
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetTileTypeOOB6()
    {
        gameMapTest.setMapSize(6,3);
        gameMapTest.generate();
        gameMapTest.getTileType(new Position(gameMapTest.size, gameMapTest.size));
    }

}
