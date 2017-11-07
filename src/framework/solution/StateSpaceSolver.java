package framework.solution;

import framework.graph.Vertex;
import framework.problem.Problem;
import framework.problem.State;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * This class represents a state space solver by extending the abstract
 * Solver class.
 * @author Your name and section here
 */
public class StateSpaceSolver extends Solver {
    
    /**
     * Creates a BFS or DFS state space solver.
     * This constructor should set the queue to a double-ended queue (DEQUE)
     * and set the statistics header.
     * @param problem the problem being solved
     * @param bfs a boolean flag indicating whether BFS is to be performed
     */
    public StateSpaceSolver(Problem problem, boolean bfs) {
        super(problem);
        this.bfs = bfs;
        deq = new LinkedList();
        super.setQueue(this.deq);
        
        /* you must provide */
    }
    
    /**
     * Adds a vertex to the DEQUE.
     * If BFS is being performed, the vertex should be added to the
     * end of the DEQUE, so the DEQUE acts like an ordinary queue.
     * If DFS is being performed, the vertex should be added to the
     * front of the DEQUE, so the DEQUE acts like a stack.
     * @param v 
     */
    @Override
    public void add(Vertex v) {
        if(bfs){
            deq.addLast(v);
        }else{
            deq.addFirst(v);
        }
    }
    
    /**
     * This method implements the expand operation required by the 
     * state space search algorithm:

       Expand(u)
          children = {}
          for each name ∈ moveNames do
             child = mover.doMove(name, u)
             if child ≠ null and not OccursOnPath(child, u)
                then d[child] = d[u] + 1
                     pred[child] = u
                     add child to children
          return children

     * @param u the vertex being expanded
     * @return 
     */
    @Override
    public List<Vertex> expand(Vertex u) {
        List<Vertex> list = new LinkedList();
        for(String name : super.getProblem().getMover().getMoveNames()){
            Vertex child = new Vertex(super.getProblem().getMover().doMove(name, (State)u.getData()));
            if( child.getData() != null && !occursOnPath(child, u)){
                child.setDistance(u.getDistance()+1);
                child.setPredecessor(u);
                list.add(child);
            }
        }
        return list;
    }

    /**
     * Checks whether a given vertex appears on the predecessor path
     * of a given ancestor.
     * @param v the vertex to check
     * @param ancestor the ancestor vertex of v
     * @return true if v occurs on the predecessor path of ancestor,
     * false otherwise
     */
    public static boolean occursOnPath(Vertex v, Vertex ancestor) {
        while(ancestor != null){
            if(ancestor.getData().equals( v.getData())){
            return true;
            }
            ancestor = ancestor.getPredecessor();
        }
        return false;
    }
    
    /* private instance fields here */
    private boolean bfs;
    private LinkedList<Vertex> deq;
}