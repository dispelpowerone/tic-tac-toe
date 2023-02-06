package tictactoe.client;

import tictactoe.core.EventStream;
import tictactoe.core.Event;
import tictactoe.core.board.BoardMasterController;
import tictactoe.core.board.BoardClientController;
import tictactoe.core.board.BoardData;
import tictactoe.core.board.BoardState;
// Transitions and states
import tictactoe.core.board.*;

import java.util.Scanner;

public class GameController {

    private BoardMasterController boardMasterController = new BoardMasterController();
    private BoardClientController boardPlayerController = new BoardClientController();
    private EventStream playerInputStream = new EventStream();
    private EventStream playerMasterStream = new EventStream();
    private EventStream materInputStream = new EventStream();
    private EventStream masterOutputStream = new EventStream();
    private Scanner inputScanner;
    private BoardData.Player currentPlayer;

    public GameController() {
        // Master controller
        boardMasterController.setInputStream(materInputStream);
        boardMasterController.setOutputStream(masterOutputStream);

        // Player controller
        boardPlayerController.setPlayerInputStream(playerInputStream);
        boardPlayerController.setMasterInputStream(playerMasterStream);
        boardPlayerController.setOutputStream(materInputStream);

        // Hook up stdin
        inputScanner = new Scanner(System.in);
    }

    public void update() {
        boardPlayerController.update();
        boardMasterController.update();
        readMasterEvents();
        boardPlayerController.update();
    }

    private void readMasterEvents() {
        Event event;
        while ((event = masterOutputStream.read()) != null) {
            if (event instanceof BoardEvent) {
                playerMasterStream.write(event);
            }
            else {
                System.out.printf("GameController::readMasterEvents: Skip event: %s\n", event);
            }
        }
    }

    public void draw() {
        drawBoard(boardPlayerController.getBoardData());
        drawCommands(boardPlayerController.getBoardState());
        readPlayerCommand();
    }

    private void drawBoard(BoardData boardData) {
        char[] cells = boardData.getCells();
        System.out.printf("+---+---+---+\n");
        System.out.printf("| %s | %s | %s |\n", cells[0],  cells[1], cells[2]);
        System.out.printf("+---+---+---+\n");
        System.out.printf("| %s | %s | %s |\n", cells[3],  cells[4], cells[5]);
        System.out.printf("+---+---+---+\n");
        System.out.printf("| %s | %s | %s |\n", cells[6],  cells[7], cells[8]);
        System.out.printf("+---+---+---+\n");
    }

    private void drawCommands(BoardState boardState) {
        System.out.printf("State: %s\n", boardState.toString());
        if (boardState instanceof InitialState) {
            System.out.println("Commands: s");
        }
        else if (boardState instanceof WaitForPickState) {
            currentPlayer = ((WaitForPickState)boardState).getPlayer();
            System.out.println("Commands: 1-9");
        }
        else {
            System.out.println("Commands: none");
        }
    }

    private void readPlayerCommand() {
        String input = inputScanner.nextLine();
        if (input.isEmpty()) {
            return;
        }

        char command = input.charAt(0);

        Event event = null;
        if (command == 's') {
            event = GameStartedUpdate.builder()
                .actorId(Long.valueOf(2))
                .build();
        }
        else if (command >= '1' && command <= '9') {
            event = CellPickedUpdate.builder()
                .actorId(Long.valueOf(2))
                .player(currentPlayer)
                .cellIndex(command - '1')
                .build();
        }

        if (event != null) {
            playerInputStream.write(event);
        }
    }
}
