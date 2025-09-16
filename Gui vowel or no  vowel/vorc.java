package com.example.demo1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class vorc extends Application {

    private Label result;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Your Name");

        GridPane g = new GridPane();//create new grid pane
        g.setPadding(new Insets(10, 10, 10, 10));//positioning
        g.setHgap(5);//spaces between entries
        g.setVgap(5);//spaces between entries

        result = new Label("Press a Letter");//placed at the bottom

        String[] lettersArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");//constants and splitting it into an array of strings of letters
        String[] vowelsArray = "AEIOU".split("");//same concept for vowels

        for (int i = 0; i < lettersArray.length; i++) {
            Button button = new Button(lettersArray[i]);//create a button of letter type, this is the text on the button
            button.setOnAction(e -> handleButtonClick(button.getText(), vowelsArray));//send to handlers when dealing with vowels
            g.add(button, i % 10, i / 10);//add the positions of letters
        }

        g.add(result, 0, 3, 10, 1);//adding the result onto grid pane

        Scene scene = new Scene(g, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonClick(String letter, String[] vowelsArray) {
        boolean isVowel = false;
        for (String vowel : vowelsArray) {//increment through the vowel arrays
            if (vowel.equals(letter)) {//if the seleced letter is equal to a vowel
                isVowel = true;//set to true
                break;
            }
        }
        if (isVowel) {
            result.setText(letter + " is a vowel.");
        } else {
            result.setText(letter + " is a consonant.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
