package um.edu.mt.cps2002;


import java.lang.String;

import java.io.*;
import java.util.Scanner;

public class Game
{
    //static int turn;
    static Player[] players;
    static GameMap gameMap;
    static Team teams[];


    public static void dividePlayers(){
        int playersPerTeam = players.length/teams.length;
        int numberOfPlayersleft = players.length;
        int count;

        for(int i=0;i<teams.length;i++){
            count=1;
            while(numberOfPlayersleft >0 && count<=playersPerTeam){
                players[numberOfPlayersleft-1].team = teams[i];
                teams[i].addPlayers(players[numberOfPlayersleft-1]);
                count++;
                numberOfPlayersleft--;
            }
        }

    }

    public static boolean Winner(Player player) {
        if (gameMap.getTileType(player.position) == Colour.YELLOW)
            return true;
        return false;
}

    public static boolean setNumPlayers(int n) {
        if(n>8 || n<2) return false;
        else {
            players = new Player[n];
            return true;
            }
        }
/*
    public void startGame() {

    }
*/
    public static void generateHTMLFiles(Player player,int player_no, String directory) {

        if (directory.length() >= 1 && !directory.endsWith("/"))
            directory = directory + "/";
        String filepath = String.format(directory + "./player%dMap.html", player_no);
        String outputString = "<table>\n";
        for (int i = 0; i < gameMap.size; i++)
        {
            outputString += "  <tr>\n";
            for (int j = 0; j < gameMap.size; j++)
            {
                if (player.getTileKnowledge(new Position(i, j)) == Colour.YELLOW)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"yellow\" align=\"center\"><font size=\"5\">('_')</font></td>\n";
                else if (i == player.position.row && j == player.position.column)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"green\" align=\"center\"><font size=\"5\">('_')</font></td>\n";
                else if (player.getTileKnowledge(new Position(i, j)) == Colour.GREEN)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"green\"></td>\n";
                else if (player.getTileKnowledge(new Position(i, j)) == Colour.BLUE)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"blue\"></td>\n";
                else
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n";
            }
            outputString += "  </tr>\n";
        }
        outputString += "</table>";

        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter(new FileWriter(filepath,false)); // false so that FileWriter overwrites rather than appends
            writer.write(outputString);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
    public static void main(String[] args) {
        System.out.println("Enter Number of players \n");
        java.util.Scanner s = new Scanner(System.in);
        int plrs=0;
        int size=0;

        do{
            System.out.println("Please enter number between 2 and 8 inclusive");
            plrs = s.nextInt();
        }while (!setNumPlayers(plrs));

        System.out.println("Enter 1 for Hazardous Map mode and 2 for Safe mode");

        int m;

        do{
            m = s.nextInt();
        }while(m!=1 && m!=2);

        if(m==1)
            gameMap = GameMapHazardous.getInstance();
        else
            gameMap = GameMapSafe.getInstance();

        do {
            System.out.println("Enter size of grid");
            size=s.nextInt();
        }while(!gameMap.setMapSize(size,plrs));

        gameMap.generate();

        for(int i=0;i<players.length;i++){
            players[i] = new Player(gameMap);//initialize players with greyed out gameMap knowledge
            generateHTMLFiles(players[i],i+1, ".");

        }

        System.out.println("Team mode on or off ? (y/n)");
        if(s.next().equals("y")){
            System.out.println("Enter number of teams (must divide evenly into number of players)");
            int num_teams;

            do{
                num_teams = s.nextInt();
            }while(num_teams>players.length || players.length % num_teams !=0);

            teams = new Team[num_teams];

            for(int i=0;i<num_teams;i++){
                teams[i]= new Team();
            }

            dividePlayers();
        }


        System.out.println("Valid Moves: up ^ ,down _ ,left < , right > \n" );

        boolean win = false;

        while(!win){
            for(int i=0;i<players.length;i++) {



                while(true){
                    System.out.printf("Enter Move for Player %d \n", i + 1);
                    String move = s.next();

                    if (move.equals("^") && players[i].move(Direction.UP, gameMap)) {
                        generateHTMLFiles(players[i], i+1, ".");
                        break;
                    } else if (move.equals("_") && players[i].move(Direction.DOWN, gameMap)) {
                        generateHTMLFiles(players[i], i+1, ".");
                        break;
                    } else if (move.equals("<") && players[i].move(Direction.LEFT, gameMap)) {
                        generateHTMLFiles(players[i], i+1, ".");
                        break;
                    } else if (move.equals(">") && players[i].move(Direction.RIGHT, gameMap)) {
                        generateHTMLFiles(players[i], i+1, ".");
                        break;
                    } else continue;

                }
                if(gameMap.getTileType(players[i].position)==Colour.BLUE){
                    System.out.printf("Player %d    has landed on water! \n",i+1);
                    //reset player position to initial position
                    players[i].setPosition(new Position(players[i].initialPosition), gameMap);
                    generateHTMLFiles(players[i],i+1, ".");

                }
            }

            for (int player_index = 0; player_index < Game.players.length; player_index++)
                if (Game.Winner(Game.players[player_index])) {
                    win = true;
                    System.out.printf("Player: %d Wins!", player_index + 1);
                }
        }




    }
}
