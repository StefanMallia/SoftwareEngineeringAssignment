package um.edu.mt.cps2002;

import java.io.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class GameTest
{
    Game gameTest;

    @Before
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
        Assert.assertEquals(8, gameTest.players.length);
        Assert.assertEquals(false, gameTest.setNumPlayers(9));

    }


    @Test
    public void generateHTMLFiles()
    {
        gameTest.setNumPlayers(2);
        gameTest.players[0] = new Player();
        gameTest.players[0].setPosition(new Position(0,0));
        gameTest.players[1] = new Player();
        gameTest.players[1].setPosition(new Position(5,5));

        gameTest.map = new Map();
        gameTest.map.setMapSize(6, 2);

        gameTest.players[0].mapKnowledge = new Colour[][]{
                {Colour.GREEN, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
        };
        gameTest.players[1].mapKnowledge = new Colour[][]{
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY},
                {Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREY, Colour.GREEN},
        };
        gameTest.generateHTMLFiles();

        String player1Map;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("player1Map.html"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            player1Map = sb.toString();

            Assert.assertTrue(player1Map.equals("<table>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"green\" align=\"center\"><font size=\"5\">('_')</font><\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  \n" +
                    "</table>"));


        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }

        String player2Map;
        br = null;
        try {
            br = new BufferedReader(new FileReader("player2Map.html"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            player2Map = sb.toString();

            Assert.assertTrue(player2Map.equals("<table>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"grey\"></td>\n" +
                    "    <td width=\"50\" height=\"50\" bgcolor=\"green\" align=\"center\"><font size=\"5\">('_')</font></td>\n" +
                    "  </tr>\n" +
                    "  \n" +
                    "</table>"));
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }



    }
}
