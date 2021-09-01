package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import view.GameBoard;

public class TwoPlayerGame extends GameBoard {

    // Fields
    private boolean xTurn;

    // Constructors
    /**
     * Sets x's Turn to true, assinging the first move to player X.
     * Attaches all button handlers to this class.
     */
    public TwoPlayerGame() {
        xTurn = true;
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
        resetGameHandler(resetGrid());
    }

    /**
     * Disables all Tic Tac Toe game buttons on the GameBoard.
     */
    public void disableButtons() {
        for (Button button : getAllButtons())
            button.setDisable(true);
    }

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
            }
            checkWinner(); // Check for winner at the end of turn.
        };
    }

    /**
     * <h1>A VERY LONG AND BORING METHOD</h1>
     */
    public void checkWinner() { //TODO - ADD DRAW OUTCOME
        // TOP ROW
        if (!getTopLeftText().equals("") && !getTopCentreText().equals("") && !getTopRightText().equals("")) {
            if (getTopLeftText().equals(getTopCentreText()) && getTopRightText().equals(getTopCentreText())) {
                setGameInfo(getTopLeftText() + " WINS");
                disableButtons();
            }
        }

        // MIDDLE ROW
        if (!getMiddleLeftText().equals("") && !getMiddleCentreText().equals("") && !getMiddleRightText().equals("")) {
            if (getMiddleLeftText().equals(getMiddleCentreText()) && getMiddleRightText().equals(getMiddleCentreText())) {
                setGameInfo(getMiddleLeftText() + " WINS");
                disableButtons();
            }
        }

        // BOTTOM ROW
        if (!getBottomLeftText().equals("") && !getBottomCentreText().equals("") && !getBottomRightText().equals("")) {
            if (getBottomLeftText().equals(getBottomCentreText()) && getBottomRightText().equals(getBottomCentreText())) {
                setGameInfo(getBottomLeftText() + " WINS");
                disableButtons();
            }
        }

        // LEFT COLUMN
        if (!getTopLeftText().equals("") && !getMiddleLeftText().equals("") && !getBottomLeftText().equals("")) {
            if (getTopLeftText().equals(getMiddleLeftText()) && getBottomLeftText().equals(getMiddleLeftText())) {
                setGameInfo(getTopLeftText() + " WINS");
                disableButtons();
            }
        }

        // MIDDLE COLUMN
        if (!getTopCentreText().equals("") && !getMiddleCentreText().equals("") && !getBottomCentreText().equals("")) {
            if (getTopCentreText().equals(getMiddleCentreText()) && getBottomCentreText().equals(getMiddleCentreText())) {
                setGameInfo(getTopCentreText() + " WINS");
                disableButtons();
            }
        }

        // RIGHT COLUMN
        if (!getTopRightText().equals("") && !getMiddleRightText().equals("") && !getBottomRightText().equals("")) {
            if (getTopRightText().equals(getMiddleRightText()) && getBottomRightText().equals(getMiddleRightText())) {
                setGameInfo(getTopRightText() + " WINS");
                disableButtons();
            }
        }

        // LEFT DIAGONAL
        if (!getTopLeftText().equals("") && !getMiddleCentreText().equals("") && !getBottomRightText().equals("")) {
            if (getTopLeftText().equals(getMiddleCentreText()) && getBottomRightText().equals(getMiddleCentreText())) {
                setGameInfo(getTopLeftText() + " WINS");
                disableButtons();
            }
        }

        // RIGHT DIAGONAL
        if (!getTopRightText().equals("") && !getMiddleCentreText().equals("") && !getBottomLeftText().equals("")) {
            if (getTopRightText().equals(getMiddleCentreText()) && getBottomLeftText().equals(getMiddleCentreText())) {
                setGameInfo(getTopRightText() + " WINS");
                disableButtons();
            }
        }

    }

    /**
     * @param one
     * @param two
     * @param three
     */
    public void highlightGameWinner(Button one, Button two, Button three) {
        one.getStyleClass().add("GameWinner");
        two.getStyleClass().add("GameWinner");
        three.getStyleClass().add("GameWinner");
    }


    // Event Handlers
    /**
     * Iterates through all Tic Tac Toe game buttons and resets them to their 'default state'.
     * Enables all buttons for play and deletes their text value (empty string).
     *
     * @return Reset Grid Action Event.
     */
    EventHandler<ActionEvent> resetGrid() {
        return event -> {
            for (Button button : getAllButtons()) {
                button.setDisable(false);
                button.setText("");

                xTurn = true;
                setGameInfo("X's Turn");
            }
        };
    }
}