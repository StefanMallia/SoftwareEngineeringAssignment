package um.edu.mt.cps2002;

import com.sun.xml.internal.ws.dump.LoggingDumpTube;

import java.util.ArrayList;

/**
 * Created by tim on 11/05/2017.
 */
public class Team {
    ArrayList<Player> players;

    Team(){
        players = new ArrayList<Player>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void addPlayers(Player player){
        players.add(player);
    }

    public void updateTeamTileKnowledge(Position position,Colour colour){
        for(int i=0;i<players.size();i++){
            players.get(i)._setTileKnowledge(position,colour);
        }
    }

    public void updateTeamTileKnowledge(Position position,GameMap gameMap){
        for(int i=0;i<players.size();i++){
            players.get(i)._setTileKnowledge(position,gameMap);
        }
    }
}
