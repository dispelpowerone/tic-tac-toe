package tictactoe;


class GameActivatePlayer extends GameAction {

    public GameState.Player player;

    public GameActivatePlayer(GameState.Player player) {
        this.player = player;
    }

    @Override
    public void apply(GameState gameState) {
        gameState.activePlayer = player;
    }
}
