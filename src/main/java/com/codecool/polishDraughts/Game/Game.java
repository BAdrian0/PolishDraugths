package com.codecool.polishDraughts.Game;

import java.util.Scanner;

public class Game {

//    public int[] getMove(int player) {
//        Scanner move = new Scanner(System.in);
//        boolean validCoordinates = false;
//        int rowMove = 0;
//        int colsMove = 0;
//        String stringMove;
//
//        do {
//            System.out.println("Player " + player + " enter your move (A2): ");
//            stringMove = move.nextLine();
//            stringMove = stringMove.toUpperCase();
//
//            //check for quit
//            if (stringMove.equals("QUIT")) {
//                System.out.println("You quit the game!");
//                System.exit(0);
//            }
//
//            //check for string length max 3
//            if (stringMove.length()>3 || stringMove.length()<2) {
//                System.out.println("A letter between A and " + ((char) (board.length+65-1)) +
//                        " and a number between 1 and "+ board[0].length + " please!");
//                continue;
//            }
//            //check for valid letter in first position
//            rowMove = ((int) stringMove.charAt(0))-65;
//            if (!(0<=rowMove && rowMove<=(board.length-1))) {
//                System.out.println("Not a valid letter!");
//                continue;
//            }
//            //check for valid number
//            if (stringMove.length() == 2) {
//                colsMove = ((int) stringMove.charAt(1)) - 48 - 1;
//            } else {
//                String stringNumber = stringMove.substring(1);
//                try {
//                    colsMove = Integer.parseInt(stringNumber)-1;
//                } catch (Exception e) {
//                    System.out.println("Not a valid number!");
//                    continue;
//                }
//            }
//            if (!(0<=colsMove && colsMove<(board[0].length))) {
//                System.out.println("Not a valid number!");
//                continue;
//            }
//            //check for unocuppied position
//            if (board[rowMove][colsMove] !=0) {
//                System.out.println("That position is not free!");
//                continue;
//            }
//            validCoordinates = true;
//        } while (!validCoordinates);
//
//        return new int[]{rowMove, colsMove};
//    }
}
