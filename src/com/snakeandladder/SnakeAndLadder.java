package com.snakeandladder;

import java.io.*; // allow user input data

    //Generating a random dice number from 1 to 6
public class SnakeAndLadder {

    public static int diceRoll (int random)
    {
        random = (int)(Math.random()*6 )+1 ;
        return random;
    }

    //Writing a method to build the game
    public static String snakeandladderGame (String start) throws IOException
    {

        BufferedReader myInput = new BufferedReader (new InputStreamReader (System.in));
        int diceRoll = 0;
        int player1Position = 1;
        int player2Position = 1;
        int player1Roll = 1;
        int player2Roll = 1;
        String userInput = "y";

        int Array [] = new int [8];
        Array [0] = 4;
        Array [1] = 17;
        Array [2] = 28;
        Array [3] = 51;
        Array [4] = 62;
        Array [5] = 64;
        Array [6] = 87;
        Array [7] = 98;

        while (userInput.equals ("y") || userInput.equals ("Y")){

            player1Roll =  diceRoll(diceRoll);
            player2Roll =  diceRoll(diceRoll);
            System.out.println ("Player1 rolled a " + player1Roll);
            player1Position = player1Position + player1Roll;        //add the dice number to change the player1 position
            System.out.println ("Player2 rolled a " + player2Roll);
            player2Position = player2Position + player2Roll;        //add the dice number to change the player1 position
            System.out.println("\n");

            // Checking if player's position is on top of the snake or at the bottom of the ladder
            player1Position = player1(player1Position, player1Roll, Array);
            player2Position = player2(player2Position, player2Roll, Array, player1Position);   //check if player1 has won or not

            System.out.println ("Player1 is currently on block " + player1Position);   // player1 current location
            System.out.println ("Player2 is currently on block " + player2Position);   // player2 current location
            System.out.println("\n");

            if (player1Position == 100 || player2Position == 100)  //this will reset the positions
            {
                player1Position = 1;
                player2Position = 1;
                System.out.print ("Do you want to play again from the start? ");
                System.out.println("Press y or n : ");
                userInput = myInput.readLine ();
                System.out.print ("\n");
            }
            else
            {
                System.out.print ("Do you want to play? Press y or n: ");   //continue playing
                userInput = myInput.readLine ();
            }
        }
        return "n";
    }


    //Checking all conditions for player1
    public static int player1 (int player1Position, int player1Roll, int Array []) throws IOException
    {

        if(player1Position == Array[0])
        {
            player1Position = 14;
            System.out.println ("Hooray !!! Player1 climbed a ladder");
        }
        else if (player1Position == Array[1])
        {
            player1Position = 7;
            System.out.println ("Oops !!! Player1 got bit by a snake");

        }
        else if (player1Position == Array[2])
        {
            player1Position = 84;
            System.out.println ("Hooray !!! Player1 climbed a ladder");
        }
        else if (player1Position == Array[3])
        {
            player1Position = 67;
            System.out.println ("Hooray !!! Player1 climbed a ladder");
        }
        else if (player1Position == Array[4])
        {
            player1Position = 19;
            System.out.println ("Oops !!! Player1 got bit by a snake");
        }
        else if (player1Position == Array[5])
        {
            player1Position = 60;
            System.out.println ("Oops !!! Player1 got bit by a snake");
        }
        else if (player1Position == Array[6])
        {
            player1Position = 24;
            System.out.println ("Oops !!! Player1 got bit by a snake");
        }
        else if (player1Position == Array[7])
        {
            player1Position = 78;
            System.out.println ("Oops !!! Player1 got bit by a snake");
        }
        else if (player1Position > 100)
        {
            player1Position = player1Position - player1Roll;
            System.out.println ("Oops!!! Cannot go beyond 100. You will be in your previous position");
        }
        else if (player1Position == 100)
        {
            System.out.println ("CONGRATS !!! PLAYER1 WON THE GAME");
        }
        return player1Position;
    }

    //Checking all conditions for player2
    public static int player2 (int player2Position, int player2Roll, int Array [], int player1Position) throws IOException
    {

        if(player2Position == Array[0])
        {
            player2Position = 14;
            System.out.println ("Hooray !!! Player2 climbed a ladder");
        }
        else if (player2Position == Array[1])
        {
            player2Position = 7;
            System.out.println ("Oops !!! Player2 got bit by a snake");
        }
        else if (player2Position == Array[2])
        {
            player2Position = 84;
            System.out.println ("Hooray !!! Player2 climbed a ladder");
        }
        else if (player2Position == Array[3])
        {
            player2Position = 67;
            System.out.println ("Hooray !!! Player2 climbed a ladder");
        }
        else if (player2Position == Array[4])
        {
            player2Position = 19;
            System.out.println ("Oops !!! Player2 got bit by a snake");
        }
        else if (player2Position == Array[5])
        {
            player2Position = 60;
            System.out.println ("Oops !!! Player2 got bit by a snake");
        }
        else if (player2Position == Array[6])
        {
            player2Position = 24;
            System.out.println ("Oops !!! Player2 got bit by a snake");
        }
        else if (player2Position == Array[7])
        {
            player2Position = 78;
            System.out.println ("Oops !!! Player2 got bit by a snake");
        }
        else if (player2Position > 100)
        {
            player2Position = player2Position - player2Roll;
            System.out.println ("Oops!!! Player2 cannot go beyond 100. They will be in their previous position");
        }
        else if (player2Position == 100 && player1Position != 100)
        {
            System.out.println ("CONGRATS !!! PLAYER2 WON THE GAME");
        }
        return player2Position;
    }

    public static void main (String [] args) throws IOException {
        BufferedReader myInput2 = new BufferedReader (new InputStreamReader (System.in));

        String gameFetch = "y";

        System.out.print ("Do you want to play? ");
        System.out.println("Please enter y or n : ");
        gameFetch = myInput2.readLine ();
        System.out.print ("\n");

        if (gameFetch.equals ("y") || gameFetch.equals ("Y"))
        {
            gameFetch = snakeandladderGame(gameFetch);                //calling the method snakeandladdergame
        }
        System.out.println("\nThanks for playing the game !!!");

    }
}

