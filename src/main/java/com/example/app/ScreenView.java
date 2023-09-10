package com.example.app;


import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class ScreenView {
    private BorderPane borderPane; // Declare borderPane as a class-level variable
    private Character character;
    private Pane canvas;

    // Constructor that initializes a new Screen object
    public ScreenView(Stage primaryStage, String color) {
        canvas = new Pane();

        Screen screen = Screen.getPrimary();
        Rectangle2D screenBounds = screen.getVisualBounds();
        int w = (int) screenBounds.getWidth();
        int h = (int) screenBounds.getHeight();
        Scene scene = new Scene(canvas, w, h, Color.BLACK);

        primaryStage.setTitle("DVD-Screensaver");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void addCharacter(Character character) {
        // Add the character to the BorderPane or any appropriate layout in your BorderPane
        this.character = character;
        this.canvas.getChildren().add(character);

    }

    void checkCollision(Bounds bounds) {
        // Check for collision with screen bounds
        character.bounce(bounds);
    }

    public Bounds getBoundsInLocal() {
        return this.canvas.getBoundsInLocal();
    }
}
