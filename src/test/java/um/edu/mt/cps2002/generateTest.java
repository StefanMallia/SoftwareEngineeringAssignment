package um.edu.mt.cps2002;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tim on 11/05/2017.
 */
public class generateTest {
    GameMap gameMap;
    @Test
    public void SafeProportionTest(){
        gameMap = new GameMapSafe();
        gameMap.setMapSize(20,3);
        gameMap.generate();
        Assert.assertTrue(gameMap.mapProportion()<=0.1);
    }

    @Test
    public void HazardousProportionTest(){
        gameMap = new GameMapHazardous();
        gameMap.setMapSize(20,3);
        gameMap.generate();
        Assert.assertTrue(gameMap.mapProportion()<=0.35 && gameMap.mapProportion()>=0.25);
    }

}
