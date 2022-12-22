package com.codecool.polishDraughts.Game;

import java.awt.*;
import java.util.Objects;
import java.util.Scanner;
import static java.awt.Color.*;

public class Game {

    public static int[] startEndMove(Color player, String startEnd) {
        Scanner move = new Scanner(System.in);
        boolean validCoordinates = false;
        int rowsMove = 0;
        int colsMove = 0;
        char playerSign;
        String stringMove;

        if (player == WHITE) {
            playerSign = 'O';
        } else {
            playerSign = 'X';
        }

        do {
            if (Objects.equals(startEnd, "start")) {
            System.out.println("Player " + playerSign + " select your pawn to move (A2): ");
            } else {
            System.out.println("Player " + playerSign + " select your pawn destination (A2): ");
            }

            stringMove = move.nextLine();
            stringMove = stringMove.toUpperCase();
            colsMove = ((int) stringMove.charAt(0))-65;
//            System.out.println("ColsMove: " + colsMove);

            //check for quit
            checkForQuit(stringMove);

            //check for string length max 3
            if (checkMaxLength(stringMove)) continue;

            //check for valid letter in first position
            if (checkLetter(colsMove)) continue;

            //set the coordinate number
            if (stringMove.length() == 2) {
                rowsMove = ((int) stringMove.charAt(1)) - 48 - 1;
//                System.out.println("rowsMove: " + rowsMove);
            } else {
                String stringNumber = stringMove.substring(1);
                try {
                    rowsMove = Integer.parseInt(stringNumber)-1;
                    System.out.println("rowsMove: " + rowsMove);
                } catch (Exception e) {
                    System.out.println("Not a valid number!");
                    continue;
                }
            }

            //check the row number
            if (checkRowNumber(rowsMove)) continue;


            if (Objects.equals(startEnd, "start")) {
                //check for valid pawn or blue area
                validCoordinates = isValidCoordinates(player, validCoordinates, rowsMove, colsMove);
            } else {
                //check for valid destination
                if (Board.board[rowsMove][colsMove].pawnColor != GREEN) {
                    System.out.println("Choose a valid place!");
                } else {
//                System.out.println("Board.board[rowsMove][colsMove].pawnColor: " + Board.board[rowsMove][colsMove].pawnColor);
                    validCoordinates = true;
                }
            }
        } while (!validCoordinates);

        return new int[]{ colsMove, rowsMove };
    }

//
//    public static int[] startMove(Color player) {
//        Scanner move = new Scanner(System.in);
//        boolean validCoordinates = false;
//        int rowsMove = 0;
//        int colsMove = 0;
//        char playerSign;
//        String stringMove;
//
//        if (player == WHITE) {
//            playerSign = 'O';
//        } else {
//            playerSign = 'X';
//        }
//
//        do {
//            System.out.println("Player " + playerSign + " select your pawn to move (A2): ");
//            stringMove = move.nextLine();
//            stringMove = stringMove.toUpperCase();
//            colsMove = ((int) stringMove.charAt(0))-65;
////            System.out.println("ColsMove: " + colsMove);
//
//            //check for quit
//            checkForQuit(stringMove);
//
//            //check for string length max 3
//            if (checkMaxLength(stringMove)) continue;
//
//            //check for valid letter in first position
//            if (checkLetter(colsMove)) continue;
//
//            //set the coordinate number
//            if (stringMove.length() == 2) {
//                rowsMove = ((int) stringMove.charAt(1)) - 48 - 1;
////                System.out.println("rowsMove: " + rowsMove);
//            } else {
//                String stringNumber = stringMove.substring(1);
//                try {
//                    rowsMove = Integer.parseInt(stringNumber)-1;
//                    System.out.println("rowsMove: " + rowsMove);
//                } catch (Exception e) {
//                    System.out.println("Not a valid number!");
//                    continue;
//                }
//            }
//
//            //check the row number
//            if (checkRowNumber(rowsMove)) continue;
//
//            //check for valid pawn or blue area
//            validCoordinates = isValidCoordinates(player, validCoordinates, rowsMove, colsMove);
//        } while (!validCoordinates);
//
//        return new int[]{ colsMove, rowsMove };
//    }
//
//
//    public static int[] endMove(Color player) {
//        Scanner move = new Scanner(System.in);
//        boolean validCoordinates = false;
//        int rowsMove = 0;
//        int colsMove = 0;
//        char playerSign;
//        String stringMove;
//
//        if (player == WHITE) {
//            playerSign = 'O';
//        } else {
//            playerSign = 'X';
//        }
//
//        do {
//            System.out.println("Player " + playerSign + " select your pawn destination (A2): ");
//            stringMove = move.nextLine();
//            stringMove = stringMove.toUpperCase();
//            colsMove = ((int) stringMove.charAt(0))-65;
//            System.out.println("ColsMove: " + colsMove);
//
//            //check for quit
//            checkForQuit(stringMove);
//
//            //check for string length max 3
//            if (checkMaxLength(stringMove)) continue;
//
//            //check for valid letter in first position
//            if (checkLetter(colsMove)) continue;
//
//            //set the coordinate number
//            if (stringMove.length() == 2) {
//                rowsMove = ((int) stringMove.charAt(1)) - 48 - 1;
//                System.out.println("rowsMove: " + rowsMove);
//            } else {
//                String stringNumber = stringMove.substring(1);
//                try {
//                    rowsMove = Integer.parseInt(stringNumber)-1;
//                    System.out.println("rowsMove: " + rowsMove);
//                } catch (Exception e) {
//                    System.out.println("Not a valid number!");
//                    continue;
//                }
//            }
//
//            //check the row number
//            if (checkRowNumber(rowsMove)) continue;
//
//            //check for valid pawn or blue area
////            validCoordinates = isValidCoordinates(player, validCoordinates, rowsMove, colsMove);
//
//            //check for valid destination
//            if (Board.board[rowsMove][colsMove].pawnColor != GREEN) {
//                System.out.println("Choose a valid place!");
//            } else {
////                System.out.println("Board.board[rowsMove][colsMove].pawnColor: " + Board.board[rowsMove][colsMove].pawnColor);
//                validCoordinates = true;
//            }
//
//
//        } while (!validCoordinates);
//
//        return new int[]{ colsMove, rowsMove };
//
//    }


    private static boolean isValidCoordinates(
            Color player,
            boolean validCoordinates,
            int rowsMove,
            int colsMove) {
        if (Board.board[rowsMove][colsMove].pawnColor != player) {
            System.out.println("Choose a valid pawn!");
        } else if (Board.board[rowsMove][colsMove].pawnColor == BLUE) {
            System.out.println("Out of the valid filed");
        } else {
            System.out.println("Board.board[rowsMove][colsMove].pawnColor: " + Board.board[rowsMove][colsMove].pawnColor);
            validCoordinates = true;
        }
        return validCoordinates;
    }

    private static boolean checkRowNumber(int rowsMove) {
        if (!(0<= rowsMove && rowsMove <(Board.board.length))) {
            System.out.println("Not a valid number!");
            return true;
        }
        return false;
    }

    private static boolean checkLetter(int colsMove) {
        if (!(0<= colsMove && colsMove <=(Board.board.length-1))) {
            System.out.println("Not a valid letter!");
            return true;
        }
        return false;
    }

    private static boolean checkMaxLength(String stringMove) {
        if (stringMove.length()>3 || stringMove.length()<2) {
            System.out.println("A letter between A and " + ((char) (Board.board.length+65-1)) +
                    " and a number between 1 and "+ Board.board.length + " please!");
            return true;
        }
        return false;
    }

    private static void checkForQuit(String stringMove) {
        if (stringMove.equals("QUIT")) {
            System.out.println("You quit the game!");
            System.exit(0);
        }
    }


//    public static boolean checkDestination(
//            int selectionCol,
//            int selectionRow,
//            int destinationCol,
//            int destinationRow,
//            Color player) {
//        if (selectionCol-destinationCol)
//    }
}
