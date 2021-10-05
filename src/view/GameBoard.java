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
import java.util.HashMap;
import static view.MainMenu.addButton;

/**
 * <h1>TicTacToe Game Board</h1>
 *
 * Creates a Game Screen for this TicTacToe application. The GameBoard consists of 3x3 of JavaFX Buttons that enables
 * the user to interact with and play TicTacToe. Alongside a game info label that prompts the user with game instructions
 * and two further buttons that can be enabled to reset the TicTacToe grid or return to the Main Menu. <p></p>
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
    private HashMap<String, Button> button;



    // Constructor
    /**
     * <h2>This class' constructor</h2>
     *
     * Creates the layout for this GameBoard screen by assigning different nodes to locations in a BorderPane.
     * <p>
     *
     * Initialises the game info Label that prompts the user with game instructions to the top of the BorderPane. <br>
     * Calls the createGrid method to the centre of the BorderPane: @see {@link #createGrid()}. <br>
     * Assigning a game controls HBox to the bottom of the BorderPane.
     */
    public GameBoard() {
        // External CSS Styling
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
     * Creates a 3x3 grid of buttons for the TicTacToe game board.<P></P>
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
     * Disables all Tic Tac Toe game buttons on the GameBoard. <p></p>
     *
     * Calls getAllButtons method from this class to iterate through all TicTacToe game buttons. @see {@link #getAllButtons()}
     */
    public void disableButtons() {
        for (Button button : getAllButtons())
            button.setDisable(true);
    }

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

    public void defaultButtons() {
        for (Button button : getAllButtons()) {
            button.setDisable(false);
            button.setText("");

            // Reset the button's CSS styling to their original state
            button.getStyleClass().clear();
            button.getStyleClass().add("button");
        }
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
     * Allows the top left TicTacToe button text value to be obtained and compared for equality.
     * @return The top left button String value.
     */
    public String getTopLeftText() {
        return topLeft.getText();
    }

    /**
     * Allows the top centre TicTacToe button text value to be obtained and compared for equality.
     * @return The top centre button String value.
     */
    public String getTopCentreText() {
        return topCentre.getText();
    }

    /**
     * Allows the top right TicTacToe button text value to be obtained and compared for equality.
     * @return The top right button String value.
     */
    public String getTopRightText() {
        return topRight.getText();
    }

    /**
     * Allows the middle left TicTacToe button text value to be obtained and compared for equality.
     * @return The middle left button String value.
     */
    public String getMiddleLeftText() {
        return middleLeft.getText();
    }

    /**
     * Allows the middle centre TicTacToe button text value to be obtained and compared for equality.
     * @return The middle centre button String value.
     */
    public String getMiddleCentreText() {
        return middleCentre.getText();
    }

    /**
     * Allows the middle right TicTacToe button text value to be obtained and compared for equality.
     * @return The middle right button String value.
     */
    public String getMiddleRightText() {
        return middleRight.getText();
    }

    /**
     * Allows the bottom left TicTacToe button text value to be obtained and compared for equality.
     * @return The bottom left button String value.
     */
    public String getBottomLeftText() {
        return bottomLeft.getText();
    }

    /**
     * Allows the bottom centre TicTacToe button text value to be obtained and compared for equality.
     * @return The bottom centre button String value.
     */
    public String getBottomCentreText() {
        return bottomCentre.getText();
    }

    /**
     * Allows the bottom right TicTacToe button text value to be obtained and compared for equality.
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