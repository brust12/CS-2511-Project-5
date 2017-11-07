/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.puzzle;

import domains.puzzle.PuzzleState.Location;
import framework.problem.State;
import framework.ui.ProblemCanvas;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author Riley
 */
public class PuzzleCanvas extends Pane implements ProblemCanvas{
    @Override
    public void update(State state){
       PuzzleState newState = (PuzzleState)state;
       int i = 0;
       Label[] tileLab = {blankt,onelabel, two, three, four, five, six, sev,eight};
       for (Label t : tileLab){
            Location newLoca = newState.getLocation(i);
            Location old = curState.getLocation(i);
            TranslateTransition translate = new TranslateTransition(Duration.millis((double)750));
            translate.setNode(t);
            translate.setByX(getX(newLoca, old));
            translate.setByY(getY(newLoca, old));
            translate.play();
            i++;
       }

    curState = (PuzzleState)state;

    }
    public PuzzleCanvas(State initial){
       curState = (PuzzleState)initial;
       super.setWidth(300);
       super.setHeight(300);
       //Tile 1
       onelabel = new Label("1");
       onelabel.setTextFill(Color.DARKBLUE);
       onelabel.setPrefWidth(60);
       onelabel.setPrefHeight(60);
       onelabel.setAlignment(Pos.CENTER);
       onelabel.setFont(Font.font("DejaVu Sans Mono", 40));
       onelabel.setStyle("-fx-background-color: azure;-fx-background-radius: 10px;");
       setPosition(onelabel,curState.getLocation(1));
       //Tile 2
       two = new Label("2");
       two.setTextFill(Color.DARKBLUE);
       two.setPrefWidth(60);
       two.setPrefHeight(60);
       two.setAlignment(Pos.CENTER);
       two.setFont(Font.font("DejaVu Sans Mono", 40));
       two.setStyle("-fx-background-color: azure;-fx-background-radius: 10px;");
       setPosition(two, curState.getLocation(2)); 
       //Tile 3
       three = new Label("3");
       three.setTextFill(Color.DARKBLUE);
       three.setPrefWidth(60);
       three.setPrefHeight(60);
       three.setAlignment(Pos.CENTER);
       three.setFont(Font.font("DejaVu Sans Mono", 40));
       three.setStyle("-fx-background-color: azure;-fx-background-radius: 10px;");
       setPosition(three, curState.getLocation(3)); 
       //Tile 4
       four = new Label("4");
       four.setTextFill(Color.DARKBLUE);
       four.setPrefWidth(60);
       four.setPrefHeight(60);
       four.setAlignment(Pos.CENTER);
       four.setFont(Font.font("DejaVu Sans Mono", 40));
       four.setStyle("-fx-background-color: azure;-fx-background-radius: 10px;");
       setPosition(four, curState.getLocation(4)); 
       //Tile 5
       five = new Label("5");
       five.setTextFill(Color.DARKBLUE);
       five.setPrefWidth(60);
       five.setPrefHeight(60);
       five.setAlignment(Pos.CENTER);
       five.setFont(Font.font("DejaVu Sans Mono", 40));
       five.setStyle("-fx-background-color: azure;-fx-background-radius: 10px;");
       setPosition(five, curState.getLocation(5)); 
       // Tile 6
       six = new Label("6");
       six.setTextFill(Color.DARKBLUE);
       six.setPrefWidth(60);
       six.setPrefHeight(60);
       six.setAlignment(Pos.CENTER);
       six.setFont(Font.font("DejaVu Sans Mono", 40));
       six.setStyle("-fx-background-color: azure;-fx-background-radius: 10px;");
       setPosition(six, curState.getLocation(6)); 
       //Tile 7
       sev = new Label("7");
       sev.setTextFill(Color.DARKBLUE);
       sev.setPrefWidth(60);
       sev.setPrefHeight(60);
       sev.setAlignment(Pos.CENTER);
       sev.setFont(Font.font("DejaVu Sans Mono", 40));
       sev.setStyle("-fx-background-color: azure;-fx-background-radius: 10px;");
       setPosition(sev, curState.getLocation(7)); 
       //Tile 8
       eight = new Label("8");
       eight.setTextFill(Color.DARKBLUE);
       eight.setPrefWidth(60);
       eight.setPrefHeight(60);
       eight.setAlignment(Pos.CENTER);
       eight.setFont(Font.font("DejaVu Sans Mono", 40));
       eight.setStyle("-fx-background-color: azure;-fx-background-radius: 10px;");
       setPosition(eight, curState.getLocation(8)); 
       //Blank
       blankt = new Label();
       setPosition(blankt, curState.getLocation(0)); 
       
       
       
       
       
       one = new StackPane();
       one.setPrefHeight(200);
       one.setPrefWidth(200);
       one.setStyle("-fx-background-color: gray;");
       one.getChildren().addAll(onelabel,two,three, four, five, six,sev,eight);
       super.getChildren().addAll(one);
    }
    private void setPosition(Label label, Location loc){
        if(loc.getColumn() == 0 && loc.getRow() == 0){
            label.setTranslateX(-65);
            label.setTranslateY(-65);
        }else if(loc.getColumn() == 1 && loc.getRow() == 0){
            label.setTranslateX(0);
            label.setTranslateY(-65);
        }else if(loc.getColumn() == 2 && loc.getRow() == 0){
            label.setTranslateX(65);
            label.setTranslateY(-65);
        }else if(loc.getColumn() == 0 && loc.getRow() == 1){
            label.setTranslateX(-65);
        }else if(loc.getColumn() == 1 && loc.getRow() == 1){
            
        }else if(loc.getColumn() == 2 && loc.getRow() == 1){
            label.setTranslateX(65);
        }else if(loc.getColumn() == 0 && loc.getRow() == 2 ){
            label.setTranslateX(-65);
            label.setTranslateY(65);
        }else if(loc.getColumn() == 1 && loc.getRow() == 2){
            label.setTranslateY(65);
        }else if(loc.getColumn() == 2 && loc.getRow() == 2){
            label.setTranslateX(65);
            label.setTranslateY(65);
        }
 
    }
    
    private double getX(Location newLo, Location old){
        int i = newLo.getColumn();
        int j = old.getColumn();
        double ret = (colMove(i) - colMove((int) j));
       // System.out.println("New Col:"+i+"- Old Col:"+j);
        return ret;
    }
    private double colMove(int i){
        if(i == 0){
            return -65;
        }else if(i == 1){
            return 0;
            
        }else if (i ==2){
            return 65;
            
        }
        return 0;
    }
    private double getY(Location newLo, Location old){
        int i = newLo.getRow();
        int j = old.getRow();
        double ret = (colMove(i) - colMove(j));
       // System.out.println("Y Move:"+ret);
        return ret;
    }

    
    
    
    
   private PuzzleState curState;
   private VBox blank;
   private StackPane one;
   private Label onelabel;
   private Label two;
   private Label three;
   private Label four;
   private Label five;
   private Label six;
   private Label sev;
   private Label eight;
   private Label blankt;
}
