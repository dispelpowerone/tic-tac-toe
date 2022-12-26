package tictactoe;


class GameController {

    GameState gameState = new GameState();
    GameMechanics gameMechanics = new GameMechanics();
    GameListener gameListener;

    public GameController() {
    }

    public void update() {
        while (true) {
            GameAction nextAction = gameMechanics.nextAction(gameState);
            if (nextAction == null) {
                break;
            }
            nextAction.apply(gameState);
            //gameListener.push(nextAction);
        }
    }

    public void applyAction(GameAction action) {
        action.apply(gameState);
    }
}
