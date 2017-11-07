
package framework.solution;

import framework.graph.Vertex;

/**
 *
 * @author Riley Brust
 * 1:00PM
 */
public class Solution {

    /**
     * Creates an object that represents a path from a start
     * vertex to an end vertex in a problem solving domain.
     * This constructor will be called after a search has been
     * initiated on the start vertex.
     * If a path from start to end exists, it can be constructed
     * from the predecessor information stored in the end vertex.
     * @param start the start vertex
     * @param end the end vertex
     */
    public Solution(Vertex start, Vertex end) {
        startV = start;
        endV   = end;
        index  = getLength()+1;
    }

    /**
     * Gets the length of the solution, that is, the number of moves
     * to get to the end state from the start.
     * @return the solution length
     */
    public int getLength() {
        int i = 0;
        Vertex one = endV;
        while(one.getPredecessor()!= null){
            i++;
            one = one.getPredecessor();
        }
         return i;
    }
    
    /**
     * Checks whether there are more vertices in this solution.
     * @return true if there are more vertices in this solution, false
     * otherwise
     */
    public boolean hasNext() {
        if(index > 0)
            return true;
        else
            return false;
    }
    
    /**
     * Removes and returns the next vertex in this solution.
     * @return the next vertex in this solution
     * @throws RuntimeException if there are no more vertices
     */
    public Vertex next() {
        Vertex one = endV;
       if(hasNext()){
           index--;
           for(int i = 0; i < index;i++){
               one = one.getPredecessor();
           }
       }
       return one;
    }
    
    /* private instance fields and methods here */
    private Vertex startV;
    private Vertex endV;    
    private static int index;
}