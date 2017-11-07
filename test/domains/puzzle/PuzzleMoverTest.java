package domains.puzzle;

import framework.problem.Mover;
import framework.problem.State;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Riley Brust
 */
public class PuzzleMoverTest {
        
    /**
     * Declare private instance fields here. For example:
     */
    
    private final State start;
    private final Mover mover;
    private final String slide1, slide2, slide3, slide4,  // move names
	                 slide5, slide6, slide7, slide8;
    private int[][] starttiles = {{2, 8, 3},{1, 6 ,4},{7, 0, 5}};
    private final List<String> moveNames;
    private State next;
    int[][] afterslide6 = {{2, 8, 3},{1, 0 ,4},{7, 6, 5}};
    
    public PuzzleMoverTest() {
        start = new PuzzleState(starttiles);
        mover = new PuzzleMover();
        moveNames = mover.getMoveNames();
        slide1 = moveNames.get(0);
        slide2 = moveNames.get(1);
        slide3 = moveNames.get(2);
        slide4 = moveNames.get(3);
        slide5 = moveNames.get(4);
        slide6 = moveNames.get(5);
        slide7 = moveNames.get(6);
        slide8 = moveNames.get(7);
    }
    
    /**
     * Test all moves in the methods below by replacing the calls to fail.
     */

    @Test
    public void testSlide1() {
            
        
        
        /**
         * For example, if mover, start, and slide1 have been
         * initialized, call:
         *
         *     mover.doMove(slide1, start)
         *
         * and test the result with assertions.
         */
        next = mover.doMove(slide1, start);
       // String text = next.toString();
       // System.out.println(text);
        assertTrue(next==null);
    }

    @Test
    public void testSlide2() {
        fail("The test case has not been implemented.");        
    }

    @Test
    public void testSlide3() {
        fail("The test case has not been implemented.");        
    }

    @Test
    public void testSlide4() {
        fail("The test case has not been implemented.");        
    }

    @Test
    public void testSlide5() {
        fail("The test case has not been implemented.");        
    }

    @Test
    public void testSlide6() {
           next = mover.doMove(slide6, start);
           PuzzleState newState = new PuzzleState(afterslide6);
           assertTrue(next.equals(newState));
    }

    @Test
    public void testSlide7() {
        fail("The test case has not been implemented.");        
    }

    @Test
    public void testSlide8() {
        fail("The test case has not been implemented.");        
    }

}