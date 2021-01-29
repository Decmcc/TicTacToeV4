package tictactoev4;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static tictactoev4.PlayDrawAnimation.playDrawAnimation;
import static tictactoev4.TicTacToev4.*;

public class Tile extends StackPane {

    public Text text = new Text();

    public Tile() {
        Rectangle border = new Rectangle(200,200);
        border.setFill(Color.LIGHTGREEN);
        border.setStroke(Color.BLACK);

        text.setFont(Font.font(100));
        text.setFill(Color.CRIMSON);

        setAlignment(Pos.CENTER);
        getChildren().addAll(border, text);

        setOnMouseClicked(event -> {
            if (!canPlay)
                return;

            if (event.getButton() == MouseButton.PRIMARY) {
                moveCounter++;
                if (!Move)
                    return;
                if (!TileTaken1.isEmpty()) {
                    drawX();
                    Move = false;
                    WinCheck.winCheck();
                }
            }
            else if (event.getButton() == MouseButton.SECONDARY) {
                moveCounter++;
                if (Move)
                    return;
                if (!TileTaken1.isEmpty()) {
                    drawO();
                    Move = true;
                    WinCheck.winCheck();
                }
            }
            if (moveCounter >= 9) {
                playDrawAnimation();
                //System.exit(0);
            }
        });
    }

    public double getCenterX() {
        return getTranslateX() + 100;
    }

    public double getCenterY() {
        return getTranslateY() + 100;
    }

    public String getValue() {
        return text.getText();
    }

    public void drawX() {
        if (Move & tileTaken)
        text.setText("X");
    }

    public void drawO() {
        text.setText("O");
    }
}

