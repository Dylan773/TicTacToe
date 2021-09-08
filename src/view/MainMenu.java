package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

/**
 * <h1>Main Menu screen for this application</h1>
 *
 * @author Dylan Brand.
 */
public class MainMenu extends BorderPane {

    // Fields
    private Label title, credits;
    private Button playGame, gameInfo, exitGame;

    // Constructor
    /**
     * <h2>This class' constructor</h2>
     *
     * Creates the layout for this Main Menu screen by assigning different nodes to locations in a BorderPane.
     * <p></p>
     *
     * Calls the createMenuScreen method to the centre of the BorderPane: @see {@link #createMenuScreen()}
     * Assigning a credits HBox to the bottom of the BorderPane.
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
     * Creates a GridPane consisting of buttons and a Label within a specific order
     * to display on the Main Menu screen.
     *
     * @return Main Menu GridPane.
     */
    public GridPane createMenuScreen() {

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(10);

        // Game Title
        title = new Label("TicTacToe");
        title.setFont(new Font("Courier New", 70));

        // Play Game Button - Has an external event handler
        playGame = new Button("Play Game");

        // Game Info Button
        gameInfo = new Button("Info");
        gameInfo.setOnAction(e -> alertDialogBuilder(Alert.AlertType.INFORMATION, "Information", null,
                "TicTacToe game designed and created using JavaFX, without the use of any Java frameworks or GUI builders.\n\n" +
                        "I am a student, and still learning so it may not be perfect. If any bugs, errors or " +
                        "bad practices are present, please let me know. Feedback is appreciated."));

        // Exit Game Button
        exitGame = new Button("Exit Game");
        exitGame.setOnAction(e -> System.exit(0));

        // HBox controls for Game Info and Exit
        HBox appControls = new HBox(20, addButton(gameInfo, 140, 30), addButton(exitGame, 140, 30));
        appControls.setAlignment(Pos.CENTER);

        // Adding controls to the container
        gridPane.add(title, 0, 0);
        gridPane.add(addButton(playGame, 300, 30), 0, 1, 2, 1);
        gridPane.add(appControls, 0, 2);

        return gridPane;
    }

    /**
     * Add button method that reduces repetition and volume of code.
     * <p></p>
     *
     * Accepts a JavaFX Button and two double argument's, setting the default position of the button to the centre and
     * width and height of the button to the two double values provided.
     * <p></p>
     *
     * @param button The JavaFX button to be instantiated.
     * @param width  The width (length) of the button.
     * @param height The height of the button.
     *
     * @return The button to be created.
     */
    public static Button addButton(Button button, double width, double height) {
        button.setMinSize(width, height);
        GridPane.setHalignment(button, HPos.CENTER);

        return button;
    }

    /**
     * Alert Dialog Builder method that can be instantiated to display a variety of
     * different messages to the user based on their actions.
     * <p></p>
     *
     * E.g. If an error in the application occurs, an error dialog box can be
     * displayed alerting the user.
     *
     * @param type    The type of the alert.
     * @param title   The title of the dialog box.
     * @param header  The content for the header of the dialog box.
     * @param content The message to be displayed to the user in the content area.
     */
    private void alertDialogBuilder(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Event Handlers
    /**
     * Allows an EventHandler to be externally attached to the play game button on this Menu screen.
     *
     * @param handler The EventHandler to be attached to this button.
     */
    public void addPlayGameHandler(EventHandler<ActionEvent> handler) {
        playGame.setOnAction(handler);
    }
}
