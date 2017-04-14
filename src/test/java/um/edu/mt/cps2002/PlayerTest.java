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
    public void testMove()
    {
        try {
            playerTest.position = new Position(0, 0);

            playerTest.move(Direction.RIGHT, map);
            Assert.assertEquals(true, playerTest.position.equals(0, 1));
            playerTest.move(Direction.DOWN, map);
            Assert.assertEquals(true, playerTest.position.equals(1, 1));
            playerTest.move(Direction.UP, map);
            Assert.assertEquals(true, playerTest.position.equals(0, 1));
            playerTest.move(Direction.LEFT, map);
            Assert.assertEquals(true, playerTest.position.equals(0, 0));

        }catch(Exception e){
            System.err.println(e.getMessage());

        }
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
