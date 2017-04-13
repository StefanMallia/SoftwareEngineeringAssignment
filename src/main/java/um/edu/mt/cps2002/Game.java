package um.edu.mt.cps2002;


import java.io.*;
import java.util.Scanner;

public class Game
{
    static int turn;
    static Player[] players;
    static Map map;

    public static boolean setNumPlayers(int n) {
        if(n>8 || n<2) return false;
        else {
            players = new Player[n];
            return true;
            }
        }

    public void startGame() {

    }

    public static void generateHTMLFiles(String directory)
    {


    }
    public static void main(String[] args) {
        System.out.println("Enter Number of players \n");
        java.util.Scanner s = new Scanner(System.in);

        while (!setNumPlayers(s.nextInt()))
            System.out.println("Please enter number between 2 and 8 inclusive");

        map = new Map();
        map.generate();


    }
}
