package um.edu.mt.cps2002;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tim on 11/05/2017.
 */
public class generateTest {
    @Test
    public void SafeProportionTest(){
        GameMap.instance = null;
        GameMapSafe.getInstance();
        GameMap gameMap = GameMap.instance;
        gameMap.setMapSize(20,3);
        gameMap.generate();
        Assert.assertTrue(gameMap.mapProportion()<=0.1);
    }

    @Test
    public void HazardousProportionTest(){
        GameMap.instance = null;
        GameMapHazardous.getInstance();
        GameMap gameMap = GameMap.instance;
        gameMap.setMapSize(20,3);
        gameMap.generate();
        Assert.assertTrue(gameMap.mapProportion()<=0.35 && gameMap.mapProportion()>=0.25);
    }
}
