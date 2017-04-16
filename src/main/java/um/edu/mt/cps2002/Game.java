package um.edu.mt.cps2002;


import java.lang.String;

import java.io.*;
import java.util.Scanner;

public class Game
{
    //static int turn;
    static Player[] players;
    static Map map;



    public static int Winner(){
        int winner = 0;

        for(int i=0;i<players.length;i++){
            if(map.getTileType(players[i].position)==Colour.YELLOW) {
                winner = i + 1;
                break;
            }
        }

        return  winner;
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
        for (int i = 0; i < map.size; i++)
        {
            outputString += "  <tr>\n";
            for (int j = 0; j < map.size; j++)
            {//red reresents player position
                if (player.mapKnowledge[i][j] == Colour.YELLOW)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"yellow\" align=\"center\"><font size=\"5\">('_')</font></td>\n";
                else if (i == player.position.row && j == player.position.column)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"green\" align=\"center\"><font size=\"5\">('_')</font></td>\n";
                else if (player.mapKnowledge[i][j] == Colour.GREEN)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"green\"></td>\n";
                else if (player.mapKnowledge[i][j] == Colour.BLUE)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"blue\"></td>\n";
                else if (player.mapKnowledge[i][j] == Colour.YELLOW)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"yellow\"></td>\n";
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

        do {
            System.out.println("Enter size of grid");
            size=s.nextInt();
            map = new Map();
        }while(!map.setMapSize(size,plrs));

        map.generate();

        for(int i=0;i<players.length;i++){
            players[i] = new Player(map.tileColours);//initialize players with greyed out map knowledge
            generateHTMLFiles(players[i],i+1, ".");

        }

        System.out.println("Valid Moves: up ^ ,down _ ,left < , right > \n" );

        int win =0;

        while(win == 0){
            for(int i=0;i<players.length;i++) {



                while(true){
                    System.out.printf("Enter Move for Player %d \n", i + 1);
                    String move = s.next();

                    if (move.equals("^") && players[i].move(Direction.UP, map)) {
                        generateHTMLFiles(players[i], i+1, ".");
                        break;
                    } else if (move.equals("_") && players[i].move(Direction.DOWN, map)) {
                        generateHTMLFiles(players[i], i+1, ".");
                        break;
                    } else if (move.equals("<") && players[i].move(Direction.LEFT, map)) {
                        generateHTMLFiles(players[i], i+1, ".");
                        break;
                    } else if (move.equals(">") && players[i].move(Direction.RIGHT, map)) {
                        generateHTMLFiles(players[i], i+1, ".");
                        break;
                    } else continue;

                }
                if(map.getTileType(players[i].position)==Colour.BLUE){
                    System.out.printf("Player %d    has landed on water! \n",i+1);
                    //reset player position to initial position
                    players[i].setPosition(new Position(players[i].initialPosition), map);
                    generateHTMLFiles(players[i],i+1, ".");

                }
            }


            win = Winner();
        }

        System.out.printf("Player: %d Wins!",win);


    }
}
