package tictactoe;


class GameMarkCell {

    public GameState.Player player;
    public int cellIndex;

    public GameMarkCell(GameState.Player player, int cellIndex) {
        this.player = player;
        this.cellIndex = cellIndex;
    }

    public void apply(GameState gameState) {
        char mark = (player == GameState.Player.PLAYER_A) ? 'X' : 'O';
        gameState.cells[cellIndex] = mark;
    }
}
