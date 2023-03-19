package com.example.snakeladdermarch;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {

     private ArrayList<Pair<Integer,Integer>> positionCoordinates;
     private ArrayList<Integer>snakeladder;


    public Board(){
        populatePositionCoordinates();
        setSnakeLadder();
    }
    private void populatePositionCoordinates(){
        positionCoordinates = new ArrayList<>();
        positionCoordinates.add(new Pair<>(0,0)); //dummy value
        for (int i = 0; i < SnakeLadder.height ; i++) {
            for (int j = 0; j < SnakeLadder.width ; j++) {
//                x-cordi
                int xcord = 0;
                if(i%2 == 0){
                    xcord = j*SnakeLadder.tileSize +  SnakeLadder.tileSize/2;
                }
                else{
                    xcord = SnakeLadder.height * SnakeLadder.tileSize - j*SnakeLadder.tileSize - SnakeLadder.tileSize/2;
                }
//                y-cordi
                int ycord = SnakeLadder.height * SnakeLadder.tileSize - i*SnakeLadder.tileSize - SnakeLadder.tileSize/2;

                positionCoordinates.add(new Pair<>(xcord,ycord));

            }
            
        }
    }

    private void setSnakeLadder(){
        snakeladder = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            snakeladder.add(i);
        }
        snakeladder.set(4,25);
        snakeladder.set(13,46);
        snakeladder.set(27,5);
        snakeladder.set(33,49);
        snakeladder.set(40,3);
        snakeladder.set(42,63);
        snakeladder.set(43,18);
        snakeladder.set(50,69);
        snakeladder.set(54,31);
        snakeladder.set(62,81);
        snakeladder.set(66,45);
        snakeladder.set(74,92);
        snakeladder.set(76,58);
        snakeladder.set(89,53);
        snakeladder.set(99,41);

    }
//          cordinate of x
    public int getXCordinate(int position){
        if (position>0 && position<=100){
            return positionCoordinates.get(position).getKey();
        }
        return -1;
    }

    //          cordinate of y
    public int getYCordinate(int position){
        if (position>0 && position<=100){
          return  positionCoordinates.get(position).getValue();
        }
        return -1;
    }

    public int getSnakeLadder(int position){
         return snakeladder.get(position);
    }
// just for testing or printing code
//    public static void main(String[] args) {
//        Board board = new Board();
//
//        for (int i = 0; i < board.positionCoordinates.size(); i++) {
//            System.out.println(i + " = x : " + board.positionCoordinates.get(i).getKey()
//            + " y : " + board.positionCoordinates.get(i).getValue());
//        }
//
//    }
}
