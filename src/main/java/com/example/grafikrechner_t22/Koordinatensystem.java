package com.example.lk_grafikrechner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Koordinatensystem extends Application {

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(700, 800);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Verschiebe den Ursprung auf die Mitte des Canvas
        gc.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);

        // Zeichne x-Achse
        gc.setStroke(Color.BLACK);
        gc.strokeLine(-canvas.getWidth() / 2 + 60, 0, canvas.getWidth() / 2 - 60, 0);

        // Zeichne y-Achse
        gc.strokeLine(0, -canvas.getHeight() / 2 + 60, 0, canvas.getHeight() / 2 - 60);

        // Füge Skalen an den Achsen hinzu
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font("Arial", 12));
        for (int i = -10; i <= 10; i++) {
            if (i != 0) {
                gc.fillText(String.valueOf(i), i * 20, 20);
                gc.strokeLine(i * 20, -5, i * 20, 5);
                gc.fillText(String.valueOf(i), -20, i * -20);
                gc.strokeLine(-5, i * -20, 5, i * -20);
            }
        }

        BorderPane root = new BorderPane(canvas);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
