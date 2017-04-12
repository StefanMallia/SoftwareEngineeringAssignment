package SoftwareEngineeringAssignment;


import org.junit.Assert;
import org.junit.BeforeEach;
import org.junit.Test;

import static org.junit.Assert.*;


public class GameTest
{
    Game gameTest;

    @BeforeEach
    public void setUp()
    {
        gameTest = new Game();
    }
    @Test
    public void testSetNumPlayers()
    {
        Assert.assertEquals(false, gameTest.setNumPlayers(1));
        Assert.assertEquals(true, gameTest.setNumPlayers(2));
        Assert.assertEquals(true, gameTest.setNumPlayers(5));
        Assert.assertEquals(true, gameTest.setNumPlayers(8));
        Assert.assertEquals(false, gameTest.setNumPlayers(9));
    }
}
