package um.edu.mt.cps2002;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PlayerTest
{
    Player playerTest;
    GameMap gameMap;

    @Before
    public void setUp() {
        GameMap.getInstance();
        gameMap = GameMap.instance;
        gameMap.setMapSize(6,3);
        gameMap.generate();
        playerTest = new Player(gameMap);

    }

    @Test
    public void testGetTileKnowledge() {
        //ensuring all tiles are greyed except initial tile for player 1
        int count = 0;
        for (int i = 0; i < gameMap.size; i++) {
            for (int j = 0; j < gameMap.size; j++) {
                if (playerTest.getTileKnowledge(new Position(i, j)) == Colour.GREY)
                    count++;
            }
        }
        Assert.assertEquals(gameMap.size*gameMap.size - 1, count);


        //ensuring player movement reveals tiles
        if (playerTest.position.column == 0)
            playerTest.move(Direction.RIGHT, gameMap);
        else
            playerTest.move(Direction.LEFT, gameMap);
        count = 0;
        for (int i = 0; i < gameMap.size; i++) {
            for (int j = 0; j < gameMap.size; j++) {
                if (playerTest.getTileKnowledge(new Position(i, j)) == Colour.GREY)
                    count++;
            }
        }
        Assert.assertEquals(gameMap.size*gameMap.size - 2, count);


        //ensuring player movement reveals tiles
        if (playerTest.position.row == 0)
            playerTest.move(Direction.DOWN, gameMap);
        else
            playerTest.move(Direction.UP, gameMap);
        count = 0;
        for (int i = 0; i < gameMap.size; i++) {
            for (int j = 0; j < gameMap.size; j++) {
                if (playerTest.getTileKnowledge(new Position(i, j)) == Colour.GREY)
                    count++;
            }
        }
        Assert.assertEquals(gameMap.size* gameMap.size-3, count);

        //ensuring setPosition reveals tiles
        for (int i = 0; i < gameMap.size; i++) {
            for (int j = 0; j < gameMap.size; j++) {
                if (gameMap.tileColours[i][j] == Colour.GREEN && playerTest.getTileKnowledge(new Position(i, j)) == Colour.GREY) {
                    playerTest.setPosition(new Position(i, j), gameMap);
                    Assert.assertEquals(gameMap.tileColours[i][j], playerTest.getTileKnowledge(new Position(i, j)));
                }

            }
        }
    }

    @Test
    public void testSetTileKnowledge() {
        for (int i = 0; i < gameMap.size; i++) {
            for (int j = 0; j < gameMap.size; j++) {
                playerTest.setTileKnowledge(new Position(i,j), gameMap);
                Assert.assertEquals(gameMap.tileColours[i][j], playerTest.getTileKnowledge(new Position(i, j)));
            }
        }
    }

    @Test
    public void testMove()
    {

        playerTest.position = new Position(0, 0);

        playerTest.move(Direction.RIGHT, gameMap);
        Assert.assertEquals(true, playerTest.position.equals(0, 1));
        playerTest.move(Direction.DOWN, gameMap);
        Assert.assertEquals(true, playerTest.position.equals(1, 1));
        playerTest.move(Direction.UP, gameMap);
        Assert.assertEquals(true, playerTest.position.equals(0, 1));
        playerTest.move(Direction.LEFT, gameMap);
        Assert.assertEquals(true, playerTest.position.equals(0, 0));
        playerTest.move(Direction.UP, gameMap);
        Assert.assertEquals(false, playerTest.position.equals(-1, 0));
        playerTest.move(Direction.LEFT, gameMap);
        Assert.assertEquals(false, playerTest.position.equals(-1, -1));
        Assert.assertEquals(false, playerTest.position.equals(0, -1));

    }

    @Test
    public void testSetPosition()
    {
        playerTest.position = new Position(0,0);
        playerTest.setPosition(new Position(5,5), gameMap);
        Assert.assertEquals(true, playerTest.position.equals(5,5));
        playerTest.setPosition(new Position(2,5), gameMap);
        Assert.assertEquals(true, playerTest.position.equals(2,5));
        playerTest.setPosition(new Position(5,3), gameMap);
        Assert.assertEquals(true, playerTest.position.equals(5,3));
    }
}
