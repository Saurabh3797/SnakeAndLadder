package com.example.snakeladdermarch;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {

    public static final int tileSize = 40, width=10,height= 10,
            buttonLine=tileSize*height + 50, infoLine =tileSize*height + 20;

    Player playerOne,playerTwo;

    Boolean firstPlyTurn = true, gameStart = false;


    int diceValue;
    private Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*tileSize, height*tileSize+200);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height ; j++) {
                Tile tile = new Tile(tileSize);
                tile.setTranslateX(i*tileSize);
                tile.setTranslateY(j*tileSize);
                root.getChildren().addAll(tile);
            }

        }

//        now step for putting img on board.

        Image img = new Image("C:\\Users\\RAHUL\\IdeaProjects\\SnakeLadderMarch\\src\\img.png");
        ImageView boardImage = new ImageView();
        boardImage.setFitWidth(width*tileSize);
        boardImage.setFitHeight(height*tileSize);
        boardImage.setImage(img);
        root.getChildren().addAll(boardImage);

//        for button
        Button StartButton = new Button("Start");
        StartButton.setTranslateX(180);
        StartButton.setTranslateY(buttonLine);

//        for player 1
        Button PlayerOneButton = new Button("Player1");
        PlayerOneButton.setTranslateX(30);
        PlayerOneButton.setTranslateY(buttonLine);
//        for player 2
        Button PlayerTwoButton = new Button("Player2");
        PlayerTwoButton.setTranslateX(300);
        PlayerTwoButton.setTranslateY(buttonLine);

        Label dicLabel = new Label("Let's Start Game");
        dicLabel.setTranslateX(160);
        dicLabel.setTranslateY(infoLine);

//        player
        playerOne = new Player("Saurabh", Color.RED,tileSize/2);
        playerTwo = new Player( "Raju",Color.BLUE,tileSize/2-5);

         // for moving first player
        PlayerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart){
                    if(firstPlyTurn){
                        diceValue = rollDice();
                        dicLabel.setText("dice" + diceValue);
                        playerOne.movePlayer(diceValue);
                        firstPlyTurn = !firstPlyTurn;
                        if(playerOne.CheckWinner()){
                            dicLabel.setText("Winner is "+ playerOne.getName());
                            StartButton.setText("Restart");
                            StartButton.setDisable(false);
                            firstPlyTurn = true;
                            gameStart = false;
                        }
                    }
                }
            }
        });

        // for moving second player
        PlayerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart){
                    if(!firstPlyTurn){
                        diceValue = rollDice();
                        dicLabel.setText("dice" + diceValue);
                        playerTwo.movePlayer(diceValue);
                        firstPlyTurn = !firstPlyTurn;
                        if(playerTwo.CheckWinner()){
                            dicLabel.setText("Winner is "+ playerTwo.getName());
                            StartButton.setText("Restart");
                            StartButton.setDisable(false);
                            firstPlyTurn = true;
                            gameStart = false;
                        }
                    }
                }
            }
        });

        StartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStart = true;
                StartButton.setDisable(true);
                playerOne.setStart();
                playerTwo.setStart();
            }
        });

        root.getChildren().addAll(StartButton,PlayerOneButton,PlayerTwoButton,dicLabel,playerOne.getCoin(),playerTwo.getCoin());

        return root;

    }
    private int rollDice(){
        return  (int)(Math.random()*6+1);
    }
    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(createContent());
        stage.setTitle("Snake & Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}