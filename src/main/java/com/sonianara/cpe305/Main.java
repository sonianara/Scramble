package com.sonianara.cpe305;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class Main extends Application {

  Player p1 = new Player();
  Player p2 = new Player();
  Player p3 = new Player();
  Player p4 = new Player();
  Label[] scoreLabels = new Label[5];
  Button[] buttonRack = new Button[7];
  ArrayList<Player> playerArray = new ArrayList<Player>();
  TextField[][] squares = new TextField[15][15];

  Game game;
  private boolean p3Flag = false;
  private boolean p4Flag = false;
  int numTurns = 0;
  int roundNumber;
  int i = 0;

  /* The "WELCOME TO SCRAMBLE" Screen */

  public void start(final Stage primaryStage) {


    primaryStage.setTitle("Scramble");
    Button beginButton = new Button();
    beginButton.setText("Begin");
    changeTexts(beginButton);
    Label welcomeLabel = new Label("Welcome to Scramble");
    welcomeLabel.setFont(new Font("Cambria", 75));
    beginButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        beginButtonClicked(primaryStage);
      }
    });

    StackPane root = new StackPane();
    root.setStyle("-fx-background-color: transparent;");
    root.getChildren().addAll(beginButton, welcomeLabel);
    root.setPadding(new Insets(100, 0, 0, 0));
    StackPane.setAlignment(beginButton, Pos.CENTER);
    StackPane.setAlignment(welcomeLabel, Pos.TOP_CENTER);
    primaryStage.setScene(new Scene(root, 800, 800, Color.LIGHTSKYBLUE));
    primaryStage.show();
  }

  /*
   * The screen to allow players to type their names
   */

  public void beginButtonClicked(final Stage primaryStage) {
    StackPane sp = new StackPane();
    sp.setStyle("-fx-background-color: transparent;");
    GridPane grid = new GridPane();
    grid.setStyle("-fx-background-color: transparent;");
    Button letsPlayBtn = new Button("Let's Play !");

    Label firstPlayerLabel = new Label("Player 1");
    final TextField firstPlayerTxt = new TextField();
    Label secondPlayerLabel = new Label("Player 2");
    final TextField secondPlayerTxt = new TextField();
    Label thirdPlayerLabel = new Label("Player 3");
    final TextField thirdPlayerTxt = new TextField();
    Label fourthPlayerLabel = new Label("Player 4");
    final TextField fourthPlayerTxt = new TextField();
    Label errorLabel = new Label("");
    Label l = new Label("Please enter player names:");

    changeTexts(firstPlayerLabel);
    changeTexts(firstPlayerTxt);
    changeTexts(secondPlayerLabel);
    changeTexts(secondPlayerTxt);
    changeTexts(thirdPlayerLabel);
    changeTexts(thirdPlayerTxt);
    changeTexts(fourthPlayerLabel);
    changeTexts(fourthPlayerTxt);
    changeTexts(l);
    changeTexts(letsPlayBtn);

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

    grid.add(l, 3, 0);
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

    BooleanBinding bb = new BooleanBinding() {
      {
        super.bind(firstPlayerTxt.textProperty(), secondPlayerTxt.textProperty(),
            thirdPlayerTxt.textProperty(), fourthPlayerTxt.textProperty());
      }

      @Override
      protected boolean computeValue() {
        return (firstPlayerTxt.getText().isEmpty() || secondPlayerTxt.getText().isEmpty());
      }
    };

    letsPlayBtn.disableProperty().bind(bb);

    letsPlayBtn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {

        game = new Game();

        int numPlayers = getNumPlayers(firstPlayerTxt, secondPlayerTxt, thirdPlayerTxt,
            fourthPlayerTxt);

        if (numPlayers == 3) {
          p3Flag = true;
        }
        if (numPlayers == 4) {
          p4Flag = true;
        }

        for (int i = 0; i < numPlayers; i++) {
          playerArray.add(new Player());
        }

        playerArray.get(0).setName(firstPlayerTxt.getText());
        playerArray.get(1).setName(secondPlayerTxt.getText());
        playerArray.get(0).setPlayerSet(game.getTileSet().getFullSet());
        playerArray.get(1).setPlayerSet(game.getTileSet().getFullSet());

        if (p3Flag) {
          playerArray.get(2).setName(thirdPlayerTxt.getText());
          playerArray.get(2).setPlayerSet(game.getTileSet().getFullSet());
        }
        if (p4Flag) {
          playerArray.get(2).setName(thirdPlayerTxt.getText());
          playerArray.get(3).setName(fourthPlayerTxt.getText());
          playerArray.get(2).setPlayerSet(game.getTileSet().getFullSet());
          playerArray.get(3).setPlayerSet(game.getTileSet().getFullSet());
        }

        playTurn(primaryStage, playerArray.get(0));
      }
    });

    grid.setAlignment(Pos.CENTER);
    sp.getChildren().add(grid);
    StackPane.setAlignment(grid, Pos.BOTTOM_RIGHT);
    primaryStage.setScene(new Scene(sp, 800, 800, Color.LIGHTSKYBLUE));
    primaryStage.show();
  }  
  
  public char[][] saveNewBoard() {
    char[][] newBoard = new char[15][15];
    
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 15; j++) {
        if (!squares[i][j].getText().isEmpty()) {
          char temp = squares[i][j].getText().charAt(0);
          newBoard[i][j] = temp;
        } 
        else {
          newBoard[i][j] = ' ';
        }
      }
    }
    return newBoard;
  }

  public void createJavaFXBoard(GridPane gp) {
    System.setProperty("prism.text", "t2k");
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 15; j++) {
        final int finalI = i;
        final int finalJ = j;
        squares[i][j] = new TextField("");
        squares[i][j].setPrefSize(30, 30);
        squares[i][j].textProperty().addListener((ov, oldValue, newValue) -> {
          squares[finalI][finalJ].setText(newValue.toUpperCase());
        });
        gp.add(squares[i][j], i, j);
      }
    }
  }

  public void createButtons(Player p, HBox bottomRack, int numTurns) {
    ArrayList<LetterTile> playerArr = p.getPlayerSet();
    for (int i = 0; i < 7; i++) {
      if (numTurns == 1) {
        buttonRack[i] = new Button();
      }
     
      buttonRack[i].wrapTextProperty().setValue(true);
      if (playerArr.get(i).getLetter() != ' ') {
        buttonRack[i].setText(Character.toString(playerArr.get(i).getLetter()).toUpperCase() + " (" + (game.getTileSet().getLetterValue(playerArr.get(i).getLetter())) + ")");
        buttonRack[i].setMinWidth(50);
        buttonRack[i].setMinHeight(50);
      }
      else {
        buttonRack[i].setText(Character.toString(playerArr.get(i).getLetter()).toUpperCase());
        buttonRack[i].setMinWidth(50);
        buttonRack[i].setMinHeight(50);
      }
      if (numTurns == 1) {
        bottomRack.getChildren().add(buttonRack[i]);
      }
    }
  }
  
  public void createHistoryOfWords(VBox wordHistory, ArrayList<String> words) {
    for (String word: words) {
      Label l = new Label(word);
      l.setAlignment(Pos.CENTER);
      wordHistory.getChildren().add(l);
    }
  }

  public void playTurn(Stage primaryStage, Player p) {
    numTurns++;
    roundNumber = 1;
    
    VBox wordHistory = new VBox();
    Label history = new Label("Word History");
    history.setStyle("" + "-fx-font-size: 20px;" + "-fx-font-family: Cambria;");
    history.setAlignment(Pos.CENTER);
    wordHistory.getChildren().add(history);
    
    
    
    HBox bottomRack = new HBox();
    bottomRack.setAlignment(Pos.CENTER);
    bottomRack.setPadding(new Insets(5, 20, 5, 20));
    Button makeMoveButton = new Button("Make Move");
    makeMoveButton.setAlignment(Pos.CENTER_RIGHT);

    Label errors = new Label();
    GridPane gp = new GridPane();

    VBox scoreBox = createScoreBoard();
    Label topHeading = new Label("It's " + p.getName() + "'s Turn!");
    Label roundNumberLabel = new Label("Round: " + String.valueOf(roundNumber));
    roundNumberLabel.setAlignment(Pos.CENTER_RIGHT);
    changeTexts(topHeading);
    gp.setPadding(new Insets(50, 50, 25, 50));

    createJavaFXBoard(gp);

    gp.setAlignment(Pos.CENTER);

    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 15; j++) {
        squares[i][j].setTextFormatter(new TextFormatter<String>((TextFormatter.Change change) -> {
          String newText = change.getControlNewText();
          if (newText.length() > 1) {
            return null;
          } else {
            return change;
          }
        }));
      }
    }

    createButtons(p, bottomRack, numTurns);

    makeMoveButton.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        
        char[][] newBoard = saveNewBoard();
        
        ArrayList<String> words = game.getWordsString(newBoard);
        boolean valid = game.makeFinalMove(newBoard, playerArray.get(i));       
           
        if (valid == true) {
          createHistoryOfWords(wordHistory, words);
          disableGridSquares();
          roundNumber++;
          numTurns++;
          scoreLabels[i].
          setText(playerArray.get(i).getName() + ": " + playerArray.get(i).getPoints());
        
          if (i + 1 == playerArray.size()) {
            i = 0;
          }
          else {
            i++;
          }
          topHeading.setText("It's " + playerArray.get(i).getName() + "'s Turn!");
          roundNumberLabel.setText("Round: " + String.valueOf(roundNumber));
          createButtons(playerArray.get(i), bottomRack, numTurns);
          errors.setText("");
        }
        else {
          errors.setText("Wrong play");
        }
      }
    });

    HBox biggerLayout = new HBox();
    HBox bigLayout = new HBox();
    VBox layout = new VBox();
    scoreBox.setStyle("-fx-background-color: transparent;");
    scoreBox.setAlignment(Pos.CENTER_LEFT);
    scoreBox.setPadding(new Insets(0, 0, 0, 10));
    bottomRack.setPadding(new Insets(0, 0, 10, 0));
    layout.getChildren().addAll(topHeading, roundNumberLabel, errors, scoreBox, gp, bottomRack,
        makeMoveButton);
    layout.setStyle("-fx-background-color: transparent;");
    layout.setAlignment(Pos.CENTER);
    bigLayout.getChildren().addAll(scoreBox, layout);
    bigLayout.setStyle("-fx-background-color: transparent;");
    wordHistory.setPadding(new Insets(150, 0, 0, 20));
    biggerLayout.getChildren().addAll(bigLayout, wordHistory);
    biggerLayout.setStyle("-fx-background-color: transparent;");
    primaryStage.setScene(new Scene(biggerLayout, 800, 800, Color.LIGHTSKYBLUE));
    primaryStage.show();
  }

  public void disableGridSquares() {
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 15; j++) {
        if (!squares[i][j].getText().isEmpty()) {
          squares[i][j].setDisable(true);
        }
      }
    }
  }


  public VBox createScoreBoard() {
    VBox scoreBox = new VBox();
    scoreLabels[0] = new Label("Scores");
    scoreLabels[0].setStyle("-fx-underline: true;");
    changeTexts(scoreLabels[0]);
    scoreLabels[0].setAlignment(Pos.CENTER);
    // scoreBox.getChildren().addAll(scoreLabels[0]);
    for (int i = 0; i < playerArray.size(); i++) {
      scoreLabels[i] = new Label(
          playerArray.get(i).getName() + ": " + playerArray.get(i).getPoints());
      changeTexts(scoreLabels[i]);
      scoreBox.getChildren().addAll(scoreLabels[i]);
    }
    return scoreBox;
  }

  public void printNewBoard(char[][] newBoard) {
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 15; j++) {
        if (newBoard[i][j] != ' ') {
          char c = newBoard[i][j];
          System.out.println("New" + c);
        }
      }
    }
  }

  // Change the font and font size of any node
  public void changeTexts(Node n) {
    n.setStyle("" + "-fx-font-size: 30px;" + "-fx-font-family: Cambria;");
  }

  // Get the number of players in the game
  public int getNumPlayers(TextField p1, TextField p2, TextField p3, TextField p4) {
    int numPlayers = 0;
    if (!p1.getText().isEmpty()) {
      numPlayers++;
    }
    if (!p2.getText().isEmpty()) {
      numPlayers++;
    }
    if (!p3.getText().isEmpty()) {
      numPlayers++;
    }
    if (!p4.getText().isEmpty()) {
      numPlayers++;
    }
    return numPlayers;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
