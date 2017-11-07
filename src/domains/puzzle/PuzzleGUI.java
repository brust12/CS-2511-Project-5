package domains.puzzle;
import framework.ui.ProblemGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PuzzleGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        int[][] starttiles = {{2, 8, 3},{1, 6 ,4},{7, 0, 5}};
        int[][] finaltiles = {{1, 2, 3},{8, 0 ,4},{7, 6, 5}};
        Scene scene = new Scene(new ProblemGUI(new PuzzleProblem(), 700, 600, new PuzzleCanvas(new PuzzleState(starttiles)),new PuzzleCanvas(new PuzzleState(finaltiles))));
	primaryStage.setTitle("Testing Puzzle GUI");
	primaryStage.setScene(scene);
	primaryStage.show();
    }

    public static void main(String[] args) {
	launch(args);
        
    }
}