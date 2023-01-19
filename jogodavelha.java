import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private static final int BOARD_SIZE = 3;
    private static final int BUTTON_SIZE = 100;

    private Button[][] buttons = new Button[BOARD_SIZE][BOARD_SIZE];
    private boolean playerX = true;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, BOARD_SIZE * BUTTON_SIZE, BOARD_SIZE * BUTTON_SIZE);

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Button button = new Button();
                button.setMinSize(BUTTON_SIZE, BUTTON_SIZE);
                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (button.getText().isEmpty()) {
                            if (playerX) {
                                button.setText("X");
                            } else {
                                button.setText("O");
                            }
                            playerX = !playerX;
                        }
                    }
                });
                buttons[row][col] = button;
                grid.add(button, col, row);
            }
        }

        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
