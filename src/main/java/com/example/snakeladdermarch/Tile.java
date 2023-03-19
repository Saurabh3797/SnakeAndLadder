package com.example.snakeladdermarch;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    public Tile(int tilesize){
        setWidth(tilesize);
        setHeight(tilesize);
        setFill(Color.AQUA);
        setStroke(Color.BLACK);
    }
}
