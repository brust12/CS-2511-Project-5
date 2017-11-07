
package domains.puzzle;

import framework.problem.Problem;

/**
 *
 * @author Riley
 */
public class PuzzleProblem extends Problem{
            public PuzzleProblem() {
            super();
            PuzzleState startState = new PuzzleState(starttiles);
            PuzzleState finalState = new PuzzleState(finaltiles);           
            super.setName("8-Puzzle");
            super.setIntroduction(INTRO);
            super.setMover(new PuzzleMover());
            super.setInitialState(startState);
            super.setCurrentState(super.getInitialState());
            super.setFinalState(finalState);
        }

        private static final String INTRO = 
                "You are given a board in which numbered tiles can slide around."
                + " There is one blank space that holds no tile.  A legal move consists of sliding"
                + " a tile into the blank space if the tile is adjacent to it. The goal is to move "
                + "tiles around until the board looks like the final state below."
  ;
        private final int[][] starttiles = {{2, 8, 3},{1, 6 ,4},{7, 0, 5}};
        private final int[][] finaltiles = {{1, 2, 3},{8, 0 ,4},{7, 6, 5}};
        //private  final  PuzzleState startState = new PuzzleState(starttiles);
        //private  final  PuzzleState finalState = new PuzzleState(finaltiles);
}
