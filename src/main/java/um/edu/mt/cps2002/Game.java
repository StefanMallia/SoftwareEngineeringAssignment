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
    public static void generateHTMLFiles(Player player,int player_no) {

        String filepath = String.format("/board_%d.html",player_no);
        String outputString = "<table>\n";
        for (int i = 0; i < map.size; i++)
        {
            outputString += "  <tr>\n";
            for (int j = 0; j < map.size; j++)
            {//red represents player position
                if (i == player.position.column && j == player.position.row)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"red\" align=\"center\"><font size=\"5\">('_')</font></td>\n";
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
        outputString += "  </table>";

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

        while (!setNumPlayers(plrs)) {
            System.out.println("Please enter number between 2 and 8 inclusive");
            plrs = s.nextInt();
        }

        do {
            System.out.println("Enter size of grid");
            size=s.nextInt();
            map = new Map();
        }while(!map.setMapSize(size,plrs));

        map.generate();

        for(int i=0;i<players.length;i++){
            players[i] = new Player(map.tileColours);//initialize players with greyed out map knowledge
            generateHTMLFiles(players[i],i+1);

        }

        System.out.println("Valid Moves: up ^ ,down _ ,left < , right > \n" );

        int win =0;

        while(win == 0){
            for(int i=0;i<players.length;i++) {
                if(map.getTileType(players[i].position)==Colour.BLUE){
                    //reset player position to new random position
                    int I =  (int) Math.ceil(Math.random()*map.size);
                    int J = (int) Math.ceil(Math.random()*map.size);
                    players[i].setPosition(new Position(I,J));
                    generateHTMLFiles(players[i],i);

                }

                while(true){
                    System.out.printf("Enter Move for Player %d \n", i + 1);
                    String move = s.next();
                    try {

                        if (move.equals("^")) {
                            players[i].move(Direction.UP, map);
                            generateHTMLFiles(players[i], i);
                            break;
                        } else if (move.equals("_")) {
                            players[i].move(Direction.DOWN, map);
                            generateHTMLFiles(players[i], i);
                            break;
                        } else if (move.equals("<")) {
                            players[i].move(Direction.LEFT, map);
                            generateHTMLFiles(players[i], i);
                            break;
                        } else if (move.equals(">")) {
                            players[i].move(Direction.RIGHT, map);
                            generateHTMLFiles(players[i], i);
                            break;
                        } else continue;
                    }catch(Exception e){
                        System.err.println(e.getMessage());
                    }
                }
            }


            win = Winner();
        }



    }
}
