package com.example.app;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Character extends Rectangle {

    Random randomWidth = new Random();
    Random randomHeight = new Random();

    // Generate a random number that is either 1 or -1
    int randomWidthNum = randomWidth.nextBoolean() ? 5 : -5;
    int randomHeightNum = randomHeight.nextBoolean() ? 5 : -5;


    private double dx = randomWidthNum; // Initial horizontal velocity
    private double dy = randomHeightNum; // Initial vertical velocity
    public Character(double x, double y, double width, double height) {
        super(x, y, width, height);
        setFill(Color.WHITE); // Fill color set to transparent
        setStroke(Color.WHITE); // Border color
    }

    public void move() {
        // Implement the logic to move the character
        setTranslateX(getTranslateX()  + dx);
        setTranslateY(getTranslateY() + dy);
    }


    public void bounce(Bounds bounds){
        double x = getTranslateX();
        double y = getTranslateY();

        if (x + getWidth() * 2 >= bounds.getWidth() || x + getWidth() <= 0) {
            dx = -dx;
        }
        if (y + getHeight() * 2 >= bounds.getHeight() || y + getHeight() <= 0) {
            dy = -dy;
        }
    }
}