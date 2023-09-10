package com.example.app;

import javafx.animation.AnimationTimer;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Bounds;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import org.slf4j.*;

public class MyApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        Character character = new Character(50, 50, 100, 50);
        ScreenView screen = new ScreenView(primaryStage, "blue");

        screen.addCharacter(character);

        AnimationTimer timer = new AnimationTimer() {
            Bounds bounds = screen.getBoundsInLocal();
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
