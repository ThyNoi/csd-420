/*
    Eric Sengvanhpheng
    CSD420 Advanced Java Module 1.3
    October 2026

    JavaFX program that displays four images randomly selected from a deck of 52 cards.
    With refresh button to display new random cards and lambda expression for mouse click.
 */

package com.example.javafxtester;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class CardDisplay extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Random Four Card Display");

        // Preload all 52 images into an array at startup. Keeps Java from
        // reaching into hard drive and getting cards.
        Image[] cardImages = new Image[52];
        for (int i = 0; i < 52; i++) {
            // Looks in the cards subdirectory for files named "(1).png" -> 52
            cardImages[i] = new Image("file:cards/card (" + (i + 1) + ").png");
        }

        // Appends number 'i' to the list all the way to 52. Index starts at 0.
        ArrayList<Integer> deck = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            deck.add(i);
        }

        // Collections used to mix up all the numbers in list randomly.
        Collections.shuffle(deck);

        // Loading the 4 card images from the preloaded array.
        ImageView card1 = new ImageView(cardImages[deck.get(0)]);
        ImageView card2 = new ImageView(cardImages[deck.get(1)]);
        ImageView card3 = new ImageView(cardImages[deck.get(2)]);
        ImageView card4 = new ImageView(cardImages[deck.get(3)]);

        // Resizes the image container, setPreserveRation will automatically
        // calculate height with the width given.
        ImageView[] viewArray = {card1, card2, card3, card4};
        for (ImageView view : viewArray) {
            view.setFitWidth(200);
            view.setPreserveRatio(true);
        }

        // Place cards side by side in HBox.
        HBox cardsBox = new HBox(10);
        cardsBox.getChildren().addAll(card1, card2, card3, card4);
        cardsBox.setAlignment(Pos.CENTER);

        // Create a refresh button
        Button refreshBtn = new Button("Refresh");

        // Lambda event handler. Reshuffles the deck and updates from RAM.
        // the 4 card images when clicking the Refresh button.
        refreshBtn.setOnAction(e -> {
            Collections.shuffle(deck);
            card1.setImage(cardImages[deck.get(0)]);
            card2.setImage(cardImages[deck.get(1)]);
            card3.setImage(cardImages[deck.get(2)]);
            card4.setImage(cardImages[deck.get(3)]);
        });

        // Stack the HBox and Button vertically in a VBox.
        VBox mainLayout = new VBox(15, cardsBox, refreshBtn);
        mainLayout.setAlignment(Pos.CENTER);

        // Attach to scene and display on stage.
        Scene scene = new Scene(mainLayout, 900, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}