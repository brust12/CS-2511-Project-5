package domains.farmer;

import framework.graph.Graph;
import framework.graph.Vertex;

/**
 * A graph for the FWGC problem.
 * @author Riley Brust 
 * 1:00PM
 */
public class FarmerGraph extends Graph {
    
    public FarmerGraph() {
one = new Vertex(new FarmerState("West",
                                 "West",
			         "West",
			         "West"));
two = new Vertex(new FarmerState("West",
                                 "East",
			         "West",
			         "East"));
three = new Vertex(new FarmerState("West",
                                   "East",
			           "West",
			           "West"));
four = new Vertex(new FarmerState("West",
                                 "West",
			         "East",
			         "East"));
five = new Vertex(new FarmerState("West",
                                 "West",
			         "West",
			         "East"));
six = new Vertex(new FarmerState("East",
                                 "East",
			         "East",
			         "East"));
seven = new Vertex(new FarmerState("East",
                                 "West",
			         "East",
			         "West"));
eight = new Vertex(new FarmerState("East",
                                 "West",
			         "East",
			         "East"));
nine = new Vertex(new FarmerState("East",
                                 "East",
			         "West",
			         "East"));
ten = new Vertex(new FarmerState("East",
                                 "East",
			         "East",
			         "West"));
super.addEdge(one, seven);
super.addEdge(seven, one);
super.addEdge(seven, four);
super.addEdge(four,seven);
super.addEdge(four, ten);
super.addEdge(ten, four);
super.addEdge(four, eight);
super.addEdge(eight, four);
super.addEdge(ten, three);
super.addEdge(three, ten);
super.addEdge(eight, five);
super.addEdge(five, eight);
super.addEdge(three, nine);
super.addEdge(nine, three);
super.addEdge(five, nine);
super.addEdge(nine, five);
super.addEdge(nine, two);
super.addEdge(two, nine);
super.addEdge(two, six);
super.addEdge(six, two);
    }
    
    public Vertex getStart() {
        return one;
    }
    
    public Vertex getEnd() {
        return six;
    }
    
    /* private fields and methods follow */
    
    private Vertex ret;
    private Vertex one;
    private Vertex two;
    private Vertex three;
    private Vertex four;
    private Vertex five;
    private Vertex six;
    private Vertex seven;
    private Vertex eight;
    private Vertex nine;
    private Vertex ten;
    
}