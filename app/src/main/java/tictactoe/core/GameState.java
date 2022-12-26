package tictactoe;


class GameState {

    public enum Player {
        PLAYER_NONE,
        PLAYER_A,
        PLAYER_B
    }

    public char[] cells = new char[9];
    public Player activePlayer = Player.PLAYER_NONE;
}
