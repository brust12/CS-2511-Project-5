package domains.farmer;

import framework.ui.ProblemConsole;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Riley Brust
 */
public class FarmerConsole extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new ProblemConsole(new FarmerProblem(), 550, 650));
        primaryStage.setTitle("Testing FWGC Console");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}