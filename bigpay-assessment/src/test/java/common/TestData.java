package common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.Edge;
import models.Node;
import models.Package;
import models.Train;

import java.util.List;
public class TestData {
    public static Node n1=new Node("1");
    public static Node n2=new Node("2");
    public static Node n3=new Node("3");
    public static Node n4=new Node("4");
    public static List<Node> nodes =List.of(n1,n2,n3,n4);
    public static Edge edge1=new Edge("e1",n1,n2,5);
    public static Edge edge2=new Edge("e2",n1,n4,11);
    public static Edge edge3=new Edge("e3",n2,n3,3);
    public static Edge edge4=new Edge("e4",n3,n4,2);
    public static List<Edge> edges= List.of(edge1,edge2,edge3,edge4);
    public static Train t1= new Train("t1",7,n3);
    public static List<Train> trains=List.of(t1);
    public static Package p1=new Package("p1",5,n1,n4);
    public static List<Package> packages=List.of(p1);
}
