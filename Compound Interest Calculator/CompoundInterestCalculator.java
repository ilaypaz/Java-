package com.example.lab4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CompoundInterestCalculator extends Application {

    @Override
    public void start(Stage primaryStage) {//BorderPane as the root layout.
        primaryStage.setTitle("Compound Interest Calculator");//Set title as “Compound Interest Calculator”

        BorderPane root = new BorderPane();     // Create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER); // Set center alignment
        pane.setPadding(new Insets(10, 10, 10, 10));//This creates padding/margin of 10 pixels on all four sides (top, right, bottom, left).
        pane.setHgap(10);//horizontal gap between columns
        pane.setVgap(10); //  Vertical gap between rows
        pane.add(new Label("Invested Amount (P):"), 0, 0);//This line creates a new Label with the text "Invested Amount (P):".
        TextField investedAmountField = new TextField();//method adds an empty textbox for user input
        pane.add(investedAmountField, 1, 0);//where it will be placed
        pane.add(new Label("Rate of Interest (r):"), 0, 1);//column 1 row 2
        TextField rateOfInterestField = new TextField();
        pane.add(rateOfInterestField, 1, 1);
        pane.add(new Label("Investment Years (t):"), 0, 2);//column 1 row 3
        TextField investmentYearsField = new TextField();
        pane.add(investmentYearsField, 1, 2);

        Label frequencyLabel = new Label("Frequency of Interest:");//throwing a label onto an area
        pane.add(frequencyLabel, 0, 3);

        RadioButton radioButton1 = new RadioButton("Compounded Yearly");
        RadioButton radioButton2 = new RadioButton("Compounded Half-Yearly");
        RadioButton radioButton3 = new RadioButton("Compounded Quarterly");

        ToggleGroup radioGroup = new ToggleGroup();//creating the buttons as a group
        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);
        radioButton3.setToggleGroup(radioGroup);

        HBox frequencyBox = new HBox(radioButton1, radioButton2, radioButton3);//creating hbox with buttons
        frequencyBox.setAlignment(Pos.CENTER);//center the box
        pane.add(frequencyBox, 1, 3, 2, 1);//add the hBox frequency box to column2, row 4, it will span 2 columns, and span one row.

        Button calculationButton = new Button("Calculate");
        pane.add(calculationButton, 1, 4);//column 2, row 5
        TextArea txtarea = new TextArea();//creating a text area
        txtarea.setEditable(false);//the text area cannot be edited by the user
        txtarea.setWrapText(true);//if your sentence is too long it iwll squeez into next line
        root.setBottom(txtarea);


        // Process events
        calculationButton.setOnAction(e ->{
           try{
               double P = Double.parseDouble(investedAmountField.getText());//get the p value from the text inputted
               double r = Double.parseDouble(rateOfInterestField.getText());//get value from what is typed in
               int t = Integer.parseInt(investmentYearsField.getText());//get the int value fo eyars from what is typed in
               int n;

               if(radioGroup.getSelectedToggle() == radioButton1){
                    n=1;//(Compounded Yearly)
               }
               else if(radioGroup.getSelectedToggle() == radioButton2){
                    n=2;//if they select the half year choice
               }
               else if(radioGroup.getSelectedToggle() == radioButton3){
                   n=4;//if they select the quarter dividing year
               }
               else throw new IllegalArgumentException ("No existing  frequency selected");
               Interest interest = new Interest(P, r, n, t);
               double finalAmount = interest.amount();//use method from earlier to get total amount
               double totalInterest = interest.getI(); // Get total interest earned

               txtarea.setText(String.format("Invested Amount (P): $%.2f\nTotal Interest Earned (I): $%.2f\nFinal Amount (A): $%.2f", P, totalInterest, finalAmount));//write this out

           } catch (NumberFormatException ex) {
               txtarea.setText("Please enter valid numerical values.");//if the use inputs crappy values this is here to help
           }
        });

        root.setCenter(pane);//centers the pop up window

        Scene scene = new Scene(root, 400, 300);//creates the window
        primaryStage.setScene(scene);//builds the window that is about to be shown
        primaryStage.show();//shows primary stage
    }

    public static void main(String[] args) {//entry point for java fx
        launch(args);
    }
}