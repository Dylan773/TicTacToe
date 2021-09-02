package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.Collection;
import static view.MainMenu.addButton;

/**
 * <h1>TicTacToe Game Board</h1>
 *
 * @author Dylan Brand
 */
public class GameBoard extends BorderPane {

    // Fields
    private Button topLeft, topCentre, topRight, middleLeft,
            middleCentre, middleRight, bottomLeft,
            bottomCentre, bottomRight,
            resetGame, mainMenu;
    private Label gameInfo;
    private ArrayList<Button> gameButtons;


    // Constructor
    /**
     *
     */
    public GameBoard() {
        this.getStyleClass().add("GameBoard");

        // Initialising Game Info Label
        gameInfo = new Label("TicTacToe");
        gameInfo.setFont(new Font("Courier New", 70));

        // Overrides default position of Pos.TOP_LEFT
        BorderPane.setAlignment(gameInfo, Pos.CENTER);

        // Initialising Game Control Buttons
        resetGame = new Button("Reset Game");
        mainMenu = new Button("Main Menu");

        // HBox for Game Control Buttons
        HBox gameControls = new HBox(20, addButton(mainMenu, 100, 30), addButton(resetGame, 100, 30));
        gameControls.setAlignment(Pos.CENTER);

        // Building the Game Screen with a BorderPane
        this.setTop(gameInfo);
        this.setCenter(createGrid());
        this.setBottom(gameControls);
    }

    // Methods
    /**
     * Adds all TicTacToe game buttons to a collection, allows easy iteration of all buttons.
     *
     * @return An ArrayList of all TicTacToe game buttons.
     */
    public Collection<Button> getAllButtons() {
        gameButtons = new ArrayList<>();
        gameButtons.add(topLeft);
        gameButtons.add(topCentre);
        gameButtons.add(topRight);

        gameButtons.add(middleLeft);
        gameButtons.add(middleCentre);
        gameButtons.add(middleRight);

        gameButtons.add(bottomLeft);
        gameButtons.add(bottomCentre);
        gameButtons.add(bottomRight);

        return gameButtons;
    }

    /**
     * Creates a 3x3 grid of buttons for the TicTacToe game board.
     *
     * @return GameBoard GridPane.
     */
    private GridPane createGrid() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Initialising Game Board Buttons
        topLeft = new Button("");
        topCentre = new Button("");
        topRight = new Button("");
        middleLeft = new Button("");
        middleCentre = new Button("");
        middleRight = new Button("");
        bottomLeft = new Button("");
        bottomCentre = new Button("");
        bottomRight = new Button("");

        // Top Row
        gridPane.add(addButton(topLeft, 100, 100), 0, 0);
        gridPane.add(addButton(topCentre, 100, 100), 1, 0);
        gridPane.add(addButton(topRight, 100, 100), 2, 0);

        // Middle Row
        gridPane.add(addButton(middleLeft, 100, 100), 0, 1);
        gridPane.add(addButton(middleCentre, 100, 100), 1, 1);
        gridPane.add(addButton(middleRight, 100, 100), 2, 1);

        // Bottom Row
        gridPane.add(addButton(bottomLeft, 100, 100), 0, 2);
        gridPane.add(addButton(bottomCentre, 100, 100), 1, 2);
        gridPane.add(addButton(bottomRight, 100, 100), 2, 2);

        return gridPane;
    }

    /**
     * Method that updates the Labels text displayed at the top of the game screen BorderPane.
     *
     * @param text The text to be displayed within the label.
     */
    public void setGameInfo(String text) {
        gameInfo.setText(text);
    }

    /* Although this Class's children could inherit the button properties if they were 'protected' not 'private'
     having the children being able to directly modify the buttons properties is not suitable. */
    /**
     * @return The top left button String value.
     */
    public String getTopLeftText() {
        return topLeft.getText();
    }

    /**
     * @return The top centre button String value.
     */
    public String getTopCentreText() {
        return topCentre.getText();
    }

    /**
     * @return The top right button String value.
     */
    public String getTopRightText() {
        return topRight.getText();
    }

    /**
     * @return The middle left button String value.
     */
    public String getMiddleLeftText() {
        return middleLeft.getText();
    }

    /**
     * @return The middle centre button String value.
     */
    public String getMiddleCentreText() {
        return middleCentre.getText();
    }

    /**
     * @return The middle right button String value.
     */
    public String getMiddleRightText() {
        return middleRight.getText();
    }

    /**
     * @return The bottom left button String value.
     */
    public String getBottomLeftText() {
        return bottomLeft.getText();
    }

    /**
     * @return The bottom centre button String value.
     */
    public String getBottomCentreText() {
        return bottomCentre.getText();
    }

    /**
     * @return The bottom right button String value.
     */
    public String getBottomRightText() {
        return bottomRight.getText();
    }


    // Event Handlers - Allows external Event Handlers to be attached to the buttons in this game board.
    public void topLeftHandler(EventHandler<ActionEvent> handler) {
        topLeft.setOnAction(handler);
    }

    public void topCentreHandler(EventHandler<ActionEvent> handler) {
        topCentre.setOnAction(handler);
    }

    public void topRightHandler(EventHandler<ActionEvent> handler) {
        topRight.setOnAction(handler);
    }

    public void middleLeftHandler(EventHandler<ActionEvent> handler) {
        middleLeft.setOnAction(handler);
    }

    public void middleCentreHandler(EventHandler<ActionEvent> handler) {
        middleCentre.setOnAction(handler);
    }

    public void middleRightHandler(EventHandler<ActionEvent> handler) {
        middleRight.setOnAction(handler);
    }

    public void bottomLeftHandler(EventHandler<ActionEvent> handler) {
        bottomLeft.setOnAction(handler);
    }

    public void setBottomCentreHandler(EventHandler<ActionEvent> handler) {
        bottomCentre.setOnAction(handler);
    }

    public void bottomRightHandler(EventHandler<ActionEvent> handler) {
        bottomRight.setOnAction(handler);
    }

    public void resetGameHandler(EventHandler<ActionEvent> handler) {
        resetGame.setOnAction(handler);
    }

    public void addMainMenuHandler(EventHandler<ActionEvent> handler) {
        mainMenu.setOnAction(handler);
    }
}

