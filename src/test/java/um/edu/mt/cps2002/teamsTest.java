package um.edu.mt.cps2002;

import org.junit.Before;

/**
 * Created by tim on 11/05/2017.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class teamsTest {


    Player playersTest[];
    Team teamsTest[];
    GameMap gameMap;

    @Before
    public void setUp() {
        GameMap.getInstance();
        gameMap = GameMap.instance;
        gameMap.setMapSize(8,4);
        gameMap.generate();
        Game.players = new Player[4];

        for(int i=0;i<Game.players.length;i++){
            Game.players[i] = new Player(gameMap);
        }

        Game.teams = new Team[2];
        Game.teams[0] = new Team();
        Game.teams[1] = new Team();

        Game.dividePlayers();
    }

    @Test
    public void teamKnowledgeTest(){
        Position position = new Position(2,3);
        Game.players[0].setTileKnowledge(position,gameMap);
        Team t = Game.players[0].team;
        ArrayList<Player> teamplayers = t.getPlayers();

        Assert.assertTrue(teamplayers.get(0).getTileKnowledge(position)==teamplayers.get(1).getTileKnowledge(position));


    }
}
