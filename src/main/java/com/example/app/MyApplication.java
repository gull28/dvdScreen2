package com.example.app;

import javafx.animation.AnimationTimer;
import javafx.application.*;
import javafx.geometry.Bounds;
import javafx.stage.*;

public class MyApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        Character character = new Character(50, 50, 50, 50);
        ScreenView screen = new ScreenView(primaryStage, "blue");


        screen.addCharacter(character);

        AnimationTimer timer = new AnimationTimer() {
            final Bounds bounds = screen.getBoundsInLocal();
            @Override
            public void handle(long now) {
                character.move();
                character.bounce(bounds);
            }

        };
        timer.start();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
