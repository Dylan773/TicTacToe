package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.TwoPlayerGame;
import view.MainMenu;

/**
 * Launcher for this TicTacToe application.
 *
 * @author Dylan Brand.
 */
public class Launcher extends Application {

    // Fields
    private MainMenu mainMenu = new MainMenu();
    private TwoPlayerGame twoPlayerGame = new TwoPlayerGame();

    @Override
    public void start(Stage primaryStage) {

        // Creates the necessary scenes
        Scene mainMenuScene = new Scene(mainMenu, 600, 550);
        Scene gameScene = new Scene(twoPlayerGame, 600, 550);

        // Event Handler for Game Start
        mainMenu.addPlayGameHandler(e -> {
            twoPlayerGame.resetButtons();

            primaryStage.setScene(gameScene);
            primaryStage.getScene().getStylesheets().add("Stylesheet.css");
        });

        // Event Handler for Menu Return
        twoPlayerGame.addMainMenuHandler(e -> {
            primaryStage.setScene(mainMenuScene);
        });

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(mainMenuScene); // Default Scene
        primaryStage.getScene().getStylesheets().add("Stylesheet.css");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}