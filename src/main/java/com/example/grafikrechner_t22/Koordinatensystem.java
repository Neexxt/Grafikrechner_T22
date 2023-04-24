package com.example.lk_grafikrechner;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.ScrollEvent;
import javafx.scene.transform.Affine;
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
        final double[] scale = {1.0};

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

        // Zoom-Funktionen hinzufügen
        canvas.setOnScroll(scrollEvent -> {
            double scrollDelta = scrollEvent.getDeltaY();
            // Berechnung des zoom-faktors basierend auf dem Mausrad-Delta
            double zoomFactor = Math.exp(0.001 * scrollDelta);
            // neue Skalierung berechnen
            scale[0] *= zoomFactor;
            // Transformation anwenden
            gc.scale(zoomFactor, zoomFactor);
        });

        canvas.setOnKeyPressed(keyEvent -> {
            //zoom out mit der Maus
            if (keyEvent.getCode() == KeyCode.MINUS || keyEvent.getCode() == KeyCode.SUBTRACT) {
                scale[0] /= 1.1;
                gc.scale(0.9, 0.9);
            }
            //zoom in mit der Maus
            if (keyEvent.getCode() == KeyCode.PLUS || keyEvent.getCode() == KeyCode.ADD) {
                scale[0] *= 1.1;
                gc.scale(1.1, 1.1);
            }
        });
        canvas.setOnKeyPressed(keyEvent -> {
//zoom out mit Strg und Mausrad
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.MINUS || keyEvent.getCode() == KeyCode.SUBTRACT) {
                scale[0] /= 1.1;
                gc.scale(0.9, 0.9);
            }
//zoom in mit Strg und Mausrad
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.PLUS || keyEvent.getCode() == KeyCode.ADD) {
                scale[0] *= 1.1;
                gc.scale(1.1, 1.1);
            }
        });
        canvas.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.SPACE) {
                scale[0] *= 1.1;
                gc.scale(1.1, 1.1);
            }
            if (keyEvent.getCode() == KeyCode.F1) {
                scale[0] *= 1.1;
            }
        });


        BorderPane root = new BorderPane(canvas);
            Scene scene = new Scene(root, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        public static void main (String[] args) {
            launch(args);
        }
    }

