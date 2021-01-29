package tictactoev4;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TicTacToev4 extends Application {
    public static boolean canPlay = true;
    public static boolean Move = true;
    public static boolean tileTaken = true;
    public static Tile[][] TicTacToeBoard = new Tile[3][3];
    public static List<Combo> WinningMove = new ArrayList<>();
    public static List<TileTaken> TileTaken1 = new ArrayList<>();
    public static Pane root = new Pane();
    public static int moveCounter;

    public Parent createContent() {
        root.setPrefSize(600, 625);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 180);

                root.getChildren().add(tile);

                TicTacToeBoard[j][i] = tile;

            }
        }

        TileTaken1.add(new TileTaken(TicTacToeBoard[0][0], TicTacToeBoard[0][1], TicTacToeBoard[0][2],
        TicTacToeBoard[1][0], TicTacToeBoard[1][1], TicTacToeBoard[1][2], TicTacToeBoard[2][0],
        TicTacToeBoard[2][1], TicTacToeBoard[2][2]));

        WinningMove.add(new Combo(TicTacToeBoard[0][0], TicTacToeBoard[1][1], TicTacToeBoard[2][2]));
        WinningMove.add(new Combo(TicTacToeBoard[2][0], TicTacToeBoard[1][1], TicTacToeBoard[0][2]));

        for (int y = 0; y < 3; y++) {
            WinningMove.add(new Combo(TicTacToeBoard[0][y], TicTacToeBoard[1][y], TicTacToeBoard[2][y]));
        }

        for (int x = 0; x < 3; x++) {
            WinningMove.add(new Combo(TicTacToeBoard[x][0], TicTacToeBoard[x][1], TicTacToeBoard[x][2]));
        }
        return root;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}