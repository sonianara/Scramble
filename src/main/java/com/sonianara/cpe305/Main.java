package com.sonianara.cpe305;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		 GridPane grid = new GridPane();
     grid.setPadding(new Insets(20));

     Label scrambleLabel = new Label("Welcome to Scramble");
     Label firstPlayerLabel = new Label("Player 1");
     TextField firstPlayerTxt = new TextField();
     Label secondPlayerLabel = new Label("Player 2");
     TextField secondPlayerTxt = new TextField();
     Label thirdPlayerLabel = new Label("Player 3");
     TextField thirdPlayerTxt = new TextField();
     Label fourthPlayerLabel = new Label("Player 4");
     TextField fourthPlayerTxt = new TextField();
     Label errorLabel = new Label("");
     
     Button letsPlayBtn = new Button("Let's Play !");

     GridPane.setMargin(scrambleLabel, new Insets(10));
     GridPane.setMargin(firstPlayerLabel, new Insets(10));
     GridPane.setMargin(firstPlayerTxt, new Insets(10));
     GridPane.setMargin(secondPlayerLabel, new Insets(10));
     GridPane.setMargin(secondPlayerTxt, new Insets(10));
     GridPane.setMargin(thirdPlayerLabel, new Insets(10));
     GridPane.setMargin(thirdPlayerTxt, new Insets(10));
     GridPane.setMargin(fourthPlayerLabel, new Insets(10));
     GridPane.setMargin(fourthPlayerTxt, new Insets(10));
     GridPane.setMargin(letsPlayBtn, new Insets(10));
     GridPane.setMargin(errorLabel, new Insets(10));

     grid.add(scrambleLabel, 3, 0);
     grid.add(firstPlayerLabel, 2, 1);
     grid.add(firstPlayerTxt, 3, 1);
     grid.add(secondPlayerLabel, 2, 2);
     grid.add(secondPlayerTxt, 3, 2);
     grid.add(thirdPlayerLabel, 2, 3);
     grid.add(thirdPlayerTxt, 3, 3);
     grid.add(fourthPlayerLabel, 2, 4);
     grid.add(fourthPlayerTxt, 3, 4);
     grid.add(errorLabel, 3, 3);
     grid.add(letsPlayBtn, 3, 5);
     GridPane.setColumnSpan(errorLabel, 2);
     GridPane.setColumnSpan(letsPlayBtn, 2);
     
     Scene firstScene = new Scene(grid);
     primaryStage.setScene(firstScene);
     primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
