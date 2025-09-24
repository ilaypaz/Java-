package com.example.lab4;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
public class prob2 extends Application {

        private Text prompt = new Text(50, 50, "Programming is fun");

        @Override // Override the stage method in the Application class
        public void start(Stage primaryStage) {
            HBox paneForButtons = new HBox(20);
            Button btLeft = new Button("<=");
            Button btRight = new Button("=>");
            paneForButtons.getChildren().addAll(btLeft, btRight);//gathers the think under paneforButtons
            paneForButtons.setAlignment(Pos.CENTER);//centers them
            BorderPane pane = new BorderPane();//set up perimiter
            pane.setBottom(paneForButtons);

            HBox paneForRadioButtons = new HBox(20);
            RadioButton red = new RadioButton("Red");
            RadioButton yellow = new RadioButton("Yellow");
            RadioButton black = new RadioButton("Black");
            RadioButton orange = new RadioButton("Orange");
            RadioButton green = new RadioButton("Green");
            paneForRadioButtons.getChildren().addAll(red, yellow,black, orange, green);

            ToggleGroup group = new ToggleGroup();//create a group for the colors
            red.setToggleGroup(group);
            yellow.setToggleGroup(group);
            black.setToggleGroup(group);
            orange.setToggleGroup(group);
            green.setToggleGroup(group);

            Pane paneForText = new Pane();
            paneForText.setStyle("-fx-border-color: black");
            paneForText.getChildren().add(prompt);
            pane.setCenter(paneForText);//center the text
            pane.setTop(paneForRadioButtons);

            btLeft.setOnAction(e -> prompt.setX(prompt.getX() - 10));//position arrow keys
            btRight.setOnAction(e -> prompt.setX(prompt.getX() + 10));//position the other arrow key

            red.setOnAction(e -> {
                if (red.isSelected()) {
                    prompt.setFill(Color.RED);//color it red
                }
            });

            yellow.setOnAction(e -> {
                if (yellow.isSelected()) {
                    prompt.setFill(Color.YELLOW);//color it yellow
                }
            });

            black.setOnAction(e -> {
                if (black .isSelected()) {
                    prompt.setFill(Color.BLACK);//color it black when chosen
                }
            });

            orange.setOnAction(e -> {
                if (orange.isSelected()) {
                    prompt.setFill(Color.ORANGE);//color it orange when chosen
                }
            });

            green.setOnAction(e -> {
                if (green.isSelected()) {
                    prompt.setFill(Color.GREEN);//color it green when chose
                }
            });

            // Create a scene and place it in the stage
            Scene scene = new Scene(pane, 450, 150);
            primaryStage.setTitle("Exercise_16_01"); // Set the stage title
            primaryStage.setScene(scene); // Place the scene in the stage
            primaryStage.show(); // Display the stage
        }
    }
