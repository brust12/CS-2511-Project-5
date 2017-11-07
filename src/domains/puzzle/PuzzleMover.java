/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains.puzzle;

import domains.puzzle.PuzzleState.Location;
import framework.problem.Mover;
import framework.problem.State;

/**
 *
 * @author Riley Brust
 */
public class PuzzleMover extends Mover {
    public static final String TILE1 = "SLIDE TILE 1";
    public static final String TILE2 = "SLIDE TILE 2";
    public static final String TILE3 = "SLIDE TILE 3";
    public static final String TILE4 = "SLIDE TILE 4";
    public static final String TILE5 = "SLIDE TILE 5";
    public static final String TILE6 = "SLIDE TILE 6";
    public static final String TILE7 = "SLIDE TILE 7";
    public static final String TILE8 = "SLIDE TILE 8";
    
    public PuzzleMover(){
        super.addMove(TILE1, s -> trySlide1(s));
        super.addMove(TILE2, s -> trySlide2(s));
        super.addMove(TILE3, s -> trySlide3(s));
        super.addMove(TILE4, s -> trySlide4(s));
        super.addMove(TILE5, s -> trySlide5(s));
        super.addMove(TILE6, s -> trySlide6(s));
        super.addMove(TILE7, s -> trySlide7(s));
        super.addMove(TILE8, s -> trySlide8(s));
        
    }
    
    private State trySlide1(State state){
        PuzzleState p = (PuzzleState) state;
        Location blank = p.getLocation(0);
        Location tile = p.getLocation(1);
        if(isvalidmove(blank, tile)){
            PuzzleState newState = slidetile(p, 1);
            return newState;
        }else{
            return null;
       }
         
    }
    private State trySlide2(State state){
        PuzzleState p = (PuzzleState) state;
        Location blank = p.getLocation(0);
        Location tile = p.getLocation(2);
        if(isvalidmove(blank, tile)){
            PuzzleState newState = slidetile(p, 2);
            return newState;
        }else{
            return null;
       }
    }
    private State trySlide3(State state){
        PuzzleState p = (PuzzleState) state;
        Location blank = p.getLocation(0);
        Location tile = p.getLocation(3);
        if(isvalidmove(blank, tile)){
            PuzzleState newState = slidetile(p, 3);
            return newState;
        }else{
            return null;
       }
    }
    private State trySlide4(State state){
        PuzzleState p = (PuzzleState) state;
        Location blank = p.getLocation(0);
        Location tile = p.getLocation(4);
        if(isvalidmove(blank, tile)){
            PuzzleState newState = slidetile(p, 4);
            return newState;
        }else{
            return null;
       }
    }
    private State trySlide5(State state){
        PuzzleState p = (PuzzleState) state;
        Location blank = p.getLocation(0);
        Location tile = p.getLocation(5);
        if(isvalidmove(blank, tile)){
            PuzzleState newState = slidetile(p, 5);
            return newState;
        }else{
            return null;
       }
    }
    private State trySlide6(State state){
        PuzzleState p = (PuzzleState) state;
        Location blank = p.getLocation(0);
        Location tile = p.getLocation(6);
        if(isvalidmove(blank, tile)){
            PuzzleState newState = slidetile(p, 6);
            return newState;
        }else{
            return null;
       }
    }
    private State trySlide7(State state){
        PuzzleState p = (PuzzleState) state;
        Location blank = p.getLocation(0);
        Location tile = p.getLocation(7);
        if(isvalidmove(blank, tile)){
            PuzzleState newState = slidetile(p, 7);
            return newState;
        }else{
            return null;
       }
    }
    private State trySlide8(State state){
        PuzzleState p = (PuzzleState) state;
        Location blank = p.getLocation(0);
        Location tile = p.getLocation(8);
        if(isvalidmove(blank, tile)){
            PuzzleState newState = slidetile(p, 8);
            return newState;
        }else{
            return null;
       }
    }
    
    private boolean isvalidmove(Location blank, Location tile )
    {
        boolean canmovecolumn = checkColumnForAdjacent(blank.getColumn(), tile.getColumn(),tile.getRow(),blank.getRow( ));
        boolean canmoverow    = checkRowForAdjacent(blank.getRow(), tile.getRow(),tile.getColumn(),blank.getColumn());
       if(canmovecolumn || canmoverow){
           return true;
       }else{
           return false;
       }
    }    
    
    private boolean checkColumnForAdjacent(int blankColNum, int tileColNum,int tilerow, int blankrow){
        int right = tileColNum+1;
        int left  = tileColNum-1;
        if(tilerow == blankrow){
            if(blankColNum == right || blankColNum == left){
             return true;
                }
            }
        return false;
    }
    private boolean checkRowForAdjacent(int blankRowNum, int tileRowNum, int tilecol, int blankcol){
        int right = tileRowNum+1;
        int left  = tileRowNum-1;
        if(tilecol == blankcol){
            if(blankRowNum == right || blankRowNum == left){
             return true;
            }
        }
        return false;
    }
    
//    private PuzzleState slidetile(PuzzleState p, int tile){
//        int[][] tiles = p.getTiles();
//        Location tileToSlide = p.getLocation(tile);
//        Location blank = p.getLocation(0);
//        tiles[blank.getRow()][blank.getColumn()] = tile;
//        tiles[tileToSlide.getRow()][tileToSlide.getColumn()] = 0;
//        
//        
//        PuzzleState returnState = new PuzzleState(tiles);
//        return returnState;
//        
//    }
        private PuzzleState slidetile(PuzzleState p, int tile){
        Location tileToSlide = p.getLocation(tile);
        Location blank = p.getLocation(0);
        PuzzleState returnState = new PuzzleState(p, blank, tileToSlide);
        return returnState;
        
    }
}
