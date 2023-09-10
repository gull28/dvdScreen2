package com.example.app;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Character extends Rectangle {

    Random randomWidth = new Random();
    Random randomHeight = new Random();

    // Generate a random number that is either 1 or -1
    int randomWidthNum = randomWidth.nextBoolean() ? 1 : -1;
    int randomHeightNum = randomHeight.nextBoolean() ? 1 : -1;


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

        double x = getTranslateX(); // Use getTranslateX() to get the character's X position
        double y = getTranslateY(); // Use getTranslateY() to get the character's Y position

        if (x + getWidth() >= bounds.getWidth() || x <= 0) {
            dx = -dx;
        }
        if (y + getHeight() >= bounds.getHeight() || y <= 0) {
            dy = -dy;
        }
    }
}
