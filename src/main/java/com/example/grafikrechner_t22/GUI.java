package com.example.grafikrechner_t22;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.stage.Stage;


public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // create an empty container
        Pane root = new Pane();

        // create a new scene with a container as a (root Node)
        // and a size of 600x400 pixels
        Scene scene = new Scene(root, 600, 400);

        //create a chart object
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("1. Graph");

        // add data to the chart
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(1, 23));
        series.getData().add(new XYChart.Data<>(2, 14));
        series.getData().add(new XYChart.Data<>(3, 15));
        //lineChart.getData().add(series);

        // add the chart object to the root node of the container
        root.getChildren().add(lineChart);

        Path parabola = new Path();
        parabola.setStroke(Color.RED);
        parabola.setStrokeWidth(2);

        //create the intersections of the parabola
        MoveTo moveTo = new MoveTo(9,9);
        QuadCurveTo quadCurveTo = new QuadCurveTo(40, 400,900, 30);
        parabola.getElements().addAll(moveTo, quadCurveTo);

        // add the path-object to the root-node of the container
        root.getChildren().add(parabola);

        // set that scene as main scene of the primary stage
        primaryStage.setScene(scene);

        //show that primary stage
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
