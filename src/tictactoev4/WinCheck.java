package tictactoev4;

public class WinCheck {
    public static void winCheck() {
        for (Combo combo : TicTacToev4.WinningMove) {
            if (combo.isComplete()) {
                TicTacToev4.canPlay = false;
                PlayWinAnimation.playWinAnimation(combo);
                break;
            }
        }
    }
}
