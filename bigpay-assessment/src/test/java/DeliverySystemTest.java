import common.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeliverySystemTest {
    @Test
    void dijkstraTest(){
        Dijkstra dijkstra= new Dijkstra(TestData.edges,TestData.nodes,TestData.t1.getStartingNode());
        Assertions.assertNotNull(dijkstra);
        Assertions.assertEquals(dijkstra.getDistances().size(),4);
        Assertions.assertEquals(dijkstra.getPreviousNodes().size(),3);
        Assertions.assertEquals(dijkstra.getPreviousEdges().size(),3);
        Assertions.assertEquals(dijkstra.getDistances().get(TestData.n4),2);
        Assertions.assertEquals(dijkstra.getPreviousEdges().get(TestData.n2),TestData.edge3);
        Assertions.assertEquals(dijkstra.getPreviousNodes().get(TestData.n2),TestData.n3);

    }
}
