package um.edu.mt.cps2002;

import java.io.*;

public class Game
{
    int turn;
    Player[] players;
    Map map;

    public boolean setNumPlayers(int n)
    {
        return true;
    }
    public void startGame()
    {

    }
    public void generateHTMLFiles(String directory)
    {
        int mapSize = 6;
        Colour[][] playerKnowledge = new Colour[mapSize][mapSize]; //initialized to 0 which is GREY
        playerKnowledge[0][0] = Colour.GREEN;
        Position playerPosition = new Position(0,0);


        String outputString = "<table>\n";
        for (int i = 0; i < mapSize; i++)
        {
            outputString += "  <tr>\n";
            for (int j = 0; j < mapSize; j++)
            {
                if (i == playerPosition.row && j == playerPosition.column)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"green\" align=\"center\"><font size=\"5\">('_')</font></td>\n";
                else if (playerKnowledge[i][j] == Colour.GREEN)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"green\"></td>\n";
                else if (playerKnowledge[i][j] == Colour.BLUE)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"blue\"></td>\n";
                else if (playerKnowledge[i][j] == Colour.YELLOW)
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
            writer = new BufferedWriter(new FileWriter(directory+"player1Map.html"));
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



        playerKnowledge = new Colour[mapSize][mapSize]; //initialized to 0 which is GREY
        playerKnowledge[5][5] = Colour.GREEN;
        playerPosition = new Position(5,5);


        outputString = "<table>\n";
        for (int i = 0; i < mapSize; i++)
        {
            outputString += "  <tr>\n";
            for (int j = 0; j < mapSize; j++)
            {
                if (i == playerPosition.row && j == playerPosition.column)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"green\" align=\"center\"><font size=\"5\">('_')</font></td>\n";
                else if (playerKnowledge[i][j] == Colour.GREEN)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"green\"></td>\n";
                else if (playerKnowledge[i][j] == Colour.BLUE)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"blue\"></td>\n";
                else if (playerKnowledge[i][j] == Colour.YELLOW)
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"yellow\"></td>\n";
                else
                    outputString += "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n";
            }
            outputString += "  </tr>\n";
        }
        outputString += "  </table>";

        writer = null;
        try
        {
            writer = new BufferedWriter(new FileWriter(directory+"player2Map.html"));
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
    public static void main(String[] args)
    {

    }
}
