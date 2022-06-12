// --== CS400 File Header Information ==--
// Name: Young Yang
// Email: xyang532@wisc.edu
// Team: IC
// Role: Front End Developer
// TA: Mu Cai
// Lecturer: Gary Dahl
// Notes to Grader:

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.NoSuchElementException;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private CS400Graph<Integer> graph;
    @BeforeEach
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    public void createGraph() {
        graph = new CS400Graph<>();
        // insert verticies 0-9
        for(int i=0;i<10;i++)
            graph.insertVertex(i);
        // insert edges from Week 08. Dijkstra's Activity
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,7,2);
        graph.insertEdge(1,8,4);
        graph.insertEdge(2,4,4);
        graph.insertEdge(2,6,3);
        graph.insertEdge(3,1,6);
        graph.insertEdge(3,7,2);
        graph.insertEdge(4,5,4);
        graph.insertEdge(5,0,2);
        graph.insertEdge(5,1,4);
        graph.insertEdge(5,9,1);
        graph.insertEdge(6,3,1);
        graph.insertEdge(7,0,3);
        graph.insertEdge(7,6,1);
        graph.insertEdge(8,9,3);
        graph.insertEdge(9,4,5);
    }

    /**
     * Checks the distance/total weight cost from the vertex labelled 0 to 8
     * (should be 15), and from the vertex labelled 9 to 8 (should be 17).
     */
    @Test
    public void providedTestToCheckPathCosts() {
        assertTrue(graph.getPathCost(0,8) == 15);    
        assertTrue(graph.getPathCost(9,8) == 17);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * labelled 0 to 8, and from the vertex labelled 9 to 8.
     */
    @Test
    public void providedTestToCheckPathContents() {
        assertTrue(graph.shortestPath(0, 8).toString().equals(
            "[0, 2, 6, 3, 1, 8]"
        ));
        assertTrue(graph.shortestPath(9, 8).toString().equals(
            "[9, 4, 5, 1, 8]"
        ));
    }

    /**
     * Checks the distance/total weight cost from the vertex labelled 1 to 5
     * (should be 14).
     */
    @Test
    public void testTheFurthestPathCosts() {
        assertTrue(graph.getPathCost(1, 5) == 14);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * labelled 1 to 5.
     */
    @Test
    public void testTheFurthestPathContents() {
        assertTrue(graph.shortestPath(1, 5).toString().equals(
            "[1, 7, 0, 2, 4, 5]"
        ));
    }

    /**
     * Checks the case when the starting vertex and destination vertex are the same.
     */
    @Test
    public void testSameVertex() {
        assertTrue(graph.getPathCost(5, 5) == 0);
        assertTrue(graph.shortestPath(5, 5).toString().equals(
            "[5]"
        ));
    }

    /**
     * Tests whether throw NoSuchElementException successfully when no path from start 
     * to end can be found.
     */
    @Test
    public void testException() {
        graph.insertVertex(10);
        try {
            graph.shortestPath(0, 10);
            assertTrue(false);
        } catch (NoSuchElementException e) {
            assertTrue(true);
        }
    }
    
}