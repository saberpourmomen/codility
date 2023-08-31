import common.TestData;
import models.Move;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DijkstraTest {
    @Test
    void deliverySystemTest(){
        MailDeliverySystem deliverySystem= new MailDeliverySystem(TestData.nodes,TestData.edges,TestData.trains,TestData.packages);
        List<Move> result=deliverySystem.mailDelivery();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.get(result.size()-1).getDroppedOffPackage(),TestData.p1);
        Assertions.assertEquals(result.get(result.size()-1).getDestinationNode(),TestData.p1.getDestinationNode());
        Assertions.assertEquals(result.get(0).getStartingNode(),TestData.t1.getStartingNode());
   }
}
