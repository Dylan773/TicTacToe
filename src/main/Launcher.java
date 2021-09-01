package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.TwoPlayerGame;
import view.GameBoard;
import view.MainMenu;

/**
 *
 */
public class Launcher extends Application {

    // Fields
    private MainMenu mainMenu = new MainMenu();
    private GameBoard gameBoard = new TwoPlayerGame();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TicTacToe");
        Scene mainMenuScene = new Scene(mainMenu, 600, 550);
        Scene game = new Scene(gameBoard, 600, 550);

        // Event Handler for Game Start
        mainMenu.addPlayGameHandler(e -> {
            primaryStage.setScene(game);
            primaryStage.getScene().getStylesheets().add("Stylesheet.css");
        });

        // Event Handler for Menu Return
        gameBoard.addMainMenuHandler(e -> {
            primaryStage.setScene(mainMenuScene);
        });

        primaryStage.setScene(mainMenuScene); // Default Scene
        primaryStage.getScene().getStylesheets().add("Stylesheet.css");

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

