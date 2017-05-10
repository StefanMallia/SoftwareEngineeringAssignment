package um.edu.mt.cps2002;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PlayerTest
{
    Player playerTest;
    Map map;

    @Before
    public void setUp()
    {   map = new Map();
        map.setMapSize(6,3);
        map.generate();
        playerTest = new Player(map.tileColours);

    }

    @Test
    public void testGetTileKnowledge() {
        //ensuring all tiles are greyed except initial tile for player 1
        int count = 0;
        for (int i = 0; i < map.size; i++) {
            for (int j = 0; j < map.size; j++) {
                if (playerTest.getTileKnowledge(new Position(i, j), map) == Colour.GREY)
                    count++;
            }
        }
        Assert.assertEquals(count, map.size*map.size-1);


        //ensuring player movement reveals tiles
        if (playerTest.position.column != 0)
            playerTest.move(Direction.RIGHT, map);
        else
            playerTest.move(Direction.LEFT, map);
        count = 0;
        for (int i = 0; i < map.size; i++) {
            for (int j = 0; j < map.size; j++) {
                if (playerTest.getTileKnowledge(new Position(i, j), map) == Colour.GREY)
                    count++;
            }
        }
        Assert.assertEquals(count, map.size*map.size-2);


        //ensuring player movement reveals tiles
        if (playerTest.position.column != 0)
            playerTest.move(Direction.UP, map);
        else
            playerTest.move(Direction.DOWN, map);
        count = 0;
        for (int i = 0; i < map.size; i++) {
            for (int j = 0; j < map.size; j++) {
                if (playerTest.getTileKnowledge(new Position(i, j), map) == Colour.GREY)
                    count++;
            }
        }
        Assert.assertEquals(count, map.size*map.size-3);

        //ensuring setPosition reveals tiles
        boolean finishLoop = false;
        for (int i = 0; i < map.size; i++) {
            for (int j = 0; j < map.size; j++) {
                if (map.tileColours[i][j] == Colour.GREEN && playerTest.getTileKnowledge(new Position(i, j), map) == Colour.GREY) {
                    playerTest.setPosition(new Position(i, j), map);
                    Assert.assertEquals(map.tileColours[i][j], playerTest.getTileKnowledge(new Position(i, j), map))
                }

            }
        }
    }

    @Test
    public void testSetTileKnowledge() {
        for (int i = 0; i < map.size; i++) {
            for (int j = 0; j < map.size; j++) {
                playerTest.setTileKnowledge(new Position(i,j), map);
                Assert.assertEquals(map.tileColours[i][j], playerTest.getTileKnowledge(new Position(i, j), map));
            }
        }
    }

    @Test
    public void testMove()
    {

        playerTest.position = new Position(0, 0);

        playerTest.move(Direction.RIGHT, map);
        Assert.assertEquals(true, playerTest.position.equals(0, 1));
        playerTest.move(Direction.DOWN, map);
        Assert.assertEquals(true, playerTest.position.equals(1, 1));
        playerTest.move(Direction.UP, map);
        Assert.assertEquals(true, playerTest.position.equals(0, 1));
        playerTest.move(Direction.LEFT, map);
        Assert.assertEquals(true, playerTest.position.equals(0, 0));
        playerTest.move(Direction.UP, map);
        Assert.assertEquals(false, playerTest.position.equals(-1, 0));
        playerTest.move(Direction.LEFT, map);
        Assert.assertEquals(false, playerTest.position.equals(-1, -1));
        Assert.assertEquals(false, playerTest.position.equals(0, -1));

    }

    @Test
    public void testSetPosition()
    {
        playerTest.position = new Position(0,0);
        playerTest.setPosition(new Position(5,5), map);
        Assert.assertEquals(true, playerTest.position.equals(5,5));
        playerTest.setPosition(new Position(2,5), map);
        Assert.assertEquals(true, playerTest.position.equals(2,5));
        playerTest.setPosition(new Position(5,3), map);
        Assert.assertEquals(true, playerTest.position.equals(5,3));
    }
}
