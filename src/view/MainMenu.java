package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

/**
 *
 */
public class MainMenu extends BorderPane {

    // Fields
    private Label title, credits;
    private Button playGame, gameInfo, exitGame;

    // Constructor
    /**
     *
     */
    public MainMenu() {
        // External Style Sheet
        this.getStyleClass().add("MainMenu");

        // Credit Label
        credits = new Label("Created by Dylan Brand, Student at De Montfort University.");

        // Centralised HBox for credits
        HBox creditHBox = new HBox(credits);
        creditHBox.setAlignment(Pos.CENTER);

        // Adding controls to the container
        this.setCenter(createMenuScreen());
        this.setBottom(creditHBox);
    }

    // Methods
    /**
     *
     * @return
     */
    public GridPane createMenuScreen() {

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(10);

        // Game Title
        title = new Label("TicTacToe");
        title.setFont(new Font("Courier New", 70));

        // Initialising the Main Menu Buttons
        playGame = new Button("Play Game");

        //twoPlayer = new Button("Two Player");
        gameInfo = new Button("Info");

        exitGame = new Button("Exit Game");
        exitGame.setOnAction(e -> System.exit(0));

        // HBox controls for Game Info and Exit
        HBox appControls = new HBox(20, addButton(gameInfo, 140, 30), addButton(exitGame, 140, 30));
        appControls.setAlignment(Pos.CENTER);

        // Adding controls to the container
        gridPane.add(title, 0, 0);
        gridPane.add(addButton(playGame, 300, 30), 0, 1, 2, 1);
        //gridPane.add(addButton(twoPlayer, 300, 30), 0, 2, 2, 1);
        gridPane.add(appControls, 0, 2);

        return gridPane;
    }

    /**
     * Add button method that reduces repetition and volume of code.
     *
     * Accepts a JavaFX Button and a double argument, setting the default position of the button to the centre and
     * width and height of the button to the values provided.
     *
     * @param button The JavaFX button to be instantiated.
     * @param width The width (length) of the button.
     * @param height The height of the button.
     * @return The button.
     */
    public static Button addButton(Button button, double width, double height) {
        button.setMinSize(width, height);
        GridPane.setHalignment(button, HPos.CENTER);

        return button;
    }

    /**
     *
     * @param handler
     */
    public void addPlayGameHandler(EventHandler<ActionEvent> handler) {
        playGame.setOnAction(handler);
    }

    /**
     *
     * @param handler
     */
    public void addGameInfoHandler(EventHandler<ActionEvent> handler) {
        gameInfo.setOnAction(handler);
    }

    /**
     *
     * @param handler
     */
    public void addGameExitHandler(EventHandler<ActionEvent> handler) {
        exitGame.setOnAction(handler);
    }
}
