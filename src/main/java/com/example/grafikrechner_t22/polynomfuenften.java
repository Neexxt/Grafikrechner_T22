package com.example.grafikrechner_t22;



import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.chart.LineChart;

import javafx.scene.chart.NumberAxis;

import javafx.scene.chart.XYChart;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;

import javafx.stage.Stage;

// jkd

public class polynomfuenften extends Application {



    @Override

    public void start(Stage primaryStage) throws Exception {



        // Eingabefelder für die Koeffizienten

        TextField[] coefficientsFields = new TextField[6];

        for (int i = 0; i < coefficientsFields.length; i++) {

            coefficientsFields[i] = new TextField();

            coefficientsFields[i].setPrefWidth(50);

        }



        // Beschriftungen für die Eingabefelder

        Label[] coefficientsLabels = new Label[6];

        coefficientsLabels[0] = new Label("x^5");

        coefficientsLabels[1] = new Label("x^4");

        coefficientsLabels[2] = new Label("x^3");

        coefficientsLabels[3] = new Label("x^2");

        coefficientsLabels[4] = new Label("x");

        coefficientsLabels[5] = new Label("K");



        // Anordnung der Eingabefelder und Beschriftungen in einer HBox

        HBox coefficientsBox = new HBox();

        coefficientsBox.setSpacing(10);

        for (int i = 0; i < coefficientsFields.length; i++) {

            VBox vbox = new VBox();

            vbox.getChildren().addAll(coefficientsLabels[i], coefficientsFields[i]);

            coefficientsBox.getChildren().add(vbox);

        }



        // Button zum Aktualisieren des Graphen

        Button updateButton = new Button("Aktualisieren");

        updateButton.setOnAction(event -> {

            // Berechnen der Funktionswerte und Erstellen des Diagramms

            NumberAxis xAxis = new NumberAxis();

            NumberAxis yAxis = new NumberAxis();

            LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

            XYChart.Series<Number, Number> series = new XYChart.Series<>();

            series.setName("Polynom");

            for (double x = -10; x <= 10; x += 0.1) {

                double y = 0;

                for (int i = 0; i < coefficientsFields.length; i++) {

                    double coefficient = 0;

                    try {

                        coefficient = Double.parseDouble(coefficientsFields[i].getText());

                    } catch (NumberFormatException e) {

                        coefficient = 0;

                    }

                    y += coefficient * Math.pow(x, 5 - i);

                }

                series.getData().add(new XYChart.Data<>(x, y));

            }

            lineChart.getData().add(series);



            // Anzeigen des Diagramms

            Scene scene = new Scene(lineChart, 800, 600);

            primaryStage.setScene(scene);

            primaryStage.show();

        });



        // Anordnung der Eingabefelder, Beschriftungen und Buttons in einer VBox

        VBox vbox = new VBox();

        vbox.getChildren().addAll(coefficientsBox, updateButton);



        // Anzeigen der VBox

        Scene scene = new Scene(vbox, 400, 200);

        primaryStage.setTitle("Polynomgraph");

        primaryStage.setScene(scene);

        primaryStage.show();
    }


    }