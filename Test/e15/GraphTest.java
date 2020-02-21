package e15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {

    private static Graph graph;

    @BeforeAll
    public static void initializeGraph(){
        graph = new Graph();
        Node node= new Node(1, "amad", "siria", "26","programmer" , "single");
        graph.addNodes(node);
        Node node1= new Node(2,"Ramiro" ,"argentina","21","programmador" ,"single");
        graph.addNodes(node1);
    }
    @Test
    public void searchAmplitudeTest () throws NotFoundUserException {

        assertEquals("amad", graph.searchAmplitude("amad", 1).getName());
    }
    @Test()
    public void searchAmplitudeExpectedNotFoundUserTest (){
        Assertions.assertThrows(NotFoundUserException.class,() -> graph.searchAmplitude("amad", 3) );

    }
}
