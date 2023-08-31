import models.*;
import models.Package;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws Exception{
        Node nodeA=new Node("A");
        Node nodeB=new Node("B");
        Node nodeC=new Node("C");
        Node nodeD=new Node("D");
        Node nodeE=new Node("E");
        Node nodeF=new Node("F");
        Node nodeG=new Node("G");
        Node nodeH=new Node("H");
        Node nodeI=new Node("I");

        Edge edge1=new Edge("edge1",nodeA,nodeB,5);
        Edge edge2=new Edge("edge2",nodeA,nodeD,3);
        Edge edge3=new Edge("edge3",nodeB,nodeD,8);
        Edge edge4=new Edge("edge4",nodeB,nodeI,5);
        Edge edge5=new Edge("edge5",nodeB,nodeF,3);
        Edge edge6=new Edge("edge6",nodeC,nodeD,6);
        Edge edge7=new Edge("edge7",nodeC,nodeE,7);
        Edge edge8=new Edge("edge8",nodeC,nodeH,5);
        Edge edge9=new Edge("edge9",nodeD,nodeF,3);
        Edge edge10=new Edge("edge10",nodeE,nodeF,10);
        Edge edge11=new Edge("edge11",nodeE,nodeG,8);
        Edge edge12=new Edge("edge12",nodeF,nodeI,7);
        Edge edge13=new Edge("edge13",nodeF,nodeG,11);

        Package package1=new Package("k1",5,nodeE,nodeI);
        Package package2=new Package("k2",7,nodeA,nodeG);
        Package package3=new Package("k3",9,nodeH,nodeF);

        Train train1=new Train("Q1",6,nodeB);
        Train train2=new Train("Q2",12,nodeC);
        Train train3=new Train("Q3",16,nodeF);

        MailDeliverySystem system=new MailDeliverySystem(List.of(nodeA,nodeB,nodeC,nodeD,nodeE,nodeF,nodeG,nodeH,nodeI),List.of(edge1,edge2,edge3,edge4,edge5,edge6,edge7,edge8,edge9,edge10,edge11,edge12,edge12),List.of(train1,train2,train3),List.of(package1,package2,package3));
        List<Move> moveList=system.mailDelivery();
        for (Move move : moveList) {
            System.out.println("W=" + move.getMovingTime() + ", T=" + move.getTrain().getTrainName() + ", N1=" + move.getStartingNode().getName() +
                    ", P1=" +((move.getPickedUpPackage()!=null)?move.getPickedUpPackage().getPackageName():"") + ", N2=" + move.getDestinationNode().getName() + ", P2=" + ((move.getDroppedOffPackage()!=null)?move.getDroppedOffPackage().getPackageName():""));
        }
    }
}
