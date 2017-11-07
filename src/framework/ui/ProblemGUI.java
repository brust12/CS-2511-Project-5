package framework.ui;
import domains.puzzle.PuzzleCanvas;
import framework.problem.Mover;
import javafx.scene.layout.VBox;
import framework.problem.Problem;
import framework.solution.SolvingAssistant;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class ProblemGUI extends VBox {
    
    public ProblemGUI(Problem problem, double width, double height) {
       
        welcomeMessage = new Label();
        welcomeMessage.setText("Welcome to the "+problem.getName()+" problem.");
        welcomeMessage.setFont(Font.font("DejaVu Sans Mono", 30));
        welcomeMessage.setWrapText(true);
        welcomeMessage.setTextAlignment(TextAlignment.CENTER);
        welcomeMessage.setPadding(new Insets(5));
        welcomeMessage.setStyle("-fx-background-color: azure");
        welcomeMessage.setPrefWidth(width-100);
        welcomeMessage.setAlignment(Pos.CENTER);
        intro = new Label();
        intro.setText(problem.getIntroduction());
        intro.setStyle("-fx-font: 15 arial;");
        intro.setPadding(new Insets(5));
        intro.setWrapText(true);
        intro.setStyle("-fx-background-color: aliceblue");
        intro.setPrefWidth(width-100);
        intro.setTextAlignment(TextAlignment.CENTER);
        intro.setAlignment(Pos.CENTER);
        super.setPrefHeight(height);
        super.setPrefWidth(width);
        currentStateBox = new VBox();
        CurrentStatelabel = new Label("Current State:");
        CurrentStatelabel.setFont(Font.font("DejaVu Sans Mono", 20));
        CurState = makeLabel(problem.getCurrentState().toString());
        CurState.setStyle("-fx-background-color: gray;-fx-text-fill: aliceblue");
        movessofar = new Label();
        movessofar.setText("Moves so far: 0");
        movessofar.setFont(Font.font("DejaVu Sans Mono", 20));
        states = new HBox();
        movesbox = new VBox();
        states.setAlignment(Pos.CENTER);
        
        moves = problem.getMover();
        movesbox.getChildren().add(movessofar);
        assist = new SolvingAssistant(problem);
        
        message = new Label();
        message.setFont(Font.font("DejaVu Sans Mono", 20));
        message.setTextFill(Color.RED);
        messagebox = new VBox();
        messagebox.setPadding(new Insets(10));
        

        List<String> names = moves.getMoveNames();
        for(String name :names){
            button = new Button();
            button.setText(name);
            button.setStyle("-fx-text-fill:darkblue");
            button.setMaxWidth(Double.MAX_VALUE);
            button.setOnAction(e->{
                assist.tryMove(name);
                CurState.setText(problem.getCurrentState().toString());
                movessofar.setText("Moves so far: " + assist.getMoveCount());
                 if (!assist.isMoveLegal()) {
                         message.setText("Illegal move. Try again.");
                    }
                 if (assist.isMoveLegal()) {
                         message.setText("");
                    }
                 if (assist.isProblemSolved()) {
             message.setText("You solved the problem. Congratulations.");
                 }});
            movesbox.getChildren().add(button);
            
        }
        reset = new Button();
        reset.setAlignment(Pos.CENTER);
        reset.setText("Reset");
        reset.setOnAction(e->{assist.reset();
        movessofar.setText("Moves so far: 0");
        //CurState.setText(problem.getInitialState().toString());
        message.setText("");
        });
        
        movesbox.setSpacing(10);
        movesbox.setPadding(new Insets(10));
        
        
        finalstatelabel = new Label();
        finalstatelabel.setText("Final State:");
        finalstatelabel.setFont(Font.font("DejaVu Sans Mono", 20));
        finalstate = makeLabel(problem.getFinalState().toString());
        finalstate.setStyle("-fx-background-color: gray; -fx-text-fill: aliceblue");
        finalstatebox = new VBox();
        finalstatebox.setAlignment(Pos.CENTER);
        finalstatebox.getChildren().addAll(finalstatelabel,finalstate);
        
        
        
        currentStateBox.setAlignment(Pos.CENTER);
        messagebox.setAlignment(Pos.CENTER);
        messagebox.getChildren().addAll(message,reset);
        currentStateBox.getChildren().addAll(CurrentStatelabel,CurState);
        states.getChildren().addAll(currentStateBox,movesbox,finalstatebox);
        super.setAlignment(Pos.CENTER);
        super.getChildren().addAll(welcomeMessage,intro,states,messagebox);

    }
    
    
    
    
    public ProblemGUI(Problem problem, double width, double height, ProblemCanvas initial, ProblemCanvas end) {
        init = initial;
        welcomeMessage = new Label();
        welcomeMessage.setText("Welcome to the "+problem.getName()+" problem.");
        welcomeMessage.setFont(Font.font("DejaVu Sans Mono", 30));
        welcomeMessage.setWrapText(true);
        welcomeMessage.setTextAlignment(TextAlignment.CENTER);
        welcomeMessage.setPadding(new Insets(5));
        welcomeMessage.setStyle("-fx-background-color: azure");
        welcomeMessage.setPrefWidth(width-100);
        welcomeMessage.setAlignment(Pos.CENTER);
        intro = new Label();
        intro.setText(problem.getIntroduction());
        intro.setStyle("-fx-font: 15 arial;");
        intro.setPadding(new Insets(5));
        intro.setWrapText(true);
        intro.setStyle("-fx-background-color: aliceblue");
        intro.setPrefWidth(width-100);
        intro.setTextAlignment(TextAlignment.CENTER);
        intro.setAlignment(Pos.CENTER);
        super.setPrefHeight(height);
        super.setPrefWidth(width);
        currentStateBox = new VBox();
        CurrentStatelabel = new Label("Current State:");
        CurrentStatelabel.setFont(Font.font("DejaVu Sans Mono", 20));
       
        cur = (PuzzleCanvas)initial;
        
        
        
        movessofar = new Label();
        movessofar.setText("Moves so far: 0");
        movessofar.setFont(Font.font("DejaVu Sans Mono", 20));
        states = new HBox();
        movesbox = new VBox();
        states.setAlignment(Pos.CENTER);
        
        moves = problem.getMover();
        movesbox.getChildren().add(movessofar);
        assist = new SolvingAssistant(problem);
        
        message = new Label();
        message.setFont(Font.font("DejaVu Sans Mono", 20));
        message.setTextFill(Color.RED);
        messagebox = new VBox();
        messagebox.setPadding(new Insets(10));
        

        List<String> names = moves.getMoveNames();
        for(String name :names){
            button = new Button();
            button.setText(name);
            button.setStyle("-fx-background-color: aliceblue;-fx-text-fill: darkblue; -fx-border-color: gray; -fx-border-width: 2px;");
            
            button.setMaxWidth(Double.MAX_VALUE);
            button.setOnAction(e->{
                assist.tryMove(name);
                
                //System.out.println(problem.getCurrentState().toString());
                movessofar.setText("Moves so far: " + assist.getMoveCount());
                 if (!assist.isMoveLegal()) {
                         message.setText("Illegal move. Try again.");
                    }
                 if (assist.isMoveLegal()) {
                         message.setText("");
                         cur.update(problem.getCurrentState());
                    }
                 if (assist.isProblemSolved()) {
             message.setText("You solved the problem. Congratulations.");
                 }});
            movesbox.getChildren().add(button);
            
        }
        reset = new Button();
        reset.setStyle("-fx-background-color: aliceblue;-fx-text-fill: red; -fx-border-color: gray; -fx-border-width: 2px;");
        reset.setAlignment(Pos.CENTER);
        reset.setText("Reset");
        reset.setOnAction(e->{assist.reset();
        movessofar.setText("Moves so far: 0");
        cur.update(problem.getInitialState());
        message.setText("");
        });
        
        movesbox.setSpacing(10);
        movesbox.setPadding(new Insets(10));
        
        
        finalstatelabel = new Label();
        finalstatelabel.setText("Final State:");
        finalstatelabel.setFont(Font.font("DejaVu Sans Mono", 20));
        finalcanvas = (PuzzleCanvas)end;
        finalstatebox = new VBox();
        finalstatebox.setAlignment(Pos.CENTER);
        finalstatebox.getChildren().addAll(finalstatelabel,finalcanvas);
        
        
        
        currentStateBox.setAlignment(Pos.CENTER);
        messagebox.setAlignment(Pos.CENTER);
        messagebox.getChildren().addAll(message,reset);
        currentStateBox.getChildren().addAll(CurrentStatelabel,cur);
        states.getChildren().addAll(currentStateBox,movesbox,finalstatebox);
        super.setAlignment(Pos.CENTER);
        super.getChildren().addAll(welcomeMessage,intro,states,messagebox);
    }
    
    
    
    private Label makeLabel(String text){
        Label returnLabel = new Label();
        returnLabel.setText(text );
        returnLabel.setBorder(new Border(new BorderStroke(Color.DARKBLUE, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        returnLabel.setFont(Font.font("Monospaced", 25));
        returnLabel.setPadding(new Insets(8));

        
        return returnLabel;
    }
    
    /* Instance fields and helper methods here */
    private Label welcomeMessage;
    private Label intro;
    private HBox states;
    private VBox currentStateBox;
    private VBox movesbox;
    private Label CurrentStatelabel;
    private Label CurState;
    private VBox finalstatebox;
    private Label finalstate;
    private Label finalstatelabel;
    private Label movessofar;
    private Mover moves;
    private Button button;
    private SolvingAssistant assist;
    private Label message;
    private VBox messagebox;
    private Button reset;
    private ProblemCanvas init;
    private PuzzleCanvas cur;
    private PuzzleCanvas finalcanvas;
}