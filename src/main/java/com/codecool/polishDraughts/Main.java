package com.codecool.polishDraughts;

import com.codecool.polishDraughts.Game.Board;
import com.codecool.polishDraughts.Game.Game;
import com.codecool.polishDraughts.Game.Pawn;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
import static java.awt.Color.*;



public class Main {
    public static void main(String[] args) { //throws InterruptedException

        boolean endGame = false;
        int n;
        int[] selection;
        int[] destination;
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("enter an integer between 10 and 20 for board size: ");
            n = keyboard.nextInt();
        } while (n<5 || n>20);
//        int n = 6;
        Board.board = Board.board(n);

        Color player = BLACK;

        do {
            //change the player
            if (player == WHITE) {
                player = BLACK;
            } else {
                player = WHITE;
            }

//            Board.displayBoard();
            Board.printBoard();
            selection = Game.startMove(player);
//            System.out.println("Selection"+ selection);
            Board.choosePawn(selection[0], selection[1]);

            Board.printBoard();
            destination = Game.endMove(player);
            Board.removePawn(selection[0], selection[1]);
            Board.movePawn(destination[0], destination[1],player);
            Board.printBoard();
//            Board.setPawn(selection[0], selection[1], player);
//            Board.printBoard();

        } while (true);



    }
}
