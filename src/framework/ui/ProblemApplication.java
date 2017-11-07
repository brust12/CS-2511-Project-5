package framework.ui;

import domains.arithmetic.ArithmeticProblem;
import domains.dummy.DummyProblem;
import domains.farmer.FarmerProblem;
import domains.puzzle.PuzzleCanvas;
import domains.puzzle.PuzzleProblem;
import domains.puzzle.PuzzleState;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.stage.Stage;

/**
 * This class presents problem solving domains in a tabbed pane.
 */
public class ProblemApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        
        Dummy = new ProblemGUI(new DummyProblem(), 750, 550);
	Tab tab = new Tab();
        tab.setText("Dummy");
        tab.setContent(Dummy);
        
        Arithmetic = new ProblemGUI(new ArithmeticProblem(), 750, 550);
	Tab tab1 = new Tab();
        tab1.setText("Arithmetic");
        tab1.setContent(Arithmetic);
        
        farmer = new ProblemGUI(new FarmerProblem(), 750, 550);
	Tab tab2 = new Tab();
        tab2.setText("Farmer");
        tab2.setContent(farmer);
        
        int[][] starttiles = {{2, 8, 3},{1, 6 ,4},{7, 0, 5}};
        int[][] finaltiles = {{1, 2, 3},{8, 0 ,4},{7, 6, 5}};
        eight = new ProblemGUI(new PuzzleProblem(), 750, 550, new PuzzleCanvas(new PuzzleState(starttiles)),new PuzzleCanvas(new PuzzleState(finaltiles)));
	Tab tab3 = new Tab();
        tab3.setText("8-Puzzle");
        tab3.setContent(eight);
        
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        tabPane.getTabs().addAll(tab,tab1,tab2,tab3);
        Scene scene = new Scene(tabPane);
        primaryStage.setTitle("Problem Solver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    private ProblemGUI farmer;
    private ProblemGUI Dummy;
    private ProblemGUI Arithmetic;
    private ProblemGUI eight;
}