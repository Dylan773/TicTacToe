package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import view.GameBoard;

public class TwoPlayerGame extends GameBoard {

    // Fields
    private boolean xTurn;
    int turnsPlayed;


    // Constructor
    /**
     * Sets x's Turn to true, assigning the first move to player X.
     * Attaches all button handlers to this class.
     */
    public TwoPlayerGame() {
        xTurn = true;
        turnsPlayed = 0;

        setGameInfo("X's Turn");
        attachButtonEvents();
    }


    // Methods
    /**
     * Attaches all GameBoard's external button handlers to this class' button ActionEvent.
     */
    public void attachButtonEvents() {
        // TOP ROW
        topLeftHandler(buttonEvent());
        topCentreHandler(buttonEvent());
        topRightHandler(buttonEvent());

        // MIDDLE ROW
        middleLeftHandler(buttonEvent());
        middleCentreHandler(buttonEvent());
        middleRightHandler(buttonEvent());

        // BOTTOM ROW
        bottomLeftHandler(buttonEvent());
        setBottomCentreHandler(buttonEvent());
        bottomRightHandler(buttonEvent());

        // RESET GAME
        resetGameHandler(e -> resetButtons());
    }

    /**
     * Disables all Tic Tac Toe game buttons on the GameBoard.
     */
    public void disableButtons() {
        for (Button button : getAllButtons())
            button.setDisable(true);
    }

    /**
     * Iterates through all Tic Tac Toe game buttons and resets them to their original state (empty string).
     * Enables all buttons for play, setting the first turn to player X.
     */
    public void resetButtons() {
        for (Button button : getAllButtons()) {
            button.setDisable(false);
            button.setText("");
        }
        xTurn = true;
        turnsPlayed = 0;
        setGameInfo("X's Turn");
    }

    /**
     * Accepts three String arguments and checks those values are not null. If and only if
     * all String values are not empty, then each value will be compared for equality.
     *
     * If all three buttons have the same String value, a winner can be determined. Subsequently, alerting the users
     * of the winner and disabling all TicTacToe game buttons.
     *
     * @param btnOne The String value of the first button.
     * @param btnTwo The String value of the second button.
     * @param btnThree The String value of the third button.
     */
    public void checkScore(String btnOne, String btnTwo, String btnThree) {
        if (!btnOne.equals("") && !btnTwo.equals("") && !btnThree.equals("")) {
            if (btnOne.equals(btnTwo) && btnThree.equals(btnTwo)) {
                setGameInfo(btnOne + " WINS");
                disableButtons();
            }
        }
    }

    /**
     * Provides the checkScore method with the String values of three buttons, checking for equality.
     * If all three buttons are not null and have the same String value, in a winning TicTacToe pattern, a winner can be
     * established.
     * <p></p>
     *
     * If all buttons have been played, and a winning pattern has not been found. A draw cam be established.
     * <p></p>
     * 
     * Uses the checkScore method, significantly reducing repetition: @see {@link #checkScore(String, String, String)}
     */
    public void checkForWin() {
        // Horizontal Rows
        checkScore(getTopLeftText(), getTopCentreText(), getTopRightText()); //Top
        checkScore(getMiddleLeftText(), getMiddleCentreText(), getMiddleRightText()); //Middle
        checkScore(getBottomLeftText(), getBottomCentreText(), getBottomRightText()); //Bottom

        // Vertical Rows
        checkScore(getTopLeftText(), getMiddleLeftText(), getBottomLeftText()); //Left
        checkScore(getTopCentreText(), getMiddleCentreText(), getBottomCentreText()); //Middle
        checkScore(getTopRightText(), getMiddleRightText(), getBottomRightText()); //Right

        // Diagonal Rows
        checkScore(getTopLeftText(), getMiddleCentreText(), getBottomRightText()); //Left
        checkScore(getTopRightText(), getMiddleCentreText(), getBottomLeftText()); //Right

        // Draw
        if (turnsPlayed == 9) {
            setGameInfo("DRAW");
            disableButtons();
        }
    }

//    /**
//     * @param one
//     * @param two
//     * @param three
//     */
//    public void highlightGameWinner(Button one, Button two, Button three) {
//        one.getStyleClass().add("GameWinner");
//        two.getStyleClass().add("GameWinner");
//        three.getStyleClass().add("GameWinner");
//    }


    // Event Handlers
    /**
     * ActionEvent for determining the correct Tic Tac Toe button placement.
     *
     * @return This button event for the Tic Tac Toe game buttons.
     */
    EventHandler<ActionEvent> buttonEvent() {
        return event -> {
            Button buttonClicked = (Button) event.getTarget();

            if (buttonClicked.getText().equals("")) {
                if (xTurn) {
                    setGameInfo("O's Turn");
                    buttonClicked.setText("X");
                    buttonClicked.setFont(new Font("Courier New", 50));
                    xTurn = false;
                } else {
                    setGameInfo("X's Turn");
                    buttonClicked.setText("O");
                    buttonClicked.setFont(new Font("Courier New", 50));
                    xTurn = true;
                }
                turnsPlayed++; // Increment the number of turns by + 1 after each turn.
            }
            checkForWin(); // Check for winner at the end of each turn.
        };
    }
}