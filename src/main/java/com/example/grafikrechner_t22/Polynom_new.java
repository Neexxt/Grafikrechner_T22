package com.example.lk_grafikrechner;


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

import javafx.fxml.FXMLLoader;

import java.io.IOException;

// jkd

public class Polynom_new extends Application {


    @Override

    public void start(Stage primaryStage) throws Exception {



        // Eingabefelder für die Koeffizienten

        TextField[] coefficientsFields = new TextField[6];

        for (int i = 0; i < coefficientsFields.length; i++) {

            coefficientsFields[i] = new TextField();

            coefficientsFields[i].setPrefWidth(50);

        }
        Label wendepunkt = new Label("Wendepunkt");



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

        for (int o = 0; o < coefficientsFields.length; o++) {
            VBox vbox2 = new VBox();
            vbox2.getChildren().addAll(coefficientsLabels[o], coefficientsFields[o]);
            coefficientsBox.getChildren().add(vbox2);
        }


        // Button zum Aktualisieren des Graphen

        Button updateButton = new Button("Aktualisieren");

        updateButton.setOnAction(event -> {

            // Berechnen der Funktionswerte und Erstellen des Diagramms

            NumberAxis xAxis = new NumberAxis(-5, 5, 1);

            NumberAxis yAxis = new NumberAxis(-5, 5, 1);

            LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

            XYChart.Series<Number, Number> series = new XYChart.Series<>();

            series.setName("Polynom des maximal fünften Grades mit Zoomfunktion");

            for (double x = -50; x <= 50; x += 0.1) {

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
            // Füge Event-Handler für das ScrollEvent hinzu
            lineChart.setOnScroll(event1 -> {
                double zoomFactor = event1.getDeltaY() > 0 ? 1.1 : 0.9;
                xAxis.setAutoRanging(false);
                yAxis.setAutoRanging(false);
                xAxis.setLowerBound(xAxis.getLowerBound() * zoomFactor);
                xAxis.setUpperBound(xAxis.getUpperBound() * zoomFactor);
                yAxis.setLowerBound(yAxis.getLowerBound() * zoomFactor);
                yAxis.setUpperBound(yAxis.getUpperBound() * zoomFactor);
            });

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
public class MyController extends GUI {
    public MyController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("C:\\Users\\ender\\IdeaProjects\\LK_Grafikrechner\\src\\main\\java\\com\\example\\lk_grafikrechner\\GUI.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    public static void main(String[] args) {
        launch(args);
    }


}
